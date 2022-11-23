<template>
  <div class="FAQ__container">
    <div class="question__section mx-auto">
      <!-- <b-table
        striped
        hover
        :items="apts"
        :fields="fields"
        class="boardListTitle ml-0 mt-3 mt-lg-0 ml-lg-4 px-4 py-2 rounded-pill font-weight-bold btn-dark"
      >
      </b-table> -->
      <div class="question-item bg-dark text-light w-100 px-3 px-md-4 py-1 my-4 row" data-aos="fade-up" duration="2000">
        <!-- <b-icon icon="question-circle" class="ml-1 ml-md-3 mr-3 mb-0"></b-icon> -->
        <div class="col-5"><p class="my-2 font-weight-bold">아파트명</p></div>
        <div class="col"><p class="my-2 font-weight-bold">가격</p></div>
        <div class="col"></div>
      </div>
      <div v-if="apts && apts.length != 0" class="resultList">
        <apt-list-item v-for="(apt, index) in apts" :key="index" :apt="apt" />
      </div>
    </div>
  </div>
</template>
<script>
import AptListItem from "./AptListItem.vue";
import { mapState } from "vuex";
const aptStore = "aptStore";
export default {
  name: "AptList",
  data() {
    return {
      fields: [
        { key: "aptname", label: "아파트명", tdClass: "tdClass" },
        { key: "price", label: "가격", tdClass: "tdSubject" },
      ],
    };
  },
  computed: {
    ...mapState(aptStore, ["apts"]),
  },
  components: {
    AptListItem,
  },
};
</script>
<style lang="scss">
.FAQ__container {
  #see-more {
    margin: 100px 0;
    &:hover {
      cursor: pointer;
      text-decoration: underline;
    }
  }
  .faq__container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    width: 90%;
    margin: 50px 0 100px;
    #faq__desc {
      width: 90%;
      margin: 0 auto;
    }

    @media (max-width: 800px) {
      width: 100%;
      #faq__desc {
        width: 95%;
      }
    }
  }
  .question__section {
    width: 80%;
    margin: 100px 0 200px;
    .question-item {
      border-radius: 50px;
      .question__icon {
        display: flex;
        align-items: center;
        img {
          transform: rotate(90deg);
        }
      }
    }
    .resultList {
      overflow: scroll;
      height: 800px;
      width: 450px;
      &::-webkit-scrollbar-track {
        border: none;
        padding: 2px 0;
        background-color: #ffffff;
      }

      &::-webkit-scrollbar {
        width: 10px;
      }

      &::-webkit-scrollbar-thumb {
        border-radius: 10px;
        box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
        background-color: #594d42;
        border: none;
      }
      .apt-list-item {
        border-radius: 50px;
        .question__icon {
          display: flex;
          align-items: center;
          img {
            transform: rotate(90deg);
          }
        }
      }
    }
    .question-item__card {
      border: none;
    }
  }
}
</style>
