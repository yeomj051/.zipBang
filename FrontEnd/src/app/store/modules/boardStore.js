import { Board } from "../../api/board";
let boardApi = new Board();

const boardStore = {
    namespaced: true,
    state: {
        boardList: [],
        board: null,
    },
    getters: {},
    mutations: {
        SET_BOARD_LIST(state, boardList) {
            state.boardList = boardList;
        },
        SET_BOARD(state, board) {
            state.board = board;
        },
    },
    actions: {
        getBoardList: ({ commit }, params) => {
            boardApi.listArticle(
                params,
                ({ data }) => {
                    commit("SET_BOARD_LIST", data);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        storeRegist({ commit }, params) {
            boardApi.writeArticle(
                params,
                ({ data }) => {
                    let msg = "등록 처리시 문제가 발생했습니다.";
                    if (data === "success") {
                        msg = "등록이 완료되었습니다.";
                    }
                    alert(msg);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        storeModify({ commit }, params) {
            boardApi.modifyArticle(
                params,
                ({ data }) => {
                    let msg = "수정 처리시 문제가 발생했습니다.";
                    if (data === "success") {
                        msg = "수정이 완료되었습니다.";
                    }
                    alert(msg);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
        storeGetArticle({ commit }, params) {
            boardApi.getArticle(
                params,
                ({ data }) => {
                    commit("SET_BOARD", data);
                },
                (error) => {
                    console.log(error);
                }
            );
        },
    },
};

export default boardStore;
