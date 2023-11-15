<template>
  <the-header />
  <main>
    <router-view />
  </main>
</template>

<script>
import { useKeycloakStore } from '@/store/keycloak-store'
import { pinia } from '@/main'

export default {
  name: 'App',
  components: {
  },
  setup(props) {
    const keycloakStore = useKeycloakStore(pinia)

    return {
      keycloakStore
    }
  }
}

</script>



<style>
:root {
  --primary-element-text-color: #2c3e50;
  --secondary-element-text-color: #5485ae;
  --background-color: #f0f0f0;
  --left-and-right-indentation: 10px;
  --left-and-right-indentation-main: 10px;
}

html {
  font-size: 14px;
  background: var(--background-color);

}

body {
  margin: 0px;
  padding: 0px;
  border: 0px;
}

html,
body {
  margin: 0;
  height: 100%;

}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: justify;
  color: #2c3e50;
  height: 100%;
}

main {
  padding: 0 var(--left-and-right-indentation-main);
  top: 56px;
  position: relative;
  height: calc(100% - 56px);

  margin: 0;
  font-size: 16px;
}
</style>
