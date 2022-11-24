<template>
  <!-- 이름 입력 -->
  <div class="search-creator text-center">
    <div class="search-creator-input__container text-center">
      <input
        class="search-creator__input font-weight-bold"
        type="text"
        placeholder="이름"
        v-model="user.name"
        @keyup.enter="confirm"
      />
    </div>
    <br />
    <!-- 이메일 입력 -->

    <div class="search-creator-input__container">
      <input
        class="search-creator__input font-weight-bold"
        type="eamil"
        placeholder="이메일"
        v-model="user.email"
        @keyup.enter="confirm"
      />
      <!-- <button
          class="search-creator__button"
          :disabled="isAvailableBtn"
          @click="getMyPage"
        >
          <p class="mx-auto" alt="arrow-right">중복체크</p>
        </button> -->
    </div>
    <br />

    <!-- 비밀번호 입력 -->
    <div class="search-creator-input__container">
      <input
        class="search-creator__input font-weight-bold"
        type="password"
        placeholder="비밀번호"
        v-model="user.password"
        @keyup.enter="confirm"
      />
    </div>
    <br />
    <!-- 전화번호 입력 -->
    <div class="search-creator-input__container">
      <input
        class="search-creator__input font-weight-bold"
        type="text"
        placeholder="전화번호 ex) 010-1234-5678"
        v-model="user.phone"
        @keyup.enter="confirm"
      />
    </div>
    <br />
    <!-- 닉네임 입력 -->
    <div class="search-creator-input__container">
      <input
        class="search-creator__input font-weight-bold"
        type="text"
        placeholder="닉네임"
        v-model="user.nickName"
        @keyup.enter="confirm"
      />
    </div>
    <br />
    <!-- 주소 입력 -->
    <div class="search-creator-input__container">
      <input
        class="search-creator__input font-weight-bold"
        type="text"
        placeholder="주소"
        v-model="user.address"
        @keyup.enter="confirm"
      />
    </div>
    <br />

    <!-- 회원가입 버튼 -->
    <b-button
      id="findPw"
      style="
        max-width: 100%;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
      "
      class="ml-0 mt-3 mt-lg-0 ml-lg-4 px-5 py-2 rounded-pill font-weight-bold"
      variant="dark"
      @click="isJoin"
      >회원가입
    </b-button>
  </div>
</template>
<script>
import { thisExpression } from "@babel/types";
import { mapState, mapActions } from "vuex";
import { apiInstance } from "../../api/index.js";

const api = apiInstance();
const userStore = "userStore";
export default {
  name: "JoinView",
  data() {
    return {
      user: {
        name: null,
        email: null,
        password: null,
        phone: null,
        nickName: null,
        address: null,
        gender: null,
      },
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(userStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },
    isJoin() {
      api
        .post(`/user/join`, JSON.stringify(this.user))
        .then(({ data }) => {
          console.log(data);
          this.$router.push({ name: "login" });
        })
        .catch((error) => {
          console.log(error);
          alert("이미 존재하는 이메일 입니다. 다시 입력해 주세요");
          this.user.email = null;
        });
      // this.$router.push({ name: "home" });
    },
    movePageJoin() {
      this.$router.push({ name: "join" });
    },
  },
};
</script>
<style></style>
