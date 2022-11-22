/* eslint-disable no-undef */
import Vue from "vue";
import Router from "vue-router";
import store from "../store";

Vue.use(Router);

const routes = [
  {
    path: "/home",
    name: "home",
    component: () => import(/* webpackChunkName:"home" */ "../views/Home"),
  },
  { path: "/", redirect: { name: "home" } },
  {
    path: "/",
    redirect: { name: "home" },
  },
  {
    path: "*",
    name: "404",
    component: () => import(/* webpackChunkName:"home" */ "../views/404View"),
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import(/* webpackChunkName:"home" */ "../views/Board"),
  },
  {
    path: "/community",
    name: "community",
    component: () => import(/* webpackChunkName:"home" */ "../views/Board"),
  },

  {
    path: "/interestArea",
    name: "interestArea",
    component: () => import(/* webpackChunkName:"home" */ "../views/InterestArea"),
  },
  {
    path: "/mypage",
    name: "mypage",
    component: () => import(/* webpackChunkName:"home" */ "../views/ExploreView"),
  },
  {
    path: "/about",
    name: "about",
    component: () => import(/* webpackChunkName:"home" */ "../views/AboutView"),
  },
  {
    path: "/login",
    name: "login",
    component: () => import(/* webpackChunkName:"profile" */ "../views/Login"),
  },
  {
    path: "/join",
    name: "join",
    component: () => import(/* webpackChunkName:"profile" */ "../views/Join"),
  },
  {
    path: "/findPassword",
    name: "findPassword",
    component: () => import(/* webpackChunkName:"profile" */ "../views/findPassword"),
  },
  {
    path: "/boardwrite",
    name: "boardwrite",
    component: () => import(/* webpackChunkName:"profile" */ "../views/BoardWrite"),
  },
  // {
  //     path: "/:user",
  //     name: "bitcoffee",
  //     component: () => import(/* webpackChunkName:"home" */ "../views/BitcoffeeView"),
  // },
  // {
  //     path: "/member/:id",
  //     name: "member",
  //     component: () => import(/* webpackChunkName:"home" */ "../views/MemberView"),
  // },
];

const router = new Router({
  linkExactActiveClass: "link-active",
  routes,
  mode: "history",
  base: "/",
  scrollBehavior() {
    window.scrollTo(0, 0);
  },
});

router.beforeEach((to, from, next) => {
  if (to.name === "profile" && store.state.isconnected === false) {
    next({ name: "home" });
  } else {
    next();
  }
});

export default router;
