<template>
    <b-container class="bv-example-row mt-3">
        <b-row class="mb-1">
            <b-col class="text-right">
                <b-button variant="outline-primary" @click="moveWrite()">글쓰기</b-button>
            </b-col>
        </b-row>

        <b-row>
            <b-col>
                <b-table
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
                </b-table>
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
    .tdClass {
        width: 50px;
        text-align: center;
    }
    .tdSubject {
        width: 300px;
        text-align: left;
    }

    .about-view {
        .about__section {
            margin: 100px 0;
            .about-info__container,
            .about-img__container {
                display: flex;
                align-items: center;
                h1 {
                    font-size: 50px;
                }
            }
        }
    }
</style>
