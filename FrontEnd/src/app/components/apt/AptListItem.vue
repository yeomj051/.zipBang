<template>
  <div>
    <div
      v-b-toggle="`collapse-${apt.id}`"
      class="apt-list-item bg-beige text-light w-100 px-3 px-md-4 py-1 my-4 row"
      duration="2000"
    >
      <!-- <b-icon icon="question-circle" class="ml-1 ml-md-3 mr-3 mb-0"></b-icon> -->
      <p class="my-2 font-weight-bold col-5">{{ apt.apartmentName }}</p>
      <p class="ml-5 my-2 font-weight-bold col">{{ apt.dealAmount }}</p>
      <p class="col"></p>
      <div class="ml-auto question__icon">
        <img src="../../assets/icons/Artboard 81 1.png" alt="" />
      </div>
    </div>
    <b-collapse :id="`collapse-${apt.id}`" accordion="questions">
      <b-card class="question-item__card text-dark">
        <div class="creator-description__container">
          <div class="creator-description__card p-5">
            <h3 class="font-weight-bold py-3">{{ apt.apartmentName }}</h3>

            <div class="d-flex justify-content-between">
              <p class="font-weight-bold">건축연도</p>
              <p class="font-weight-bold">{{ apt.buildYear }}</p>
            </div>
            <div class="d-flex justify-content-between">
              <p class="font-weight-bold">거래날짜</p>
              <p class="font-weight-bold">{{ apt.dealDate }}</p>
            </div>
            <div class="d-flex justify-content-between">
              <p class="font-weight-bold">실거래가</p>
              <p class="font-weight-bold">{{ apt.dealAmount }}</p>
            </div>
            <div class="d-flex justify-content-between">
              <p class="font-weight-bold">층</p>
              <p class="font-weight-bold">{{ apt.floor }}</p>
            </div>
            <div class="d-flex justify-content-between">
              <p class="font-weight-bold">면적</p>
              <p class="font-weight-bold">{{ apt.area }}</p>
            </div>

            <hr />
            <p class="font-weight-bold">공인중개사</p>
          </div>
        </div></b-card
      >
    </b-collapse>
  </div>
</template>
<script>
export default {
  name: "AptListItem",
  props: {
    apt: Object,
  },

  data() {
    return {
      id: this.apt.id,
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
    // .d-flex {
    //   .text-end {
    //     text-align: right;
    //   }
    // }
  }
}
</style>
