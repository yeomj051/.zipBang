<template>
    <div>
        <HeaderNav />
        <b-container>
            <!-- 관심지역 AreaAdd컴포넌트 시작-->

            <area-add></area-add>

            <!-- 관심지역 AreaAdd컴포넌트 끝-->
            <!-- 조회 결과 시작 -->
            <div class="second-section" id="list">
                <b-row>
                    <b-col cols="12" md="12" lg="6" xl="7" class="p-0">
                        <interest-area-list></interest-area-list>
                    </b-col>
                    <b-col cols="12" md="12" lg="6" xl="5" class="p-0">
                        <kakao-map></kakao-map>
                    </b-col>
                    <div class="solid-back"></div>
                </b-row>
            </div>
            <!-- 조회 결과 끝 -->
        </b-container>
        <Footer />
    </div>
</template>

<script>
    import HeaderNav from "../components/include/HeaderNav.vue";
    import Footer from "../components/include/Footer.vue";
    import AreaAdd from "../components/area/AreaAdd.vue";
    import InterestAreaList from "../components/area/InterestAreaList.vue";
    import KakaoMap from "../components/map/KakaoMap.vue";

    export default {
        name: "InterestArea",
        data() {
            return {};
        },
        components: {
            HeaderNav,
            Footer,
            AreaAdd,
            InterestAreaList,
            KakaoMap,
        },
    };
</script>

<style lang="scss"></style>
