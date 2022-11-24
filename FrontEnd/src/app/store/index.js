/* eslint-disable no-undef */
import Vue from "vue";
import Vuex from "vuex";
import state from "./state";
import * as getters from "./getters";
import * as mutations from "./mutations";
import { actions } from "./actions";
//modules
import aptStore from "./modules/aptStore";
import userStore from "./modules/userStore";
import boardStore from "./modules/boardStore";

Vue.use(Vuex);

export default new Vuex.Store({
  state,
  getters,
  mutations,
  actions,
  modules: {
    aptStore,
    userStore,
    boardStore,
  },
});
