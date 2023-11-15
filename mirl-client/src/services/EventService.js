import { useKeycloakStore } from '@/store/keycloak-store'
import { pinia } from '@/main'

export class EventService {
    keycloakStore = useKeycloakStore(pinia)

    /**
     * 
     * @param {string} mirlApiRootURL 
     */
    constructor(mirlApiRootURL) {
        this.mirlApiRootURL = mirlApiRootURL;
    }

    /**
     * 
     * @param {number} page 
     * @returns {Promise<JSON>} response
     */
    async getEvents(page) {
        await this.keycloakStore.getKeycloak.updateToken(30).then(async (result) => {
            await fetch(`${this.mirlApiRootURL}/events?page=${page}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + this.keycloakStore.getKeycloak.token
                }

            }).then((result) => {
                return result.json();
            })
        })

    }

    /**
     * 
     * @param {number} eventId 
     * @returns {Promise<JSON>} response
     */
    async getEvent(eventId) {
        await this.keycloakStore.updateToken(30);

        const response = await fetch(`${this.mirlApiRootURL}/events/${eventId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.keycloakStore.getKeycloak().token
            }

        });
        return await response.json();
    }

    /**
     * 
     * @param {Event} event 
     * @returns {Promise<JSON>} response
     */
    async createEvent(event) {
        await this.keycloakStore.updateToken(30);

        const response = await fetch(`${this.mirlApiRootURL}/events`, {
            method: 'POST',
            body: JSON.stringify(event),
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.keycloakStore.getKeycloak().token
            }
        });

        return await response.json();
    }

    async updateEvent(event) {
        await this.keycloakStore.updateToken(30);

        const response = await fetch(`${this.mirlApiRootURL}/events/${event.eventId}`, {
            method: 'PUT',
            body: JSON.stringify(event),
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.keycloakStore.getKeycloak().token
            }
        });

        return await response.json();
    }

    async deleteEvent(eventId) {
        await this.keycloakStore.updateToken(30);

        const response = await fetch(`${this.mirlApiRootURL}/events/${eventId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + this.keycloakStore.getKeycloak().token
            }
        });

        return await response.json();
    }

    async getEventAttendees(eventId, page = 0, pageSize) {
        await this.keycloakStore.updateToken(30);

        const response = await fetch(`${this.mirlApiRootURL}/events/${eventId}/attendees`);
        return await response.json();
    }

    async getEventInvitations(eventId, page = 0, pageSize, filter) {
        await this.keycloakStore.updateToken(30);

        //TODO pageSize and page
        const response = await fetch(`${this.mirlApiRootURL}/events/${eventId}/invitations`);
        return await response.json();
    }
}