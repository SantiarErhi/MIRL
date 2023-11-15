<template>
    <left-sidebar selectedItem="Map" />
    <div></div>
</template>


<style scoped>
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