const baseURL = 'http://127.0.0.1:8081';

const ax = axios.create({
    baseURL: baseURL
});

// 全局状态
let state = {
    currentUser: null,     // 当前用户信息
    notebooks: [],         // 用户笔记本列表
    currentNotebook: null, // 当前选中的笔记本
    notepages: [],         // 当前选中的笔记本的笔记页列表
    currentNotepage: null  // 当前选中的笔记页
}

const app = new Vue({
    el: '#app',

    data: {
        state: state
    },

    mounted() {
        bus.$on(events.SIGN_IN_SUCCESS, () => {
            app.getAllNotebooks(state.currentUser.userId);
        });

        bus.$on(events.SIGN_OUT, () => {
            app.clearState();
        });
    },

    methods: {
        clearState() {
            state.currentUser = null;
            state.notebooks = [];
            state.currentNotebook = null;
            state.notepages = [];
            state.currentNotepage = null;
        },

        getAllNotebooks(userId) {
            ax.get(`/notebooks/${userId}`)
                .then((res) => {
                    console.log(res.data);
                    state.notebooks = res.data;
                });
        },

        getAllNotepages(notebookId) {
            console.log(notebookId);
            ax.get(`/notepages/notebooks/${notebookId}`)
                .then((res) => {
                    console.log(res.data);
                    state.notepages = res.data;
                });
        }
    }
});
