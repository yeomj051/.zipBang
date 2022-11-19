<!-- eslint-disable vue/attribute-hyphenation -->
<template>
  <div>
    <router-view />
    <!-- Share modal -->
  </div>
</template>

<script>
// import NotificationList from "./components/NotificationList.vue";

import { mapMutations, mapState } from "vuex";

export default {
  name: "App",
  data() {
    return {};
  },
  // components: {
  //   NotificationList,
  // },
  // computed: {
  //   ...mapState(["walletModal"]),
  // },
  // methods: {
  //   ...mapMutations(["SHOW_INSTALL_WALLET"]),
  // },
};
</script>

<style lang="scss">
#shadow-icon-place {
  width: 50px;
  margin: 0 auto;
  padding-top: 50px;
}

#bg-slot-page {
  width: 100vw;
  height: 100vh;
  position: absolute;
  background-color: rgb(255, 255, 255);
  z-index: 1;
}
</style>
