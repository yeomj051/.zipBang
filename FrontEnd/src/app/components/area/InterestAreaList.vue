<template>
  
    <div class="p-0 col-md-12 col-lg-6 col-xl-5 col-12 ">
            <div class="block clearfix">

              <div class="separator-2"></div>
              <div class="separator-2">
                <h3 class="title " style="text-align:center; font-weight: 900;">관심 지역 목록</h3>
              </div>


              <div class="separator-2"></div>
              <div id="question__section mx-auto">
                <c:forEach var="area" items="${areas}">
                  <div class="poll-answer-item bg-dark text-light d-flex justify-content-between w-100 px-2 px-md-4 py-3 my-4 aos-init aos-animate collapsed rounded-pill" style="overflow-anchor: none;">
                    <h3>
                      <!-- 이전 jsp 방식<a class="accordion-body">${area.areaArddres} </a> -->
                      <a class="accordion-body"> 강남구 </a>
                    </h3>
                    <img src="assets/img/Artboard 81 1..png" alt="">                              
                  </div>
                  <hr>
                  
                  
                </c:forEach>
              </div>
              <font-awesome-icon icon="fa-duotone fa-trash" />
            </div>
    </div>
  
</template>

<script>
export default {
  name: "InterestAreaList",
};
</script>

<style>
</style>
