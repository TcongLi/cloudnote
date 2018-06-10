const baseURL = 'http://127.0.0.1:8081';

const ax = axios.create({
    baseURL: baseURL
});

const modes = {
    NORMAL: 'NORMAL',
    STAR: 'STAR',
    RECYCLE: 'RECYCLE'
}

// 全局状态
let state = {
    currentUser: null,     // 当前用户信息
    notebooks: [],         // 用户笔记本列表
    currentNotebook: null, // 当前选中的笔记本
    notepages: [],         // 当前选中的笔记本的笔记页列表
    currentNotepage: null, // 当前选中的笔记页

    mode: modes.NORMAL,    // 当前模式

    groupsJoined: [],      // 加入的小组
    groupsCreated: [],     // 创建的小组
    currentGroup: null,    // 当前选中的小组
    groupMembers: []       // 当前选中小组的组成员
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

        /*
        bus.$on(events.RELOAD, () => {
            let currentNotebookId = -1;
            if (state.currentNotebook != null) {
                currentNotebookId = state.currentNotebook.notebookId;
            }
            state.currentNotebook = null;
            
            let currentNotepageId = -1;
            if (state.currentNotepage != null) {
                currentNotepageId = state.currentNotepage.notepageId;
            }
            state.currentNotepage = null;

            state.notepages = [];

            app.getAllNotebooks(state.currentUser.userId);
            for (notebook in state.notebooks) {
                if (notebook.notebookId === currentNotebookId) {
                    state.currentNotebook = notebook;
                }
            }

            if (state.currentNotebook != null) {
                ax.get(`/notepages/notebooks/${state.currentNotebook.notebookId}`).then((res) => {
                    state.notepages = res.data;
                });
            }

            for (notepage in state.notepages) {
                if (notepage.notepageId === currentNotepageId) {
                    state.currentNotepage = notepage;
                }
            }
        });
        */

    },

    methods: {
        clearState() {
            state.currentUser = null;
            state.notebooks = [];
            state.currentNotebook = null;
            state.notepages = [];
            state.currentNotepage = null;
        },

        getAllNotebooks(userId = state.currentUser.userId) {
            ax.get(`/notebooks/${userId}`)
                .then((res) => {
                    console.log(res.data);
                    state.notebooks = res.data;
                });
        },

        getAllNotepages() {
            ax.get(`/notepages/notebooks/${state.currentNotebook.notebookId}`).then((res) => {
                state.notepages = res.data;
            });
        }
    }
});
