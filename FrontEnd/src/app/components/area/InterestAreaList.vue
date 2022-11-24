<template>
  <div>
    <b-row>
      <b-col class="d-lg-flex justify-content-lg-center">
        <!-- 시도 선택 -->
        <b-col col-xs-3 class="d-flex my-3">
          <b-form-select
            v-model="sidoCode"
            :options="sidos"
            @change="gugunList"
            class="ml-0 rounded-pill"
          ></b-form-select>
        </b-col>
        <!-- 구군 선택 -->
        <b-col col-xs-3 class="d-flex my-3">
          <b-form-select
            v-model="gugunCode"
            :options="guguns"
            @change="dongList"
            class="ml-0 rounded-pill"
          ></b-form-select>
        </b-col>
        <!-- 법정동 선택 -->
        <b-col col-xs-3 class="d-flex my-3">
          <b-form-select
            v-model="dongCode"
            :options="dongs"
            class="ml-0 rounded-pill"
          ></b-form-select>
        </b-col>
        <b-col col-xs-1 class="d-flex my-3">
          <a href="#list"
            ><b-button
              style="
                max-width: 100%;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
              "
              variant="dark"
              class="rounded-pill font-weight-bold"
              @click="searchApt()"
              >추가</b-button
            ></a
          >
        </b-col>
      </b-col>
    </b-row>

    <div class="second-section" id="list">
      <b-row>
        <b-col cols="12" md="12" lg="6" xl="7" class="p-0">
          <div class="p-0 col-md-12 col-lg-6 col-xl-5 col-12">
            <div class="block clearfix">
              <div class="separator-2"></div>
              <div class="separator-2">
                <h3 class="title" style="text-align: center; font-weight: 900">
                  관심 지역 목록
                </h3>
              </div>

              <div class="separator-2"></div>

              <div v-for="item in list" :key="item">
                <div id="question__section mx-auto">
                  <div
                    class="
                      poll-answer-item
                      bg-dark
                      text-light
                      d-flex
                      justify-content-between
                      w-200
                      px-2 px-md-4
                      py-3
                      my-4
                      aos-init aos-animate
                      collapsed
                      rounded-pill
                    "
                    style="overflow-anchor: none"
                  >
                    <h3>
                      <!-- 이전 jsp 방식<a class="accordion-body">${area.areaArddres} </a> -->
                      <a class="accordion-body">
                        {{ item["dongCode"]["gugunName"] }}
                        {{ item["dongCode"]["dongName"] }}</a
                      >
                    </h3>

                    <img src="assets/img/Artboard 81 1..png" alt="" />
                  </div>
                  <hr />
                </div>
              </div>

              <font-awesome-icon icon="fa-duotone fa-trash" />
            </div>
          </div>
        </b-col>
        <b-col cols="12" md="12" lg="6" xl="5" class="p-0">
          <kakao-map></kakao-map>
        </b-col>
        <div class="solid-back"></div>
      </b-row>
    </div>
  </div>
</template>

<script>
import KakaoMap from "../map/KakaoMap.vue";

import { apiInstance } from "../../api/index.js";
import { mapState, mapActions, mapMutations, mapGetters } from "vuex";

const aptStore = "aptStore";
const userStore = "userStore";
const api = apiInstance();
export default {
  name: "InterestAreaList",
  components: { KakaoMap },
  data() {
    return {
      list: ["강남구", "역삼"],
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),

    ...mapState(aptStore, ["sidos", "guguns", "dongs"]),
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  mounted() {
    this.getlist();
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_APT_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions(userStore, ["userLogout"]),
    ...mapActions(aptStore, ["getSido", "getGugun", "getDong"]),
    ...mapMutations(aptStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
      "CLEAR_APT_LIST",
      "CLEAR_DEALYEAR_LIST",
    ]),
    gugunList() {
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    searchApt() {
      const param = {
        email: this.userInfo.email,
        dongCode: this.dongCode,
      };
      api
        .post(`/area/add`, JSON.stringify(param))
        .then(({ data }) => {
          console.log(data, 222222222222222222125126126);
          this.getlist();
        })
        .catch((error) => {
          console.log(error);
          alert("이미 존재하는 이메일 입니다. 다시 입력해 주세요");
        });
    },
    getlist() {
      api
        .get(`/area/list`, {
          params: {
            userId: this.userInfo.id,
          },
        })
        .then(({ data }) => {
          console.log(data, 222222222222222222125126126);
          this.list = data;
        })
        .catch((error) => {
          console.log(error);
          alert("이미 존재하는 이메일 입니다. 다시 입력해 주세요");
        });
    },
  },
};
</script>

<style>
</style>
