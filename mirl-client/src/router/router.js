import { createRouter, createWebHistory } from 'vue-router'
import { pinia } from '@/main'
import { useKeycloakStore } from '@/store/keycloak-store.js'
import HomeView from '@/views/HomeView.vue'
import PublicView from '@/views/PublicView.vue'
import NotFoundView from '@/views/NotFoundView.vue'
import ManageEventsView from '@/views/ManageEventsView.vue'
import CreateEventView from '@/views/CreateEventView.vue'
import MapView from '@/views/MapView.vue'
import SettingsView from '@/views/SettingsView.vue'
import SubscriptionsView from '@/views/SubscriptionsView.vue'


const routes = [
    {
        path: '/', name: "Root", meta: { authRequired: false }, component: PublicView
    },
    {
        path: '/not-found', name: "Not found", meta: { authRequired: false }, component: NotFoundView
    },
    {
        path: '/home', name: "Home", component: HomeView, meta: { authRequired: true }
    },
    {
        path: '/events', name: "Manage events", component: ManageEventsView, meta: { authRequired: true }
    },
    {
        path: '/events/create', name: "Create event", component: CreateEventView, meta: { authRequired: true }
    },
    {
        path: '/map', name: "Events map", component: MapView, meta: { authRequired: true }
    },
    {
        path: '/settings', name: "Settings", component: SettingsView, meta: { authRequired: true }
    },
    {
        path: '/subscriptions', name: "Subscriptions", component: SubscriptionsView, meta: { authRequired: true }
    },
    {
        path: '/authenticated', name: "Authenticated", meta: { authRequired: true }, beforeEnter: (to, from, next) => {
            router.push({ name: "Home" })
        }
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

router.beforeEach(async (to, from) => {
    const store = useKeycloakStore(pinia)

    const authenticated = await store.isAuthenticated()
    if (authenticated) {
        if (to.name === "Root") {
            router.push({ name: "Home" })
        }
        return true
    }
    else {
        if (to.meta.authRequired) {
            store.getKeycloak.login()
        }
        else {
            return true
        }
    }

})

// eslint-disable-next-line no-unused-vars
export default router
