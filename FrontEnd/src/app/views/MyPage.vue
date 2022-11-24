<template>
  <div>
    <div class="pub-profile">
      <!-- Banner -->

      <div class="head">
        <div
          class="user-profile__background2"
          :style="{
            'background-repeat': 'no-repeat',
            'background-position': 'center',
            'background-size': 'cover',
            'background-image': 'url(' + creator_bg + ')',
          }"
        />
        <!-- User avatar -->
        <div class="user-avatar__container2 text-center">
          <b-avatar :src="`${creator_avatar}`" size="9rem" />
        </div>
      </div>

      <div class="creator-information__container text-center">
        <!-- personal information -->
        <div class="creator-personal-info__container">
          <div class="user-name__container my-3">
            <br />
            <h2>{{ userInfo.nickName }}</h2>
          </div>
          <br />
          <h3>
            소개
            <a
              ><span><b-icon icon="pencil-square" @click="edit"></b-icon></span
            ></a>
          </h3>

          <textarea
            rows="4"
            cols="50"
            v-model="textVal"
            :readonly="editFlag"
            :autoHeight="autoHeight"
            class="textMsg"
            @input="inputing"
            @dblclick="dblclick"
            @blur="blur"
          ></textarea>
        </div>
      </div>
    </div>

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
        class="
          ml-0
          mt-3 mt-lg-0
          ml-lg-4
          px-5
          py-2
          rounded-pill
          font-weight-bold
        "
        variant="dark"
        @click="isJoin"
        >정보수정
      </b-button>
    </div>
  </div>
</template>
  
  <script>
import UserGoalCard from "../components/UserGoalCard.vue";
import DonateBoxView from "../components/DonateBoxView.vue";
import Header from "../components/Header.vue";
import Footer from "../components/Footer.vue";
import { mapMutations } from "vuex";
import { client } from "../../lib/sanityClient";
import { mapState, mapGetters, mapActions } from "vuex";

const userStore = "userStore";

const Web3 = require("web3");
const web3 = new Web3(
  Web3.givenProvider || "https://public-node.testnet.rsk.co"
);

const provider = window.ethereum;

const artifact_crowdfunding = require("../../../build/contracts/CrowdFund.json");
const artifact_crowdfunding_rif = require("../../../build/contracts/CrowdFundERC677.json");
let tokenContract;
import { apiInstance } from "../api/index.js";

const api = apiInstance();
export default {
  name: "MyPage",

  props: {
    rows: {
      default: "",
    },

    autoHeight: {
      default: true,
    },
  },

  data() {
    return {
      user: {
        id: null,
        name: null,
        email: null,
        password: null,
        phone: null,
        nickName: null,
        address: null,
        gender: null,
      },
      noSite: "No site :(",
      noTitle: "No title added",
      noSub: "No subtitle added",
      noDesc: "No description added",
      noBg: "https://images.unsplash.com/photo-1554147090-e1221a04a025?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1148&q=80",

      status: false,
      textVal: null,
      editFlag: true,

      donation: 0,
      monthNames: [
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December",
      ],
      memberAddress: "",

      campaigns_rif: [],
      noCampaigns: false,
      loadingCampaigns: true,

      skeler: false,
    };
  },
  components: {
    UserGoalCard,
    DonateBoxView,
    Header,
    Footer,
  },
  beforeMount() {
    this.$store.dispatch("getCreatorPage", {
      user: this.$route.params.id,
    });

    const query =
      '*[_type == "users" && userName == $user] {userName, userAddress, _createdAt, userVerify}';
    const params = { user: this.$route.params.id };
  },
  created() {
    this.textVal = this.userInfo.introduce;
    this.startedCampaigns();

    this.user.name = this.userInfo.name;
    this.user.phone = this.userInfo.phone;
    this.user.nickName = this.userInfo.nickName;
    this.user.address = this.userInfo.address;
    this.user.password = this.userInfo.password;
  },
  watch: {
    $route(to, from) {
      this.$store.dispatch("getCreatorPage", {
        user: to.params.id,
      });

      const query =
        '*[_type == "users" && userName == $user] {userName, userAddress}';
      const params = { user: this.$route.params.id };

      client
        .fetch(query, params)
        .then((users) => {
          console.log(users);
          if (users.length > 0) {
            users.forEach((user) => {
              this.myaddress =
                user.userAddress.slice(0, 4) +
                "..." +
                user.userAddress.slice(36);
            });
          } else {
            console.log("Creator not found");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  methods: {
    isJoin() {
      this.userInfo.name = this.user.name;
      this.userInfo.phone = this.user.phone;
      this.userInfo.nickName = this.user.nickName;
      this.userInfo.address = this.user.address;
      this.userInfo.password = this.user.password;

      api
        .post(`/user/update`, JSON.stringify(this.userInfo))
        .then(({ data }) => {
          console.log(data);
          alert("정보수정 되었습니다.");
          this.$router.push({ name: "home" });
        })
        .catch((error) => {
          console.log(error);
        });
    },

    ...mapActions(userStore, ["userLogout"]),
    ...mapMutations(["ALLOW_SPEND"]),
    ...mapActions(userStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },
    inputing(val) {
      console.log(val);
    },
    dblclick(e) {
      this.status = false;
    },
    blur(e) {
      this.status = true;
    },
    edit() {
      if (this.editFlag) {
        this.editFlag = false;
      } else {
        this.userInfo.introduce = this.textVal;
        console.log(this.userInfo, 22222222222);
        api
          .post(`/user/update`, JSON.stringify(this.userInfo))
          .then(({ data }) => {
            console.log(data);
          })
          .catch((error) => {
            console.log(error);
            alert("이미 존재하는 이메일 입니다. 다시 입력해 주세요");
          });
        this.editFlag = true;
      }
    },
    async fetchCamps() {
      if (provider) {
        const net = await web3.eth.net.getId();
        let contributors = [];

        tokenContract = new web3.eth.Contract(
          artifact_crowdfunding_rif.abi,
          artifact_crowdfunding_rif.networks[net].address
        );

        tokenContract.setProvider(
          Web3.givenProvider || "https://public-node.testnet.rsk.co"
        );

        const totalCamps = await tokenContract.methods
          .creatorCamps(this.memberAddress)
          .call();

        if (totalCamps < 1) {
          console.log("No campaigns");
          this.noCampaigns = true;
        } else {
          this.skeler = true;
          for (let i = 0; i < totalCamps; i++) {
            let campaign = await tokenContract.methods
              .campaignsAddress(this.memberAddress, i)
              .call();

            let newCampaign = await tokenContract.methods
              .campaigns(await campaign.id)
              .call();

            if ((await newCampaign.id) !== "0") {
              this.campaigns_rif.push(await newCampaign);
            } else {
              console.log("There's an deleted campaign");
            }
          }
          if (this.campaigns_rif.length === 0) {
            console.log("No campaigns");
            this.noCampaigns = true;
          }
        }
      } else {
        console.log("No wallet");
      }
    },
    startedCampaigns() {
      setTimeout(async () => {
        this.fetchCamps();
      }, 5000);
    },

    // Date formated
    onContext1(ctx) {
      // The date formatted
      this.formattedStart = ctx.selectedFormatted;
    },
    onContext2(ctx) {
      // The date formatted
      this.formattedEnd = ctx.selectedFormatted;
    },
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),

    ...mapState([
      "currentAccount",
      "creator_username",
      "creator_site",
      "creator_subtitle",
      "creator_category",
      "creator_instagram",
      "creator_twitter",
      "creator_twitch",
      "creator_youtube",
      "creator_avatar",
      "creator_bg",
      "fetchingDataWait",
      "fetchingData",
      "editProfileModal",
      "listedCategories",
      "fetchingPledge",
      "fetchingCancel",
      "refreshCamps",
    ]),

    // Unixtimestamp for the start date
    startUnixTime2() {
      let min = new Date().getMinutes();
      let hrs = new Date().getHours();
      let mil = new Date().getSeconds();
      const FDate = new Date(
        this.formattedStart + " " + hrs + ":" + min + ":" + mil
      );
      return (this.startUnixtime = FDate.getTime() / 1000);
    },

    // Unixtimestamp for the start date
    endUnixTime2() {
      const FDate = new Date(this.formattedEnd + " 23:59:59");
      return (this.endUnixtime = FDate.getTime() / 1000);
    },

    title() {
      if (!this.creator_title) {
        return this.noTitle;
      } else {
        return this.creator_title;
      }
    },
    subtitle() {
      if (!this.creator_subtitle) {
        return this.noSub;
      } else {
        return this.creator_subtitle;
      }
    },
    site() {
      if (!this.creator_site) {
        return this.noSite;
      } else {
        return this.creator_site;
      }
    },
    description() {
      if (!this.creator_description) {
        return this.noDesc;
      } else {
        return this.creator_description;
      }
    },
  },
  watch: {
    fetchingPledge(newValue, oldValue) {
      console.log(newValue);
      if (!newValue) {
        this.ALLOW_SPEND({ allow: false });
        this.campaigns_rif = [];
        this.fetchCamps();
      }
    },
    fetchingCancel(newValue, oldValue) {
      console.log(newValue);
      if (!newValue) {
        this.campaigns_rif = [];
        this.fetchCamps();
      }
    },
    refreshCamps(newValue, oldValue) {
      console.log(newValue);
      if (!newValue) {
        this.campaigns_rif = [];
        this.fetchCamps();
      }
    },
  },
};
</script>
  
  <style lang="scss">
#category-card {
  transition: ease-in-out 0.2s;
  &:hover {
    color: white;
    filter: brightness(70%);
  }
}
// banner styles
.head {
  position: relative;
  .user-profile__background2 {
    width: 100%;
    height: 100px;
  }

  // avatar styles
  .user-avatar__container2 {
    width: 100%;
    height: auto;
    position: absolute;
    bottom: -60px;
    img {
      width: 150px;
      border-radius: 50%;
    }

    // @media (max-width: 991px) {
    //   top: 315px;
    // }
  }
}

.creator-information__container {
  margin: 0 auto;
  //user personal styles
  .creator-personal-info__container {
    width: 90%;
    margin: 20px auto;
    .user-name__container {
      position: relative;
      font-size: 30px;
      p {
        display: inline-block;
      }
      #verify__badge {
        position: static;
      }
    }
    .user-site {
      &:hover {
        color: #969292;
      }
    }
  }

  .creator-information {
    margin: 200px 0;
    .creator-row {
      margin: 200px 0;
    }

    // creator description styles
    .creator-description__container {
      width: 80%;
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
        .social__section {
          display: flex;
          justify-content: space-around;
          width: 60%;
          margin: 100px auto 20px;
        }
      }
    }

    // category description styles
    .category-description__container {
      width: 80%;
      margin: 0 auto 50px;
      color: white;

      @media (max-width: 500px) {
        width: 100%;
      }

      .category-description__card {
        background-image: linear-gradient(
            to bottom,
            rgba(113, 113, 113, 0.63),
            rgba(0, 0, 0, 0.69)
          ),
          url("../assets/images/chill-back.jpg");
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
        border-radius: 20px;
        text-align: justify;
        width: 100%;
      }
    }
  }
}

.skeler {
  height: 500px;
  .hola {
    width: 50%;
    border-radius: 25px;
    overflow: hidden;
    @media (max-width: 1000px) {
      width: 80%;
    }
  }

  @media (max-width: 1000px) {
    height: 700px;
  }
}

@media (max-width: 790px) {
  .creator-information__container {
    width: 95%;
  }
}
</style>
  