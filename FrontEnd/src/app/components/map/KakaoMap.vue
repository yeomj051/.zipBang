<template>
  <div id="map"></div>
</template>

<script>
export default {
  name: "KakaoMap",

  AreaAdddata() {
    return {
      token: "Bitcoffee",
      map: null,
    };
  },
  methods: {
    initMap() {
      var marker, infowindow;
      var container = document.getElementById("map");
      var myLatLng = new kakao.maps.LatLng(37.5012743, 127.039585);
      var options = {
        center: myLatLng,
        level: 3,
      };
      this.map = new kakao.maps.Map(container, options);

      // 마커가 표시될 위치입니다
      // var myLatLng = new kakao.maps.LatLng(33.450701, 126.570667);

      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
        position: myLatLng,
      });

      // 마커가 지도 위에 표시되도록 설정합니다
      marker.setMap(map);
    },
  },
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
      //console.log("이미 로딩됨: ", window.kakao);
      this.initMap();
    }
  },
};
</script>

<style lang="scss">
#map {
  width: 800px;
  height: 650px;
  margin-bottom: 30px;
  margin-top: 30px;
  margin-left: -30px;
}
</style>
