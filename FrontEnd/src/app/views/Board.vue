<template>
    <div>
        <HeaderNav />

        <div class="bv-example-row mt-3 text-center">
            <h3 class="underline-hotpink"><b-icon icon="journals"></b-icon>Community</h3>
            <BoardList />
            <Footer />
        </div>
    </div>
</template>

<script>
    import HeaderNav from "../components/include/HeaderNav.vue";
    import Footer from "../components/include/Footer.vue";
    import BoardList from "../components/board/BoardList.vue";
    export default {
        name: "Board",

        components: {
            HeaderNav,
            Footer,
            BoardList,
        },
    };
</script>

<style></style>
