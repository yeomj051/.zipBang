<template>
  <div>
    <div class="bv-example-row mt-3 text-center">
      <h3 class="underline-hotpink"><b-icon icon="journals"></b-icon>Community</h3>
      <BoardList id="boardList" />
    </div>
  </div>
</template>

<script>
import BoardList from "../components/board/BoardList.vue";
export default {
  name: "Board",

  components: {
    BoardList,
  },
};
</script>

<style></style>
