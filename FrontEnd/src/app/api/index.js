import axios from "axios";

// local vue api axios instance
function apiInstance() {
  const instance = axios.create({
    baseURL: `http://localhost:9999`,
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}

function boardInstance() {
  const instance = axios.create({
    baseURL: `http://localhost:9988`,
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });
  return instance;
}
export {
  apiInstance,
  boardInstance
};