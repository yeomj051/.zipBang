import { apiInstance } from "./index.js";

const api = apiInstance();
class User {
  async login(user, success, fail) {
    await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
  }

  async findById(userid, success, fail) {
    api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
    await api.get(`/user/info/${userid}`).then(success).catch(fail);
  }

  async tokenRegeneration(user, success, fail) {
    api.defaults.headers["refresh-token"] = sessionStorage.getItem("refresh-token"); //axios header에 refresh-token 셋팅
    await api.post(`/user/refresh`, user).then(success).catch(fail);
  }

  async logout(userid, success, fail) {
    await api.get(`/user/logout/${userid}`).then(success).catch(fail);
  }
}

export { User };
