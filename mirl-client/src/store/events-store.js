import { defineStore } from 'pinia'
import { ref } from 'vue'
import { inject } from 'vue'

var recommendedEventsPage = 1;
var discoveredEventsPage = 1;
var ownedEventsPage = 1;
var subscribedEventsPage = 1;



export const useEventsStore = defineStore('events', {
    eventService: inject("eventService"),
    state: () => ({
        recommendedEvents: ref(),
        subscribedEvents: ref(new Set()),
        ownedEvents: ref(new Set()),
        discoveredEvents: ref(new Set())
    }),
    getters: {

    },
    actions: {
        async getEvents() {
            await this.eventService.getEvents(recommendedEventsPage++).then((result) => {
                this.recommendedEvents = result
            })
        }

    }

})