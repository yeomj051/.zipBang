<template>
  <div class="container-fluid p-0 m-0">
    <b-navbar toggleable="lg" type="light" variant="white" class="px-5 py-4">
      <!-- Navbar logo -->
      <b-navbar-brand href="#">
        <router-link to="/home">
          <img
            id="principal-logo"
            src="../../assets/logos/horizontal-logo.png"
            alt=""
          />
        </router-link>
        <router-link to="/home"
          ><img
            id="secundary-logo"
            src="../../assets/logos/icon-logo.png"
            alt=""
        /></router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse" />

      <!-- Navbar links -->
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="ml-auto text-center text-dark font-weight-regular">
          <router-link
            to="/home"
            class="px-2 my-auto"
            active-class="activeLink"
          >
            홈
          </router-link>
          <router-link
            to="/notice"
            class="px-2 my-auto"
            active-class="activeLink"
          >
            공지사항
          </router-link>
          <router-link
            to="/Community"
            class="px-2 my-auto"
            active-class="activeLink"
          >
            커뮤니티
          </router-link>
          <router-link
            to="/interestArea"
            class="px-2 my-auto"
            active-class="activeLink"
          >
            관심지역
          </router-link>
          <router-link
            to="/mypage"
            class="px-2 my-auto"
            active-class="activeLink"
          >
            마이페이지
          </router-link>
          <div v-if="userInfo">
            <b-button
              @click="logout"
              id="home"
              style="
                max-width: 100%;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
              "
              class="
                ml-0
                mt-3 mt-lg-0
                ml-lg-4
                px-4
                py-2
                rounded-pill
                font-weight-bold
              "
              variant="dark"
            >
              로그아웃
            </b-button>
          </div>
          <div v-else>
            <b-button
              to="/login"
              id="login"
              style="
                max-width: 100%;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
              "
              class="
                ml-0
                mt-3 mt-lg-0
                ml-lg-4
                px-4
                py-2
                rounded-pill
                font-weight-bold
              "
              variant="dark"
            >
              로그인
            </b-button>
          </div>
        </b-navbar-nav>

        <!-- Controls dropdown -->
        <div class="d-flex justify-content-center m-3 m-md-0">
          <b-dropdown
            v-if="isconnected"
            right
            toggle-class="text-decoration-none"
            class="mx-auto m-md-2 pl-1 text-center"
            variant="light"
            no-caret
          >
            <template #button-content>
              <b-avatar button :src="`${avatar}`" size="4rem" />
            </template>
            <b-dropdown-item>
              <div class="py-2">
                <span class="px-2">
                  <img
                    style="max-width: 50px"
                    src="../../assets/rsk/RSK_Logo_RGB_150dpi.png"
                    alt=""
                  />
                </span>
                <span>RSK Testnet</span>
              </div>
            </b-dropdown-item>
            <b-dropdown-divider />
            <b-dropdown-item to="/profile">
              <div class="py-2">
                <span class="px-2"><b-icon-person /></span> My profile
              </div>
            </b-dropdown-item>
            <b-dropdown-item to="/help">
              <div class="py-2">
                <span class="px-2"><b-icon-question-circle /></span>
                Need help?
              </div>
            </b-dropdown-item>
            <b-dropdown-item to="/help">
              <div class="py-2">
                <span class="px-2"><b-icon-bug /></span> Report a bug
              </div>
            </b-dropdown-item>
            <b-dropdown-divider />
            <b-dropdown-item-button
              :disabled="disconnectBtnState"
              @click="disconnectAcc()"
            >
              <div class="py-2">
                <span class="px-2"><b-icon-box-arrow-left /></span>
                Disconnect
              </div>
            </b-dropdown-item-button>
          </b-dropdown>
        </div>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import { mapState, mapGetters, mapActions } from "vuex";

const userStore = "userStore";

export default {
  name: "HeaderNav",
  data() {
    return {
      isvisible: false,
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),

    // walletConnectText() {
    //   console.log(sessionStorage.getItem("access-token"), 433242342352);
    //   if (sessionStorage.getItem("access-token") == "null") {
    //     this.isvisible = true;
    //     console.log(this.isvisible, 555555555555555555);
    //     return true;
    //   } else {
    //     this.isvisible = false;
    //     return false;
    //   }
    // },

    ...mapState([
      "showinstallMetaModalState",
      "isconnected",
      "connectBtnState",
      "disconnectBtnState",
      "avatar",
    ]),
  },
  methods: {
    ...mapActions(["showinstallMetaModal", "connect_wallet", "disconnectAcc"]),
    ...mapActions(userStore, ["userLogout"]),

    logout() {
      console.log(sessionStorage.getItem("access-token"), 222222222222);
      sessionStorage.setItem("access-token", null);
      this.isvisible = true;
      this.userLogout(this.userInfo.userid);
      sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
      sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기

      if (this.$route.path !== "/home") {
        this.$router.push({
          name: "home",
        });
      } else {
        this.$route.redirectedFrom();
      }
    },
    check() {
      return true;
    },
  },
};
</script>

<style lang="scss">
@import "../../assets/variables.scss";
#principal-logo {
  display: none;
}
#secundary-logo {
  display: none;
}
#wallet-ico {
  max-width: 30px;
}
#connectWalletOptionsLogo {
  max-width: 40px;
}
@media screen and (min-width: 600px) {
  #principal-logo {
    display: initial;
    max-width: 200px;
  }
  #secundary-logo {
    display: none;
  }
}
@media screen and (max-width: 600px) {
  #principal-logo {
    display: none;
  }
  #secundary-logo {
    display: initial;
    max-width: 50px;
  }
}
.activeLink {
  font-weight: 800;
  color: #2d2d2d;
}
</style>
