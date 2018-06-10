Vue.component('notepage-list', {
    template: `
    <div class="notepage-list-area">

    <div class="notepage-header" style="margin-bottom: 10px; margin-left: 5px; margin-right: 5px">
        <span>我的笔记</span>
        <el-button
            style="float: right; padding: 5px 8px"
            type="primary"
            icon="el-icon-plus"
            size="small"
            @click="addNotepage"
            v-if="state.currentNotebook"></el-button>
    </div>

    <div style="text-align: center"
        v-if="state.notepages.length === 0 || !state.currentNotebook">
        <img src="../images/null_data.png"/>
    </div>

    <el-card class="box-card"
        shadow="hover"
        style="margin-top: 10px"
        v-for="notepage in state.notepages"
        v-if="!notepage.deleted"
        :key="notepage.notepageId">

            <span>{{ notepage.title }}</span>

            <div style="float: right; padding: 3px 0">
                <el-button-group>
                    <el-button
                        style="padding: 5px 8px"
                        type="primary" plain
                        size="small"
                        v-if="notepage.stared" icon="el-icon-star-on"
                        @click="starNotepage(notepage)"></el-button>
                    <el-button
                        style="padding: 5px 8px"
                        type="primary" plain
                        size="small"
                        v-else icon="el-icon-star-off"
                        @click="starNotepage(notepage)"></el-button>
                    <el-button
                        style="padding: 5px 8px"
                        type="primary" plain
                        size="small"
                        icon="el-icon-edit"
                        :autofocus="isEditing(notepage.notepageId)"
                        @click="selectNotepage(notepage)"></el-button>
                </el-button-group>
            </div>
    </el-card>
    </div>
    `,

    data() {
        return {
            state: state
        }
    },

    methods: {
        isEditing(notepageId) {
            if (state.currentNotepage == null) {
                return false;
            }
            return state.currentNotepage.notepageId === notepageId;
        },

        selectNotepage(notepage) {
            state.currentNotepage = notepage;
        },

        addNotepage() {
            let ownerId = state.currentUser.userId;
            let notebookId = state.currentNotebook.notebookId;
            ax.post(`/notepages/${notebookId}`, {
                ownerId: ownerId,
                notebookId: notebookId,
                title: '',
                content: ''
            }).then((res) => {

            });
        },

        starNotepage(notepage) {
            if (notepage.stared == true) {
                notepage.stared = false;
            } else {
                notepage.stared = true;
            }
        }
    }
});
