<template>
  <b-container class="bv-example-row mt-3">
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()">글쓰기</b-button>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <!-- <b-table
                    striped
                    hover
                    :items="articles"
                    :fields="fields"
                    @row-clicked="viewArticle"
                    class="boardListTitle ml-0 mt-3 mt-lg-0 ml-lg-4 px-4 py-2 rounded-pill font-weight-bold btn-dark"
                >
                    <template #cell(subject)="data">
                        <router-link
                            :to="{
                                name: 'boardview',
                                params: { articleno: data.item.articleno },
                            }"
                        >
                            {{ data.item.subject }}
                        </router-link>
                    </template>
                </b-table> -->
        <div class="question__section mx-auto">
          <div
            class="question-item bg-dark text-light w-100 px-3 px-md-4 py-1 my-4 row"
            data-aos="fade-up"
            duration="2000"
          >
            <!-- <b-icon icon="question-circle" class="ml-1 ml-md-3 mr-3 mb-0"></b-icon> -->
            <div class="col"><p class="my-2 font-weight-bold text-left">글번호</p></div>
            <div class="col-4"><p class="my-2 font-weight-bold text-left">제목</p></div>
            <div class="col-3"><p class="my-2 font-weight-bold">작성자</p></div>
            <div class="col-2"><p class="my-2 font-weight-bold">작성일</p></div>
            <div class="col"><p class="my-2 font-weight-bold text-right">조회수</p></div>
          </div>
          <div v-if="apts && apts.length != 0" class="resultList">
            <board-list-item v-for="(apt, index) in apts" :key="index" :apt="apt" />
          </div>
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
export default {
  name: "BoardList",
  data() {
    return {
      articles: [],
      fields: [
        { key: "articleno", label: "글번호", tdClass: "tdClass" },
        { key: "subject", label: "제목", tdClass: "tdSubject" },
        { key: "userid", label: "작성자", tdClass: "tdClass" },
        { key: "regtime", label: "작성일", tdClass: "tdClass" },
        { key: "hit", label: "조회수", tdClass: "tdClass" },
      ],
    };
  },
  created() {
    http.get(`/board`).then(({ data }) => {
      this.articles = data;
    });
  },
  methods: {
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
// .tdClass {
//   width: 50px;
//   text-align: center;
// }
// .tdSubject {
//   width: 300px;
//   text-align: left;
// }

// .about-view {
//   .about__section {
//     margin: 100px 0;
//     .about-info__container,
//     .about-img__container {
//       display: flex;
//       align-items: center;
//       h1 {
//         font-size: 50px;
//       }
//     }
//   }
// }
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
  .resultList {
    overflow: scroll;
    height: 800px;
    width: 450px;
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
    .apt-list-item {
      border-radius: 50px;
      .question__icon {
        display: flex;
        align-items: center;
        img {
          transform: rotate(90deg);
        }
      }
    }
  }
  .question-item__card {
    border: none;
  }
}
</style>
