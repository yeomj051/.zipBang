<template>
  <div>
    <b-container>
      <!-- First secrtion -->
      <div class="first-section text-center p-5">
        <img
          src="../assets/vectors/hearth.png"
          alt="hearth"
          class="hearthVector"
        />
        <img
          src="../assets/vectors/coffee.png"
          alt="coffeee"
          class="coffeeVector"
        />

        <div class="w-100">
          <h1 class="py-4">
            <strong>Sign up</strong>
          </h1>
          <LoginView />
        </div>
      </div>
      <!-- / First section -->
    </b-container>
  </div>
</template>
    
    <script>
import HeaderNav from "../components/include/HeaderNav.vue";
import LoginView from "../components/user/JoinView.vue";

export default {
  name: "Login",
  components: {
    HeaderNav,
    LoginView,
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

  .search-creator {
    width: 100%;
    .placeholder {
      align-items: center;
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
</style>
    