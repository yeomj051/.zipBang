import { apiInstance } from "./index.js";

const api = apiInstance();

class Board {
  listArticle(param, success, fail) {
    api.get(`/board`, { params: param }).then(success).catch(fail);
  }

  writeArticle(article, success, fail) {
    api.post(`/board`, JSON.stringify(article)).then(success).catch(fail);
  }

  getArticle(articleno, success, fail) {
    api.get(`/board/${articleno}`).then(success).catch(fail);
  }

  modifyArticle(article, success, fail) {
    api.put(`/board`, JSON.stringify(article)).then(success).catch(fail);
  }

  deleteArticle(articleno, success, fail) {
    api.delete(`/board/${articleno}`).then(success).catch(fail);
  }
}

export { board };
