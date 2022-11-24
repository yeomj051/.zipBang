<template>
  <div>

    <div class="bv-example-row mt-3 text-center">
      <h3 class="underline-hotpink"><b-icon icon="journals"></b-icon>Community</h3>
      <BoardList id="boardList" />
      <b-pagination
        class="my-5"
        v-model="currentPage"
        :total-rows="Creatorsrows"
        :per-page="CreatorsperPage"
        pills
        align="center"
        aria-controls="boardList"
        first-number
        last-number
      ></b-pagination>
    </div>
  </div>
</template>

<script>
import HeaderNav from "../components/include/HeaderNav.vue";
import Footer from "../components/include/Footer.vue";
import BoardList from "../components/board/BoardList.vue";
export default {
  name: "Board",

  components: {
    HeaderNav,
    Footer,
    BoardList,
  },
  data() {
    return {
      CreatorsperPage: 9,
      currentPage: 1,
    };
  },
};
</script>

<style></style>
