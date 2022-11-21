<template>
    <!-- 지역, 매매년월 컴포넌트-->
    <b-row>
        <b-col class="d-lg-flex justify-content-lg-center">
            <!-- 시도 선택 -->
            <b-col col-xs-3 class="d-flex my-3">
                <b-form-select
                    v-model="sidoCode"
                    :options="sidos"
                    @change="gugunList"
                    class="ml-0 rounded-pill"
                ></b-form-select>
            </b-col>
            <!-- 구군 선택 -->
            <b-col col-xs-3 class="d-flex my-3">
                <b-form-select
                    v-model="gugunCode"
                    :options="guguns"
                    @change="dongList"
                    class="ml-0 rounded-pill"
                ></b-form-select>
            </b-col>
            <!-- 법정동 선택 -->
            <b-col col-xs-3 class="d-flex my-3">
                <b-form-select
                    v-model="dongCode"
                    :options="dongs"
                    class="ml-0 rounded-pill"
                ></b-form-select>
            </b-col>
            <b-col col-xs-1 class="d-flex my-3">
                <a href="#list"
                    ><b-button
                        style="
                            max-width: 100%;
                            overflow: hidden;
                            white-space: nowrap;
                            text-overflow: ellipsis;
                        "
                        variant="dark"
                        class="rounded-pill font-weight-bold"
                        @click="searchApt()"
                        >조회</b-button
                    ></a
                >
            </b-col>
        </b-col>
    </b-row>
    <!-- 지역, 매매년월 컴포넌트 끝-->
</template>

<script>
    import { mapState, mapActions, mapMutations } from "vuex";
    const aptStore = "aptStore";
    export default {
        name: "AreaAdd",
        data() {
            return {
                sidoCode: null,
                gugunCode: null,
                dongCode: null,
            };
        },
        computed: {
            ...mapState(aptStore, ["sidos", "guguns", "dongs"]),
        },
        methods: {
            searchApt() {
                //aptlist로 이동
            },
        },
        created() {
            this.CLEAR_SIDO_LIST();
            this.CLEAR_APT_LIST();
            this.getSido();
        },
        methods: {
            ...mapActions(aptStore, ["getSido", "getGugun", "getDong"]),
            ...mapMutations(aptStore, ["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_DONG_LIST"]),
            gugunList() {
                this.CLEAR_GUGUN_LIST();
                this.gugunCode = null;
                if (this.sidoCode) this.getGugun(this.sidoCode);
            },
            dongList() {
                this.CLEAR_DONG_LIST();
                this.dongCode = null;
                if (this.gugunCode) this.getDong(this.gugunCode);
            },
            searchApt() {
                if (this.dongCode) this.getAptList(this.dongCode);
            },
        },
    };
</script>

<style></style>
