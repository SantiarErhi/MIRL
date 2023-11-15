<template>
    <left-sidebar selectedItem="Home" />
    <div id="home-event-display">
        <div class="display-header">
            <Inplace closable>
                <template #display> Discovering events in <u>{{ location }}.</u> Click to change location. </template>
                <template #content>
                    <p class="m-0">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                        labore
                        et
                        dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                        aliquip
                        ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                        fugiat
                        nulla
                        pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt
                        mollit
                        anim
                        id est laborum.
                    </p>
                </template>
            </Inplace>
        </div>
        <DataView :value="events"></DataView>
    </div>
</template>

<script>
import Inplace from 'primevue/inplace';


export default {
    name: 'HomeView',
    components: {
        Inplace
    },
    data() {
        return {
            location: 'Kyiv',
        }
    },
}
</script>

<style>
div#home {
    height: 100%;
    width: 100%;
}

main {
    top: 56px;
    position: static;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: flex-start;
    height: calc(100% - 56px);
    width: 100%;
}

div.display-header {
    margin: 5px;
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

div.p-inplace {
    font-size: 16px;
    align-self: flex-end;
}

div#home-event-display {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>