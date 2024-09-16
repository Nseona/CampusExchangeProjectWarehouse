<template>
  <router-view v-slot="{ Component }">

    <keep-alive>
      <component v-if="shouldKeepAlive" :is="Component" />
    </keep-alive>

      <component v-if="!shouldKeepAlive" :is="Component" />
  </router-view>
</template>

<script setup>
import { computed } from 'vue';
import { useRoute } from 'vue-router';
import { KeepAlive } from 'vue';

const route = useRoute();
const shouldKeepAlive = computed(() => route.meta.keepAlive);

</script>
