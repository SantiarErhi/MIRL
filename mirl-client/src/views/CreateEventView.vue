<template>
    <left-sidebar selectedItem="Create event" />
    <scroll-panel style="width: 100%; height: 100%">
        <div class="form-container">
            <div class="event-form-container">
                <event-form />
            </div>
        </div>
    </scroll-panel>
</template>


<style scoped>
div.event-form-container {
    height: 100%;
    width: 50%;
    min-width: 500px;
    display: flex;
    justify-content: flex-start;
    flex-direction: column;
}

div.form-container {
    height: 100%;
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

main {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: calc(100% - 56px);

    margin: 0;
    font-size: 16px;
}

h1 {
    font-size: 2rem;
    margin: 0;
}

p {
    margin: 10px 0;
}

#landscape {
    width: 100%;
    max-width: 300px;
    margin: 20px 0;
}

#options {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px 0;
}
</style>