<template>
    <header>
        <div class="left-block header-block">
            <button class="header-element" style="padding: 0 15px 0 0;" type="button">
                <i class="pi pi-bars" style="font-size: 24px;"></i>
            </button>
            <router-link v-if="!keycloakStore.authenticated" to="/" id="home-link" class="header-element" type="button" hre>
                <img id="home-link-img" src="../assets/mirl-logo.png">
            </router-link>
            <router-link v-else to="/home" id="home-link" class="header-element" type="button" hre>
                <img id="home-link-img" src="../assets/mirl-logo.png">
            </router-link>
        </div>
        <div class="center-block header-block">
            <div v-if="keycloakStore.authenticated" id="searchbox-container">
                <div id="search-form-container">
                    <form id="search-form" class="header-element">
                        <div id="s"></div>
                        <input id="search-input" type="text" placeholder="Search">
                    </form>
                </div>
                <button class="header-element" id="search-button" type="button">
                    <img class="search-button-img" src="../assets/icons8-search-light.svg">
                </button>
            </div>
        </div>
        <div class="right-block header-block">
            <button v-if="!keycloakStore.authenticated" class="header-element" type="button"
                @click="this.login()">Login</button>
            <div v-else class="right-block-wrapper header-block">
                <button class="header-element" type="button" @click="toggleNotificationMenu">
                    <i class="pi pi-bell">
                        <Badge id="notification-badge" style="right: 6px;top: 5px; position: relative;"></Badge>
                    </i>
                </button>
                <button @click="toggle" aria-haspopup="true" class="header-element" type="button">
                    <img class="search-button-img" src="../assets/icons8-user-material-sharp-32.png">
                </button>
                <Menu ref="menu" id="user-menu" :model="menuItems" :popup="true">
                    <template #submenuheader="{ item }">
                        <span class="text-primary font-bold">{{ item.label }}</span>
                    </template>
                    <template #item="{ item, props }">
                        <router-link v-if="item.route" v-slot="{ href, navigate }" :to="item.route" custom>
                            <a :href="href" v-bind="props.action" @click="navigate">
                                <span :class="item.icon" />
                                <span class="ml-2">{{ item.label }}</span>
                            </a>
                        </router-link>
                        <a v-else :href="item.url" :target="item.target" v-bind="props.action">
                            <span :class="item.icon" />
                            <span class="ml-2">{{ item.label }}</span>
                        </a>
                    </template>
                    <template #end>
                        <a class="danger-zone" @click="this.logout()">
                            <span class="pi pi-sign-out" />
                            <span class="ml-2">Logout</span>
                        </a>
                    </template>
                </Menu>
                <Menu ref="notificationMenu" id="notification-menu" :model="notificationMenuItems" :popup="true">
                    <template #item="{ item, props }">
                        <router-link v-if="item.route" v-slot="{ href, navigate }" :to="item.route" custom>
                            <a :href="href" v-bind="props.action" @click="navigate">
                                <span :class="item.icon" />
                                <span class="ml-2">{{ item.label }}</span>
                            </a>
                        </router-link>
                        <a v-else :href="item.url" :target="item.target" v-bind="props.action">
                            <span :class="item.icon" />
                            <span class="ml-2">{{ item.label }}</span>
                        </a>
                    </template>
                </Menu>
            </div>

        </div>
    </header>
</template>
<script>
import { useKeycloakStore } from '@/store/keycloak-store'
import { ref } from 'vue'
import Menu from 'primevue/menu'
import Badge from 'primevue/badge';
import { pinia } from '@/main'

export default {
    methods: {
        toggle(event) {
            this.$refs.menu.toggle(event);
        },
        toggleNotificationMenu(event) {
            this.$refs.notificationMenu.toggle(event);
        }
    },
    components: {
        Menu,
        Badge
    },
    setup() {
        const notificationCount = ref(0) // Should be moved to store.
        const keycloakStore = useKeycloakStore(pinia)

        const notificationMenuItems = []



        // eslint-disable-next-line no-unused-vars
        function login() {
            keycloakStore.getKeycloak.login({
                redirectUri: 'http://localhost:8081/home'
            })
        }

        async function logout() {
            const authenticated = await keycloakStore.isAuthenticated
            if (authenticated) {
                console.log(keycloakStore.getKeycloak);
                keycloakStore.getKeycloak.logout({
                    redirectUri: 'http://localhost:8081/'
                })
            }
        }

        function authenticated() {
            keycloakStore.getAuthenticated
        }

        const menuItems = [
            {

                items: [
                    {
                        label: 'Settings',
                        icon: 'pi pi-cog',
                        route: "/user/settings"
                    },
                    {
                        separator: true
                    }
                ]
            }
        ]

        return {
            keycloakStore,
            login,
            logout,
            authenticated,
            menuItems,
            notificationMenuItems,
            notificationCount
        }
    }

}
</script>
<style scoped>
.danger-zone {
    color: red;
}

.search-button-img {
    height: 25px;
    width: 25px;
}

#search-button {
    display: block;
    height: 40px;
    width: 60px;
    padding: 0 8px 0 0;
    border: 1px solid #5485ae;
    border-radius: 0 40px 40px 0;
    background-color: #2c3e50;
    text-align: center;
    color: white;
    cursor: pointer;
    outline: none;
    font-size: 16px;
}

#searchbox-container {
    width: auto;
    height: 40px;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
}

#search-input {
    height: 100%;
    width: 100%;
    border: none;
    outline: none;
    background-color: transparent;
    font-size: 16px;
    padding: 0 var(--left-and-right-indentation);
}

#search-form-container {
    height: 38px;
    width: 100%;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    border: 1px solid var(--primary-element-text-color);
    border-radius: 40px 0 0 40px;
}

.header-element {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: transparent;
    border: none;
    cursor: pointer;
    color: var(--primary-element-text-color);
    font-size: 16px;
    font-weight: bold;
}

#home-link {
    height: 40px;
    background-color: transparent;
    align-items: center;
    border: none;
    cursor: pointer;
    outline: none;
}

#home-link-img {
    height: 80%;
    width: 80px;
}

header {
    top: 0;
    position: sticky;
    width: 100%;
    height: 56px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    padding: 0 10px;

}

div.header-block {
    height: max-contentTR;
    display: flex;
    flex-direction: row;
}

div.left-block {
    margin-left: 10px;
    justify-self: start;
}

div.center-block {
    margin-left: 20px;
    flex: 1;
    flex: 0 1 650px;
    justify-content: center;
}

div.right-block {
    justify-content: flex-end;
    flex-direction: row;

}

div.right-block-wrapper {
    min-width: 100px;
    justify-content: flex-end;
    flex-direction: row;
    align-items: center;
}

div.right-block-wrapper button {
    width: auto;
}

div.right-block-wrapper i {
    font-size: 22px;
    color: #000;
    margin-right: 10px;

}
</style>