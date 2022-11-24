<template>
  <!-- 지역, 매매년월 컴포넌트-->
  <div></div>
  <!-- 지역, 매매년월 컴포넌트 끝-->
</template>

<script>
import { mapState, mapActions, mapMutations, mapGetters } from "vuex";

import { apiInstance } from "../../api/index.js";

import InterestAreaList from "./InterestAreaList.vue";

const api = apiInstance();
const userStore = "userStore";
const interestAreaList = "InterestAreaList";
const aptStore = "aptStore";

export default {
  name: "AreaAdd",
  components: { InterestAreaList },
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
    };
  },
  computed: {
    ...mapState(interestAreaList, ["list"]),
    ...mapState(aptStore, ["sidos", "guguns", "dongs"]),
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
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

<style></style>
