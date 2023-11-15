<template>
    <main>
        <h1>404 - Lost in the Digital Wilderness</h1>
        <img id="landscape" src="@/assets/404.jpg" alt="Digital Wilderness Landscape">
        <p>Oops! You've stumbled into uncharted territory.</p>
        <p>It looks like you've taken a wrong turn in the digital realm. Don't worry; you're not alone. Even the best
            explorers
            get lost sometimes. Let's get you back on track.</p>
        <div id="options">
            <a href="javascript:history.back()">Hit the Back Button</a>
            <a href="/">Go to Our Homepage</a>
            <a href="javascript:window.location.reload()">Discover the Unknown</a>
        </div>
        <p>If you're feeling really stuck or if you think there's a problem with our site, please don't hesitate to <a
                href="mailto:contact@example.com">contact us</a>. Our digital sherpa team is always ready to assist you.</p>
        <p>In the meantime, enjoy the view and keep exploring the digital wilderness.</p>
    </main>
</template>


<style scoped>
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

a {
    text-decoration: none;
    background-color: #3498db;
    color: #fff;
    padding: 8px 15px;
    border-radius: 5px;
    transition: background-color 0.3s;
    font-size: 16px;
    margin: 0 10px;
}

a:hover {
    background-color: #2077c0;
}
</style>