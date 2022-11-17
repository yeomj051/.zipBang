<template>
  <div class="FAQ__container pt-5">
    <div class="question__section mx-auto">
      <b-table
        striped
        hover
        :items="articles"
        :fields="fields"
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
      </b-table>
    </div>
  </div>
</template>
<script>
export default {
  name: "AptList",
  data() {
    return {
      articles: [],
      fields: [
        { key: "aptname", label: "아파트명", tdClass: "tdClass" },
        { key: "price", label: "가격", tdClass: "tdSubject" },
      ],
    };
  },
  methods: {
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
.FAQ__container {
  #see-more {
    margin: 200px 0;
    &:hover {
      cursor: pointer;
      text-decoration: underline;
    }
  }
  .faq__container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    width: 70%;
    margin: 50px 0 100px;
    #faq__desc {
      width: 70%;
      margin: 0 auto;
    }

    @media (max-width: 800px) {
      width: 100%;
      #faq__desc {
        width: 95%;
      }
    }
  }
  .question__section {
    width: 70%;
    margin: 100px 0 200px;
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

    .question-item__card {
      border: none;
    }
  }
}
</style>
