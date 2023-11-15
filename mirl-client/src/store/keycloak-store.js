import { defineStore } from 'pinia'
import { ref } from 'vue'
import Keycloak from 'keycloak-js'

const initOptions = {
    url: 'http://localhost:8080/',
    realm: 'mirl',
    clientId: 'mirl-frontend',
}

export const useKeycloakStore = defineStore('keycloak', {

    state: () => ({
        keycloakInitialized: false,
        authenticated: false,
        /** @type {Keycloak} */
        keycloak: new Keycloak(initOptions),
    }),
    getters: {
        getAuthenticated() {
            return this.authenticated
        },
        getKeycloak() {
            return this.keycloak
        }
    },
    actions: {
        setAuthenticated(authenticated) {
            this.authenticated = authenticated
        },
        setKeycloak(keycloak) {
            this.keycloak = keycloak
        },
        /**
         * 
         * @param {number} minValidity (seconds)
         * @returns Promise<boolean>
         */
        updateToken(minValidity) {
            return new Promise((resolve, reject) => {
                this.keycloak.updateToken(minValidity).then((refreshed) => {
                    if (refreshed) {
                        resolve(true)
                    }
                    else {
                        reject(false)
                    }
                }).catch(() => {
                    reject(false)
                })
            })

        },
        isAuthenticated() {
            return new Promise((resolve, reject) => {
                if (this.keycloakInitialized) {
                    resolve(this.keycloak.authenticated);
                }
                else {
                    this.keycloak.init({
                        onLoad: 'check-sso',
                        checkLoginIframe: false
                    }).then((authenticated) => {
                        console.log(this.keycloak.token);
                        this.keycloakInitialized = true;
                        this.setAuthenticated(authenticated);
                        resolve(authenticated);
                    })
                }
            })
        }

    }

})