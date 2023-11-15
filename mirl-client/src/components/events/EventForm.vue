<template>
    <div class="flex-center">
        <h2>Create event</h2>
    </div>
    <prime-steps :activeStep="step" :model="items" :readonly="false" />
    <form v-if="step == 0" @submit="onSubmit" id="event-form">
        <div class="form-row">
            <a class="form-field-name">Photo: </a>
            <prime-file-upload :previewWidth=400 mode="basic" @select="onFileUpload" accept="image/*"
                :maxFileSize="2000000" />
            <div class="flex-center" style="height: 300px">
                <a v-if="!imageSelected">Uploaded image will be displayed here</a>
                <prime-image v-else :src="eventImage" id="eventPrimaryImage" alt="Loaded image"
                    imageStyle="max-height: 250px;">
                </prime-image>

            </div>

        </div>
        <div class="form-row">
            <a class="form-field-name">Event name: </a>
            <prime-input-text v-model="eventName" />
        </div>
        <div class="form-row">
            <a class="form-field-name">Event type: </a>
            <prime-input-text v-model="eventName" />
        </div>
        <div class="form-columns">
            <div class="form-row">
                <a class="form-field-name">Start time: </a>
                <prime-calendar v-model="eventStartTime" showTime hourFormat="24" showIcon />
            </div>
            <div class="form-row">
                <a class="form-field-name">End time: </a>
                <prime-calendar v-model="eventEndTime" showTime hourFormat="24" showIcon />
            </div>
        </div>
    </form>
    <form v-if="step == 1" @submit="onSubmit" id="event-form">
        <div class="form-row max-height">
            <a class="form-field-name">Description: </a>
            <prime-editor v-model="eventDescription" class="full-height-editor" />
        </div>
    </form>
    <form v-if="step == 2" @submit="onSubmit" id="event-form">
        <div class="form-row max-height">
            <a class="form-field-name">Description: </a>
            <l-map ref="map" v-model:zoom="zoom" :center="[47.41322, -1.219482]">
                <l-tile-layer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png" layer-type="base"
                    name="OpenStreetMap"></l-tile-layer>
            </l-map>
        </div>
    </form>
    <div class="form-switch">
        <button v-if="step > 0" class="change-step-button" type="button" @click="previousStep()">
            <i class="pi pi-arrow-left"></i>
            Previous
        </button>
        <div style="width: 59ox;"></div>
        <button v-if="step < steps" class="change-step-button" type="button" @click="nextStep()">Next
            <i class="pi pi-arrow-right"></i>

        </button>
        <button v-if="step == steps" class="accept-button" type="button" @click="nextStep()">Accept
        </button>
    </div>
</template>

<script setup>
import { ref } from "vue";
import { LMap, LTileLayer } from "@vue-leaflet/vue-leaflet";


const imageSelected = ref(false)
const eventImage = ref("")
const zoom = ref(2)
const eventStartTime = ref(null)
const eventEndTime = ref(null)
const eventName = ""
const step = ref(0)
const steps = 2
const items = [
    {
        index: 0,
        label: 'Basic setup',
        command: () => {
            step.value = 0
        }
    },
    {
        index: 1,
        label: 'Description',
        command: () => {
            step.value = 1
        }
    },
    {
        index: 2,
        label: 'Choose on map',
        command: () => {
            step.value = 2
        }
    }
]

function nextStep() {
    if (step.value < steps) { step.value++; }
}
function previousStep() {
    if (step.value > 0) { step.value--; }
}

function onFileUpload(event) {
    console.log(event.files[0].objectURL);
    eventImage.value = event.files[0].objectURL;
    imageSelected.value = true;
}


</script>

<style>
div.form-columns {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    width: 100%;
}

button.accept-button {
    background-color: #10b981;
    border: none;
    color: var(--text-color);
    padding: 10px 20px;
    text-align: center;
    display: inline-block;
    font-size: 16px;
    cursor: pointer;
}

.p-steps-item:before {
    border-top: 1px solid black;
}

button.change-step-button {
    background-color: var(--background-color);
    border: none;
    color: var(--text-color);
    padding: 10px 20px;
    text-align: center;
    display: inline-block;
    font-size: 16px;
    cursor: pointer;

}


div.form-switch {
    display: flex;
    justify-content: space-between;
    margin-top: 20px;
    margin-bottom: 20px;
}

div.flex {
    display: flex;
}

div.flex-center {
    display: flex;
    justify-content: center;
    align-items: center;

}

span.p-menuitem-link {
    background-color: var(--background-color);
}

.p-steps-item:before {
    background-color: #000000;
}

a.form-field-name {
    font-size: 16px;
    font-weight: bold;
    margin: 10px 0;

}

div.form-row {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: left;
    width: 100%;
    margin: 0 10px;
}

div.full-height-editor {
    height: calc(100% - 120px);

}

div.max-height {
    height: 100%;
}

form#event-form {
    height: 100%;
    width: 100%;
    display: flex;
    flex-direction: column;
    margin-top: 20px;
}
</style>