<template>
  <div>
    <b-container>
      <!-- 관심지역 AreaAdd컴포넌트 시작-->

      <!-- <area-add></area-add> -->

      <!-- 관심지역 AreaAdd컴포넌트 끝-->
      <!-- 조회 결과 시작 -->

      <interest-area-list></interest-area-list>

      <!-- 조회 결과 끝 -->
    </b-container>
  </div>
</template>

<script>
import HeaderNav from "../components/include/HeaderNav.vue";
import Footer from "../components/include/Footer.vue";
import AreaAdd from "../components/area/AreaAdd.vue";
import InterestAreaList from "../components/area/InterestAreaList.vue";
import KakaoMap from "../components/map/KakaoMap.vue";

export default {
  name: "InterestArea",
  data() {
    return {};
  },
  components: {
    HeaderNav,
    Footer,
    AreaAdd,
    InterestAreaList,
    KakaoMap,
  },
};
</script>

<style lang="scss"></style>
