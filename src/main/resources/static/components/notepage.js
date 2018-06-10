Vue.component('notepage', {
    template: `
    <div class="notepage-area"
        v-if="state.currentNotepage">

    <div style="margin-bottom: 10px">标题</div>
    <el-input
        style="margin-bottom: 5px"
        v-model="state.currentNotepage.title"
        placeholder="标题"></el-input>

    <div style="margin-bottom: 10px">内容</div>
    <el-input
        type="textarea"
        :rows="18"
        placeholder="请输入内容"
        v-model="state.currentNotepage.content">
    </el-input>

    <div style="margin-top: 10px; float: right">
    <el-button-group>
        <el-button type="primary"
            icon="el-icon-check"
            @click="updateNotepage"
            style="padding-left: 30px; padding-right: 30px"></el-button>
        <el-button type="danger"
            icon="el-icon-delete"
            @click="deleteNotepage"
            style="padding-right: 30px; padding-left: 30px"></el-button>
    </el-button-group>
    </div>

    </div>
    `,

    data() {
        return {
            state: state
        }
    },

    methods: {
        updateNotepage() {
            ax.put(`notepages/${state.currentNotepage.notepageId}`, {
                title: state.currentNotepage.title,
                content: state.currentNotepage.content
            }).then((res) => {
                this.$message({
                    message: '保存笔记成功',
                    type: 'success'
                });
            });
        },

        deleteNotepage() {
            let id = state.currentNotepage.notepageId;
            ax.delete(`notepages/${id}`).then((res) => {
                let idx = state.notepages.findIndex(n => n.notepageId === id);
                // state.notepages.splice(idx, 1);
                state.notepages[idx].deleted = true;
                state.currentNotepage = null;
                this.$message({
                    message: '删除笔记成功',
                    type: 'success'
                });
            });
        }
    }
});
