<template>
  <div>
    <div
      v-b-toggle="`collapse-${apt.id}`"
      class="question-item bg-beige text-light d-flex justify-content-between w-100 px-3 px-md-4 py-1 my-4"
      data-aos="fade-up"
      duration="2000"
    >
      <div class="d-flex align-items-center">
        <!-- <b-icon icon="question-circle" class="ml-1 ml-md-3 mr-3 mb-0"></b-icon> -->
        <p class="my-2 mx-1 font-weight-bold">{{ apt.apartmentName }}</p>
        <p class="my-2 mx-5 font-weight-bold">{{ apt.dealAmount }}</p>
      </div>
      <div class="question__icon">
        <img src="../../assets/icons/Artboard 81 1.png" alt="" />
      </div>
    </div>
    <b-collapse :id="`collapse-${apt.id}`" accordion="questions">
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
  name: "AptListItem",
  props: {
    apt: Object,
  },

  data() {
    return {
      id: this.apt.id,
    };
  },
  // mounted() {
  //   this.id = this._uid.toString();
  //   console.log("asjofija", this.id);
  // },
};
</script>
<style lang=""></style>
