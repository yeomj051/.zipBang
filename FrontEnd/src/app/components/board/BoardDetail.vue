<template>
    <div>
        <b-container class="bv-example-row mt-3">
            <b-row>
                <b-col>
                    <b-alert show><h3>글보기</h3></b-alert>
                </b-col>
            </b-row>
            <b-row class="mb-1">
                <b-col class="text-left">
                    <b-button variant="outline-primary" @click="moveList">목록</b-button>
                </b-col>
                <b-col class="text-right" v-if="userInfo.userid === article.userid">
                    <b-button
                        variant="outline-info"
                        size="sm"
                        @click="moveModifyArticle"
                        class="mr-2"
                        >글수정</b-button
                    >
                    <b-button variant="outline-danger" size="sm" @click="deleteArticle"
                        >글삭제</b-button
                    >
                </b-col>
            </b-row>
            <b-row class="mb-1">
                <b-col>
                    <b-card
                        :header-html="`<h3>${article.articleno}.
          ${article.subject} [${article.hit}]</h3><div><h6>${article.userid}</div><div>${article.regtime}</h6></div>`"
                        class="mb-2"
                        border-variant="dark"
                        no-body
                    >
                        <b-card-body class="text-left">
                            <div v-html="message"></div>
                        </b-card-body>
                    </b-card>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>
<script>
    import { mapState, mapActions } from "vuex";

    const userStore = "userStore";
    const boardStore = "boardStore";
    export default {
        name: "BoardDetail",
        data() {
            return {
                article: {},
            };
        },
        computed: {
            ...mapState(userStore, ["userInfo"]),
            ...mapState(boardStore, ["board"]),
            message() {
                if (this.article.content) return this.article.content.split("\n").join("<br>");
                return "";
            },
        },
        created() {
            let param = this.$route.params.articleno;
            this.storeGetArticle(param);
            this.article = this.board;
        },
        methods: {
            ...mapActions(boardStore, ["storeGetArticle"]),
            moveModifyArticle() {
                this.$router.replace({
                    name: "boardmodify",
                    params: { articleno: this.article.articleno },
                });
                //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
            },
            deleteArticle() {
                if (confirm("정말로 삭제?")) {
                    this.$router.replace({
                        name: "boarddelete",
                        params: { articleno: this.article.articleno },
                    });
                }
            },
            moveList() {
                this.$router.push({ name: "boardlist" });
            },
        },
    };
</script>
<style lang=""></style>
