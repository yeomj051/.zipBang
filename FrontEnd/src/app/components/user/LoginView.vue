<template>
  <!-- 이메일 입력 -->
  <div class="search-creator text-center">
    <div class="search-creator-input__container text-center">
      <p class="placeholder font-weight-bold"><b-icon icon="envelope"></b-icon> |</p>
      <input
        class="search-creator__input font-weight-bold"
        type="email"
        placeholder="me@example.com"
        v-model="user.email"
        @keyup.enter="confirm"
      />
    </div>
    <!-- 비밀번호 입력 -->
    <div class="search-creator-input__container">
      <p class="placeholder font-weight-bold"><b-icon icon="key"></b-icon> |</p>
      <input
        class="search-creator__input font-weight-bold"
        type="text"
        placeholder="****"
        v-model="user.password"
        @keyup.enter="confirm"
      />
    </div>

    <div class="d-initial d-lg-flex justify-content-lg-center mx-auto"></div>
    <b-row>
      <b-col col-xs-3 class="text-center my-3">
        <!-- 로그인 버튼 -->
        <b-button
          id="login"
          style="max-width: 100%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis"
          class="ml-0 mt-3 mt-lg-0 ml-lg-4 px-4 py-2 rounded-pill font-weight-bold"
          variant="dark"
          @click="confirm"
          >로그인
        </b-button>
        <!-- 회원가입 버튼 -->
        <b-button
          id="join"
          style="max-width: 100%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis"
          class="ml-0 mt-3 mt-lg-0 ml-lg-4 px-4 py-2 rounded-pill font-weight-bold"
          variant="dark"
          @click="movePageJoin"
          >회원가입
        </b-button>
      </b-col>
    </b-row>
    <!-- 비밀번호 찾기 버튼 -->
    <b-button
      id="findPw"
      style="max-width: 100%; overflow: hidden; white-space: nowrap; text-overflow: ellipsis"
      class="ml-0 mt-3 mt-lg-0 ml-lg-4 px-5 py-2 rounded-pill font-weight-bold"
      variant="dark"
      @click="movePageFindPw"
      >비밀번호 찾기
    </b-button>
  </div>
</template>
<script>
import { mapState, mapActions } from "vuex";
const userStore = "userStore";
export default {
  name: "LoginView",
  data() {
    return {
      user: {
        email: null,
        password: null,
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
    movePageFindPw() {
      this.$router.push({ name: "home" });
    },
    movePageJoin() {
      this.$router.push({ name: "join" });
    },
  },
};
</script>
<style></style>
