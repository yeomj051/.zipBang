<template>
  <div>
    <div
      v-b-toggle="'question_2'"
      class="question-item bg-dark text-light d-flex justify-content-between w-100 px-3 px-md-4 py-3 my-4"
      data-aos="fade-up"
      duration="2000"
    >
      <div class="d-flex align-items-center">
        <b-icon icon="question-circle" class="ml-1 ml-md-3 mr-3 mb-0"></b-icon>
        <p class="m-0 font-weight-bold">How it works?</p>
      </div>
      <div class="question__icon">
        <img src="../../assets/icons/Artboard 81 1.png" alt="" />
      </div>
    </div>
    <b-collapse
      id="question_2"
      accordion="questions
        "
    >
      <b-card class="question-item__card text-dark"
        >Simple, through a smart contract, the Campaigns are created in a period of time to make the Crowdsourcing.
        <br />
        <br />
        Once the Campaign is over the creator will be able to claim the pledged tokens only if the amount of contributed
        tokens is equal or more than the amount of tokens defined in the campaign.
        <br />
        <br />
        Otherwise, the users on the campaign will able to refund their tokens.</b-card
      >
    </b-collapse>
  </div>
</template>
<script>
export default {
  name: "DetailApt",
};
</script>
<style></style>
