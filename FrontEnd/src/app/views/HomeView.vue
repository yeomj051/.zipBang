<template>
  <div>
    <HeaderNav />
    <b-container>
      <!-- First secrtion -->
      <div class="first-section text-center p-5">
        <img src="../assets/vectors/hearth.png" alt="hearth" class="hearthVector" />
        <img src="../assets/vectors/coffee.png" alt="coffeee" class="coffeeVector" />
        <div class="w-100">
          <h1>
            <strong>Your page, your <br />own place.</strong>
          </h1>
          <p class="py-4">Here with us</p>
          <div class="search-creator text-center">
            <div class="search-creator-input__container">
              <p class="placeholder font-weight-light">bitcoffee.com/</p>
              <input
                class="search-creator__input font-weight-bold"
                type="text"
                v-model="requestedName"
              />
              <div class="search-creator__status" v-show="requestedName">
                <b-icon icon="check-circle-fill" font-scale="1" v-if="isAvailable"></b-icon>
                <b-icon icon="x-circle-fill" font-scale="1" v-if="!isAvailable"></b-icon>
              </div>
              <button class="search-creator__button" :disabled="isAvailableBtn" @click="getMyPage">
                <img src="../assets/icons/Artboard 81 1.png" class="mx-auto" alt="arrow-right" />
              </button>
            </div>
            <b-button
              class="alternativeBtn w-100 bg-dark font-weight-bold"
              pill
              :disabled="isAvailableBtn"
              >Get started</b-button
            >
          </div>
          <p class="pt-4 pb-5">
            Get started now, just connect your wallet and set up <br />your new
            <strong>BitCoffee</strong> page.
          </p>
          <div class="down-arrow" id="down-arrow">
            <img
              src="../assets/icons/Artboard 8 1.png"
              animation="cylon-vertical"
              alt="arrow-down"
              class="py-5"
            />
          </div>
        </div>
      </div>
      <!-- / First section -->
    </b-container>
    <Footer />
  </div>
</template>

<script>
import HeaderNav from "../components/inclßude/HeaderNav.vue";
import Footer from "../components/Footer.vue";
import { mapActions } from "vuex";
import { client } from "../../lib/sanityClient";

export default {
  name: "LoginView",
  components: {
    HeaderNav,
    Footer,
  },
  data() {
    return {
      isAvailable: false,
      requestedName: null,
      fetchingPage: false,
    };
  },
  methods: {
    ...mapActions(["getMyPage"]),
  },
  computed: {
    isAvailableBtn() {
      if (this.isAvailable === false) {
        return true;
      } else {
        return false;
      }
    },
  },
  watch: {
    requestedName() {
      if (this.requestedName) {
        this.fetchingPage = true;
        const query = '*[_type == "users" && userName == $user] {userName, userAddress}';
        const params = { user: this.requestedName };
        client
          .fetch(query, params)
          .then((users) => {
            if (users.length === 0 && this.requestedName.length >= 3) {
              this.isAvailable = true;
            } else {
              this.isAvailable = false;
            }
          })
          .catch((err) => {
            console.log(err);
          });
      } else {
        this.isAvailable = false;
      }
    },
  },
};
</script>

<style lang="scss">
// Css styles for the first section
.first-section {
  display: flex;
  align-items: center;
  height: 90vh;
  position: relative;
  .alternativeBtn {
    display: none;
  }
  .search-creator {
    width: 100%;
    .placeholder {
      display: inline-block;
      margin-right: -130px;
      color: rgb(146, 142, 142);
    }
    .search-creator__input {
      width: 50%;
      height: 45px;
      padding: 10px 100px 10px 130px;
      border-radius: 50px;
      border: 3px solid #594d42;
      outline: none;
      background: transparent;
    }
    .search-creator__button {
      margin-left: -80px;
      height: 45px;
      width: 80px;
      background: #594d42;
      color: white;
      border: 0;
      border-radius: 50px;
      &:hover {
        background-color: #726253;
      }
      &:disabled {
        background-color: #aa9684;
      }
      img {
        width: 20px;
      }
    }
    .search-creator__status {
      width: 100px;
      height: 100px;
      position: absolute;
      top: 44%;
      right: 33%;

      @media (max-width: 1200px) {
        top: 43.5%;
        right: 35%;
      }

      @media (max-width: 990px) {
        top: 43%;
        right: 37%;
      }
    }
  }
  .hearthVector {
    width: 50px;
    opacity: 0.5;
    position: absolute;
    top: 200px;
    transform: rotate(-25deg);
    animation-name: vectorAnimation2;
    animation-duration: 5s;
    animation-iteration-count: infinite;
  }
  .coffeeVector {
    width: 50px;
    opacity: 0.5;
    position: absolute;
    right: 100px;
    bottom: 200px;
    transform: rotate(25deg);
    animation-name: vectorAnimation;
    animation-duration: 5s;
    animation-iteration-count: infinite;
  }
}

// Css styles for the galery section
.galery-section__container {
  display: flex;
  align-items: center;
  height: 100vh;
  .coffee-cupVector {
    width: 30px;
    opacity: 0.5;
    position: absolute;
    right: 60px;
    bottom: 0;
    animation-name: vectorAnimation3;
    animation-duration: 6s;
    animation-iteration-count: infinite;
  }
  .galery-people__column {
    position: relative;
    .galery-people__row {
      display: flex;
      justify-content: space-around;
      img {
        width: 90%;
      }
    }
  }
  .solid-back {
    background-color: #f1e9e1;
    width: 50%;
    height: 90vh;
    position: absolute;
    right: 0;
    z-index: -1;
  }
}

// Css styles for membership section
.membership-section__container {
  position: relative;
  height: 100vh;
  h2 {
    color: rgba(45, 45, 45, 0.5);
  }

  .membershipVector1 {
    width: 50px;
    position: absolute;
    right: 100px;
  }
  .membershipVector2 {
    width: 50px;
    position: absolute;
    left: 150px;
    bottom: 200px;
  }
  .membershipVector3 {
    width: 70px;
    position: absolute;
    left: 200px;
    bottom: 150px;
  }
}

.address-section__img {
  display: flex;
  align-items: center;
  text-align: center;
}

// Animations

#down-arrow {
  animation-name: upAnimation;
  animation-duration: 5s;
  animation-iteration-count: infinite;
  position: relative;
}

// This media query don't works correctly in breackpoint files
@media (max-width: 790px) {
  .galery-section__container {
    height: auto;
  }
}
</style>
