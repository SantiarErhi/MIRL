<template>
    <div id="left-sidebar">
        <scroll-panel style="width: 100%; height: 100%">
            <Menu style="width: 100%; height: 100%" :model="items">
                <template #item="{ item, props }">
                    <a v-if="isSelected(item.label)" class="selected" :href="item.url" :target="item.target"
                        v-bind="props.action">
                        <span :class="item.icon" />
                        <span class="ml-2">{{ item.label }}</span>
                    </a>
                    <a v-else :href="item.url" :target="item.target" v-bind="props.action">
                        <span :class="item.icon" />
                        <span class="ml-2">{{ item.label }}</span>
                    </a>
                </template>
            </Menu>

        </scroll-panel>
    </div>
</template>

<script>
import { ref } from "vue";
import Menu from 'primevue/menu'
import { useRouter } from 'vue-router'

export default {
    name: "LeftSidebar",
    components: {
        Menu
    },
    props: ['selectedItem'],
    setup(props) {
        const router = useRouter();

        function isSelected(item) {
            console.log(props.selectedItem + " " + item + " " + (item == props.selectedItem));
            return item == props.selectedItem;
        }

        const items = ref([
            {

                items: [
                    {
                        action: false,
                        label: 'Home',
                        icon: 'pi pi-home',
                        command: () => {
                            router.push('/home');
                        }
                    },
                    {
                        action: false,
                        label: 'Map',
                        icon: 'pi pi-map',
                        command: () => {
                            router.push('/map');
                        }
                    },
                    {
                        action: false,
                        label: 'Subscriptions',
                        icon: 'pi pi-megaphone',
                        command: () => {
                            router.push('/subscriptions');
                        }
                    },
                    {
                        separator: true
                    },
                    {
                        action: false,
                        label: 'Manage events',
                        icon: 'pi pi-table',
                        command: () => {
                            router.push('/events');
                        }

                    },
                    {
                        action: false,
                        label: 'Create event',
                        icon: 'pi pi-plus',
                        command: () => {
                            router.push('/events/create');

                        }

                    },
                    {
                        separator: true
                    },
                    {
                        action: false,
                        label: 'Settings',
                        icon: 'pi pi-cog',
                        command: () => {
                            router.push('/settings');
                        }

                    },
                ]
            }
        ]);

        return {
            props,
            items,
            isSelected
        };
    }
};
</script>

<style>
a.selected {
    background-color: gray;
    color: var(--primary-element-text-color);
}

p-divider {
    color: black;

}

div.p-menu {
    background-color: var(--background-color);
    border: none;
    font-size: 16px;
    font-weight: 700;
}

.p-menuitem-icon {
    font-size: 1rem;
}

div.p-panelmenu-header-icon-wrapper:hover {
    cursor: pointer;
}

.p-menuitem-separator {
    border-top: 3px solid rgb(201, 198, 198);
}

#left-sidebar {
    min-width: 200px;
    max-width: 200px;
    height: 100%;
    margin: 0px;
}

li.p-submenu-header {
    padding: 0;
    background-color: var(--background-color);
}

.p-menuitem-link {
    padding-left: 10px;
}
</style>