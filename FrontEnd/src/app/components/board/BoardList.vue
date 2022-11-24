<template>
  <b-container class="bv-example-row mt-3">
    <b-row class="mb-1">
      <b-col v-if="flag" class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()"
          >글쓰기</b-button
        >
      </b-col>
    </b-row>
    <div data-aos="fade-up">
      <b-row>
        <b-col
          class="text-center my-5"
          cols="12"
          v-if="itemsForCreatorsList.length === 0"
        >
          <p class="py-5 my-5" style="opacity: 40%">
            <strong>No results.</strong>
          </p>
        </b-col>

        <b-col v-if="itemsForCreatorsList.length > 0">
          <div class="question__section mx-auto">
            <div
              class="
                question-item
                bg-dark
                text-light
                w-100
                px-3 px-md-4
                py-1
                my-4
                row
              "
              duration="2000"
            >
              <!-- <b-icon icon="question-circle" class="ml-1 ml-md-3 mr-3 mb-0"></b-icon> -->
              <div class="col-1">
                <p class="my-2 font-weight-bold text-left">글번호</p>
              </div>
              <div class="col-4">
                <p class="my-2 font-weight-bold text-left">제목</p>
              </div>
              <div class="col-3">
                <p class="my-2 font-weight-bold">작성자</p>
              </div>
              <div class="col-2">
                <p class="my-2 font-weight-bold">작성일</p>
              </div>
              <div class="col">
                <p class="my-2 font-weight-bold text-right">조회수</p>
              </div>
            </div>
            <div v-if="boardList && boardList.length != 0">
              <board-list-item
                v-for="(board, index) in boardList"
                :key="index"
                :board="board"
              />
            </div>
          </div>
        </b-col>
      </b-row>
    </div>
    <b-pagination
      class="my-5"
      v-model="currentPage"
      :total-rows="BoardListrows"
      :per-page="ListsperPage"
      pills
      align="center"
      aria-controls="boardList"
      first-number
      last-number
    ></b-pagination>
  </b-container>
</template>
<script>
import BoardListItem from "./BoardListItem.vue";
import { mapState, mapActions } from "vuex";
const boardStore = "boardStore";
const userStore = "userStore";

export default {
  name: "BoardList",

  data() {
    return {
      flag: false,
      articles: [],
      fields: [
        { key: "articleno", label: "글번호", tdClass: "tdClass" },
        { key: "subject", label: "제목", tdClass: "tdSubject" },
        { key: "userid", label: "작성자", tdClass: "tdClass" },
        { key: "regtime", label: "작성일", tdClass: "tdClass" },
        { key: "hit", label: "조회수", tdClass: "tdClass" },
      ],
      ListsperPage: 9,
      currentPage: 1,
    };
  },
  components: {
    BoardListItem,
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),

    ...mapState(boardStore, ["boardList"]),
    BoardListrows() {
      return this.boardList.length;
    },
    itemsForCreatorsList() {
      return this.boardList.slice(
        (this.currentPage - 1) * this.ListsperPage,
        this.currentPage * this.ListsperPage
      );
    },
  },
  created() {
    const params = {};
    this.getBoardList(params);
    if (this.userInfo.name == "admin") {
      this.flag = true;
    }
  },
  methods: {
    ...mapActions(boardStore, ["getBoardList"]),

    moveWrite() {
      this.$router.push({ name: "boardwrite" });
    },

    viewArticle(article) {
      this.$router.push({
        name: "boardview",
        params: { articleno: article.articleno },
      });
    },
  },
};
</script>
<style lang="scss">
.question__section {
  width: 100%;
  margin: 0px 0 200px;
  .question-item {
    border-radius: 50px;
    .question__icon {
      display: flex;
      align-items: center;
      img {
        transform: rotate(90deg);
      }
    }
  }

  &::-webkit-scrollbar-track {
    border: none;
    padding: 2px 0;
    background-color: #ffffff;
  }

  &::-webkit-scrollbar {
    width: 10px;
  }

  &::-webkit-scrollbar-thumb {
    border-radius: 10px;
    box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
    background-color: #594d42;
    border: none;
  }
  .board-list-item {
    border-radius: 50px;
    .question__icon {
      display: flex;
      align-items: center;
      img {
        transform: rotate(90deg);
      }
    }
  }

  .question-item__card {
    border: none;
  }
}
</style>
