<template>
    <main>
        <div class="landing-page">
            <div class="intro-wrap">
                <h1 class="intro"><em>Start using <b>MIRL</b>, and</em><br><b> Never miss events that meet your
                        interests</b>.</h1>
            </div>
            <div class="section-1">
                <div class="section-1-image-container">
                    <img src="@/assets/Meeting-new-people.jpg" />
                    <h2>Meet new people</h2>
                </div>
                <div class="section-1-image-container">
                    <img src="@/assets/Skiing-man-and-woman.jpg" />
                    <h2>Have fun</h2>
                </div>
                <div class="section-1-image-container">
                    <img src="@/assets/Celebrating-crowd.png" />
                    <h2>Live your life</h2>
                </div>
            </div>
        </div>
    </main>
</template>

<script setup>

</script>

<style scoped>
div.section-1-image-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;


    /* Medium devices (landscape tablets, 768px and up) */
    @media only screen and (max-width: 991px) {
        height: 30vh;
        width: auto;
        margin-bottom: 10vh;

    }

    /* Large devices (laptops/desktops, 992px and up) */
    @media only screen and (min-width: 992px) {
        height: 25vh;
        width: auto;
        margin: 4vw;
    }

    /* Extra large devices (large laptops and desktops, 1200px and up) */
    @media only screen and (min-width: 1200px) {
        height: 35vh;
        width: auto;
        margin: 4vw;
    }
}

div.section-1-image-container img {
    height: 100%;
    width: 100%;
    border-radius: 50%;
}

div.landing-page {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;

    height: 100%;
    width: 100%;
}

div.section-1 {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    height: 100%;
    width: 100%;

    @media only screen and (max-width: 991px) {
        flex-direction: column;
        height: auto;
    }

    @media only screen and (min-width: 992px) {
        flex-direction: row;
        height: 100%;
    }


}

div.intro-wrap {
    margin-top: 25px;
    margin-bottom: 100px
}

h1.intro {
    color: ;
    font-size: 2.5rem;
    color: #2c3e50;
    text-align: center;
    margin: 0;
    padding: 0;
}

h1.intro em {
    font-weight: 300;
    font-style: normal;
}

main {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
}
</style>
