<template>
    <footer class="py-5">
        <b-container class="py-5">
            <b-row class="mt-5 text-center text-lg-left">
                <b-col cols="12">
                    <h5 class="font-weight-bold">Made by:</h5>
                </b-col>
                <b-col cols="12" class="d-flex justify-content-center justify-content-lg-start">
                    <a href="https://www.ssafy.com/">
                        <img
                            src="../../assets/logos/ssafy-logo.png"
                            style="width: 50%"
                            alt="SSAFY LOGO"
                        />
                    </a>
                </b-col>
            </b-row>
        </b-container>
    </footer>
</template>

<script>
    export default {
        name: "Footer",
        data() {
            return {};
        },
    };
</script>

<style lang="scss">
    @import "../../assets/variables.scss";
    footer {
        background-color: $dark;
        color: #ffffff;
        z-index: 20px;

        .footer__link {
            &:hover {
                opacity: 100%;
                color: rgb(219, 197, 147);
            }
        }
    }
    .poweredLogos {
        max-width: 250px;
        transition: 0.1s ease-in;
        &:hover {
            opacity: 50%;
        }
    }
</style>
