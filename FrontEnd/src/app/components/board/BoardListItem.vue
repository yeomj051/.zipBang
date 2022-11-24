<template>
  <router-link :to="`/communityDetail/${this.board.articleno}`" class="px-2 my-2" active-class="activeLink">
    <div class="board-list-item bg-beige text-light w-100 px-3 px-md-4 py-1 my-4 row" duration="2000">
      <!-- <b-icon icon="question-circle" class="ml-1 ml-md-3 mr-3 mb-0"></b-icon> -->
      <div class="col-1">
        <p class="my-2 font-weight-bold text-left px-3">{{ board.articleno }}</p>
      </div>
      <div class="col-4">
        <p class="my-2 font-weight-bold text-left">{{ board.subject }}</p>
      </div>
      <div class="col-3">
        <p class="my-2 font-weight-bold">{{ board.userid }}</p>
      </div>
      <div class="col-2">
        <p class="my-2 font-weight-bold">{{ board.regtime }}</p>
      </div>
      <div class="col">
        <p class="my-2 font-weight-bold text-right px-4">{{ board.hit }}</p>
      </div>
    </div>
  </router-link>
</template>
<script>
export default {
  name: "BoardListItme",
  props: {
    board: Object,
  },

  data() {
    return {
      id: this.board,
    };
  },
};
</script>
<style lang="scss">
// creator description styles
.creator-description__container {
  width: 100%;
  margin: 0 auto 50px;

  @media (max-width: 500px) {
    width: 100%;
  }
  .creator-description__card {
    box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
    border-radius: 20px;
    text-align: justify;
    width: 100%;
    p:nth-child(2) {
      color: #969292;
    }
  }
}
</style>
