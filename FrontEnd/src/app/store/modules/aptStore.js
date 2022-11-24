import { AreaSearch } from "../../api/apt";
let searchAptApi = new AreaSearch();

const aptStore = {
    namespaced: true,
    state: {
        sidos: [{ value: null, text: "시도선택" }],
        guguns: [{ value: null, text: "구군선택" }],
        dongs: [{ value: null, text: "법정동선택" }],
        dealYears: [{ value: null, text: "매매년도선택" }],
        dealMonths: [
            { value: null, text: "매매월선택" },
            { value: 1, text: "1월" },
            { value: 2, text: "2월" },
            { value: 3, text: "3월" },
            { value: 4, text: "4월" },
            { value: 5, text: "5월" },
            { value: 6, text: "6월" },
            { value: 7, text: "7월" },
            { value: 8, text: "8월" },
            { value: 9, text: "9월" },
            { value: 10, text: "10월" },
            { value: 11, text: "11월" },
            { value: 12, text: "12월" },
        ],
        apts: [],
        apt: null,
    },
    getters: {},
    mutations: {
        CLEAR_SIDO_LIST(state) {
            state.sidos = [{ value: null, text: "시도선택" }];
        },
        CLEAR_GUGUN_LIST(state) {
            state.guguns = [{ value: null, text: "구군선택" }];
        },
        CLEAR_DONG_LIST(state) {
            state.dongs = [{ value: null, text: "법정동선택" }];
        },
        CLEAR_APT_LIST(state) {
            state.apts = [];
            state.apt = null;
        },
        SET_SIDO_LIST(state, sidos) {
            sidos.forEach((sido) => {
                state.sidos.push({ value: sido.dongCode, text: sido.sidoName });
            });
        },
        SET_GUGUN_LIST(state, guguns) {
            guguns.forEach((gugun) => {
                state.guguns.push({ value: gugun.dongCode, text: gugun.gugunName });
            });
        },
        SET_DONG_LIST(state, dongs) {
            dongs.forEach((dong) => {
                state.dongs.push({ value: dong.dongCode, text: dong.dongName });
            });
        },
        SET_DEALYEAR_LIST(state, year) {
            state.dealYears.push({ value: year, text: year });
        },
        SET_APT_LIST(state, apts) {
            state.apts = apts;
        },
        SET_DETAIL_APT(state, apt) {
            state.apt = apt;
        },
    },
    actions: {
        getSido: ({ commit }) => {
            searchAptApi.sidoList(
                ({ data }) => {
                    commit("SET_SIDO_LIST", data);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        getGugun: ({ commit }, sidoCode) => {
            const params = { dongCode: sidoCode };
            searchAptApi.gugunList(
                params,
                ({ data }) => {
                    commit("SET_GUGUN_LIST", data);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        getDong: ({ commit }, gugunCode) => {
            const params = { dongCode: gugunCode };
            searchAptApi.dongList(
                params,
                ({ data }) => {
                    commit("SET_DONG_LIST", data);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        getYear: ({ commit }) => {
            let date = new Date();
            let year = date.getFullYear();

            for (let i = year; i > year - 20; i--) {
                commit("SET_DEALYEAR_LIST", i);
            }
        },
        getAptList: ({ commit }, params) => {
            searchAptApi.aptList(
                params,
                ({ data }) => {
                    commit("SET_APT_LIST", data);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        detailApt: ({ commit }, apt) => {
            // 나중에 house.일련번호를 이용하여 API 호출
            commit("SET_DETAIL_APT", apt);
        },
    },
};

export default aptStore;
