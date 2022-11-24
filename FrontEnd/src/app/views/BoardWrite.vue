<template>
  <div class="bv-example-row mt-3 text-center container">
    <div>
      <h3 class="underline-hotpink"><b-icon icon="journals"></b-icon>글쓰기</h3>
    </div>
    <div class="board">
      <BoardCreate type="register" />
    </div>
  </div>
</template>

<script>
import BoardCreate from "../components/board/BoardCreate.vue";
export default {
  name: "BoardWrite",
  components: {
    BoardCreate,
  },
};
</script>

<style lang="scss">
.board {
  .board-input {
    width: 100%;
    margin: 0px 0 200px;
    border-radius: 50px;
  }
}
</style>
