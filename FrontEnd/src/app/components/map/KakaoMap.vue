<template>
    <div class="map_wrap">
        <div id="map" style="width: 100%; height: 100%; position: relative; overflow: hidden"></div>
        <ul id="category">
            <li id="BK9" data-order="0">
                <span class="category_bg bank"></span>
                은행
            </li>
            <li id="MT1" data-order="1">
                <span class="category_bg mart"></span>
                마트
            </li>
            <li id="PM9" data-order="2">
                <span class="category_bg pharmacy"></span>
                약국
            </li>
            <li id="OL7" data-order="3">
                <span class="category_bg oil"></span>
                주유소
            </li>
            <li id="CE7" data-order="4">
                <span class="category_bg cafe"></span>
                카페
            </li>
            <li id="CS2" data-order="5">
                <span class="category_bg store"></span>
                편의점
            </li>
        </ul>
    </div>
</template>

<script>
    import { mapState } from "vuex";
    const aptStore = "aptStore";
    export default {
        name: "KakaoMap",
        mounted() {
            if (!window.kakao || !window.kakao.maps) {
                const script = document.createElement("script");
                script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=6189cfde026ec86dd347a64b738c675c&libraries=services,clusterer`;
                /* global kakao */
                script.addEventListener("load", () => {
                    kakao.maps.load(this.initMap);
                });
                document.head.appendChild(script);
            } else {
                this.initMap();
            }
        },
        data() {
            return {
                map: {},
            };
        },
        methods: {
            initMap() {
                // 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
                // var placeOverlay = new kakao.maps.CustomOverlay({ zIndex: 1 }),
                //     contentNode = document.createElement("div"), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다
                //     markers = [], // 마커를 담을 배열입니다
                //     currCategory = ""; // 현재 선택된 카테고리를 가지고 있을 변수입니다

                var container = document.getElementById("map");
                var options = {
                    center: new kakao.maps.LatLng(37.5012743, 127.039585),
                    level: 3,
                };
                this.map = new kakao.maps.Map(container, options);
            },
        },
        computed: {
            ...mapState(aptStore, ["apts"]),
        },
        watch: {
            apts: function () {
                for (var i = 0; i < this.apts.length; i++) {
                    // 마커가 표시될 위치입니다
                    var latlng = new kakao.maps.LatLng(this.apts[i].lat, this.apts[i].lng);

                    //지도 중심 이동
                    this.map.setCenter(latlng);
                    // 마커를 생성합니다
                    var marker = new kakao.maps.Marker({
                        position: latlng,
                    });
                    // 마커가 지도 위에 표시되도록 설정합니다
                    marker.setMap(this.map);
                }
            },
        },
    };
</script>

<style lang="scss">
    .map_wrap,
    .map_wrap * {
        margin: 0;
        padding: 0;
        font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
        font-size: 12px;
    }
    .map_wrap {
        position: relative;
        width: 800px;
        height: 650px;
        margin-bottom: 30px;
        margin-top: 30px;
        margin-left: -30px;

        #category {
            position: absolute;
            top: 10px;
            left: 10px;
            border-radius: 5px;
            border: 1px solid #909090;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
            background: #fff;
            overflow: hidden;
            z-index: 2;
        }
        #category li {
            float: left;
            list-style: none;
            width: 50px;
            border-right: 1px solid #acacac;
            padding: 6px 0;
            text-align: center;
            cursor: pointer;
        }
        #category li.on {
            background: #eee;
        }
        #category li:hover {
            background: #ffe6e6;
            border-left: 1px solid #acacac;
            margin-left: -1px;
        }
        #category li:last-child {
            margin-right: 0;
            border-right: 0;
        }
        #category li span {
            display: block;
            margin: 0 auto 3px;
            width: 27px;
            height: 28px;
        }
        #category li .category_bg {
            background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png)
                no-repeat;
        }
        #category li .bank {
            background-position: -10px 0;
        }
        #category li .mart {
            background-position: -10px -36px;
        }
        #category li .pharmacy {
            background-position: -10px -72px;
        }
        #category li .oil {
            background-position: -10px -108px;
        }
        #category li .cafe {
            background-position: -10px -144px;
        }
        #category li .store {
            background-position: -10px -180px;
        }
        #category li.on .category_bg {
            background-position-x: -46px;
        }
        .placeinfo_wrap {
            position: absolute;
            bottom: 28px;
            left: -150px;
            width: 300px;
        }
        .placeinfo {
            position: relative;
            width: 100%;
            border-radius: 6px;
            border: 1px solid #ccc;
            border-bottom: 2px solid #ddd;
            padding-bottom: 10px;
            background: #fff;
        }
        .placeinfo:nth-of-type(n) {
            border: 0;
            box-shadow: 0px 1px 2px #888;
        }
        .placeinfo_wrap .after {
            content: "";
            position: relative;
            margin-left: -12px;
            left: 50%;
            width: 22px;
            height: 12px;
            background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
        }
        .placeinfo a,
        .placeinfo a:hover,
        .placeinfo a:active {
            color: #fff;
            text-decoration: none;
        }
        .placeinfo a,
        .placeinfo span {
            display: block;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }
        .placeinfo span {
            margin: 5px 5px 0 5px;
            cursor: default;
            font-size: 13px;
        }
        .placeinfo .title {
            font-weight: bold;
            font-size: 14px;
            border-radius: 6px 6px 0 0;
            margin: -1px -1px 0 -1px;
            padding: 10px;
            color: #fff;
            background: #d95050;
            background: #d95050
                url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
                no-repeat right 14px center;
        }
        .placeinfo .tel {
            color: #0f7833;
        }
        .placeinfo .jibun {
            color: #999;
            font-size: 11px;
            margin-top: 0;
        }
    }
</style>
