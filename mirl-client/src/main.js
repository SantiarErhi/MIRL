import { createApp } from 'vue'
import { createPinia, PiniaVuePlugin } from 'pinia'

import globals from '@/globals.js'
import { EventService } from '@/services/EventService.js'
import EventForm from '@/components/events/EventForm.vue'
import MainApp from '@/MainApp.vue'

import router from '@/router/router.js'

import PrimeVue from 'primevue/config';

import 'primevue/resources/themes/lara-light-teal/theme.css'
import "leaflet/dist/leaflet.css";
import 'primeicons/primeicons.css'
import 'primeflex/primeflex.css'

import ScrollPanel from 'primevue/scrollpanel';
import LeftSidebar from '@/components/LeftSidebar.vue'
import Menu from 'primevue/menu';
import Toast from 'primevue/toast';
import Image from 'primevue/image';
import TheHeader from '@/components/TheHeader.vue';
import Divider from 'primevue/divider';
import OverlayPanel from 'primevue/overlaypanel';
import InputText from 'primevue/inputtext';
import InputNumber from 'primevue/inputnumber';
import RadioButton from 'primevue/radiobutton';
import Editor from 'primevue/editor';
import Steps from 'primevue/steps';
import Calendar from 'primevue/calendar';
import FileUpload from 'primevue/fileupload';
import Galleria from 'primevue/galleria';

// Variable initialization
const app = createApp(MainApp)
const pinia = createPinia()
app.use(PiniaVuePlugin)
app.use(pinia)

export { pinia }

// Component registration
app.component('scroll-panel', ScrollPanel);
app.component('left-sidebar', LeftSidebar)
app.component('prime-menu', Menu)
app.component('prime-toast', Toast)
app.component('prime-image', Image)
app.component('the-header', TheHeader)
app.component('prime-divider', Divider)
app.component('prime-overlay-panel', OverlayPanel)
app.component('event-form', EventForm)
app.component('prime-input-text', InputText)
app.component('prime-input-number', InputNumber)
app.component('prime-radio-button', RadioButton)
app.component('prime-editor', Editor)
app.component('prime-steps', Steps)
app.component('prime-calendar', Calendar)
app.component('prime-file-upload', FileUpload)
app.component('prime-galleria', Galleria)

app.provide("eventService", new EventService(globals.MIRL_API_ROOT_URL));

// Plugin registration
app.use(router)
    .use(PrimeVue);

app.mount('#app')

