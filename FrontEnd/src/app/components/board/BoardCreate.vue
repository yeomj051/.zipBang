<template>
  <b-row class="t mb-1">
    <b-col
      class="
        board-input
        text-light
        w-100
        px-3 px-md-4
        py-1
        my-4
        border-radius:
        50px;
      "
      style="text-align: left"
    >
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group
          id="userid-group"
          label="작성자:"
          label-for="userid"
          description="작성자"
        >
          <b-form-input
            id="userid"
            :disabled="isUserid"
            v-model="article.userid"
            type="text"
            required
            :placeholder="userInfo.nickName"
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="subject-group"
          label="제목:"
          label-for="subject"
          description="제목을 입력하세요."
        >
          <b-form-input
            id="subject"
            v-model="article.subject"
            type="text"
            required
            placeholder="제목 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="article.content"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
          ></b-form-textarea>
        </b-form-group>

        <b-button
          type="submit"
          variant="primary"
          class="m-1"
          v-if="this.type === 'register'"
          >글작성</b-button
        >
        <b-button type="submit" variant="primary" class="m-1" v-else
          >글수정</b-button
        >
      </b-form>
    </b-col>
  </b-row>
</template>
<script>
import { mapState, mapGetters, mapActions } from "vuex";

const userStore = "userStore";
const boardStore = "boardStore";
export default {
  name: "BoardCreate",
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  data() {
    return {
      article: {
        articleno: 0,
        userid: "",
        subject: "",
        content: "",
      },
      isUserid: false,
    };
  },
  props: {
    type: { type: String },
  },
  created() {
    if (this.type === "modify") {
      let param = this.$route.params.articleno;
      getArticle(
        param,
        ({ data }) => {
          this.article = data;
        },
        (error) => {
          console.log(error);
        }
      );
      this.isUserid = true;
    }
  },
  methods: {
    ...mapActions(boardStore, ["storeRegist", "storeModify"]),
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.article.userid &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.userid.focus());
      err &&
        !this.article.subject &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.article.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else this.type === "register" ? this.regist() : this.modify();
    },
    onReset(event) {
      event.preventDefault();
      this.article.articleno = 0;
      this.article.subject = "";
      this.article.content = "";
      this.moveList();
    },
    regist() {
      let params = {
        userid: this.article.userid,
        subject: this.article.subject,
        content: this.article.content,
      };
      this.storeRegist(params);
      this.moveList();
    },
    modify() {
      let params = {
        articleno: this.article.articleno,
        userid: this.article.userid,
        subject: this.article.subject,
        content: this.article.content,
      };
      this.storeModify(params);
      this.moveList();
    },
    moveList() {
      this.$router.push({ name: "community" }).catch(() => {});
    },
  },
};
</script>
<style lang="scss"></style>
