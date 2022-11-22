import { apiInstance } from "./index.js";

const api = apiInstance();

//호출 주소 바꾸기

class AreaSearch {
  sidoList(success, fail) {
    api.get(`/map/sido`).then(success).catch(fail);
  }

  gugunList(params, success, fail) {
    api
      .get(`/map/gugun`, {
        params: params,
      })
      .then(success)
      .catch(fail);
  }
  dongList(params, success, fail) {
    api
      .get(`/map/dong`, {
        params: params,
      })
      .then(success)
      .catch(fail);
  }

  aptList(params, success, fail) {
    api
      .get(`/map/apart-list`, {
        params: params,
      })
      .then(success)
      .catch(fail);
  }
}

export { AreaSearch };
