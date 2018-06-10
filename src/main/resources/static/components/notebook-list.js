Vue.component('notebook-list', {
    template: `
    <div class="notebook-list-area" style="height: 100%">

    <div class="notebook-header" style="margin-bottom: 10px; margin-left: 5px; margin-right: 5px">
        <span>我的笔记本</span>
        <!-- 添加笔记本按钮 -->
        <el-button
            style="float: right; padding: 5px 8px"
            type="primary"
            icon="el-icon-plus"
            size="small"
            @click="addVisible=true"
            v-if="state.currentUser"></el-button>
        <!-- 添加笔记本对话框 -->
        <el-dialog title="添加笔记本"
            :visible.sync="addVisible"
            width="30%"
            style="text-align: left">
            <el-form :model="form">
                <el-form-item label="笔记本名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="笔记本描述">
                    <el-input v-model="form.desc"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addVisible = false">取 消</el-button>
                <el-button type="primary" @click="addNotebook">添 加</el-button>
            </div>
        </el-dialog>
    </div>

    <!-- 删除笔记本对话框 -->
    <!-- el-dialog title="添加笔记本"
        :visible.sync="addVisible"
        width="30%"
        style="text-align: left">
        <el-form :model="form">
            <el-form-item label="笔记本名">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="笔记本描述">
                <el-input v-model="form.desc"></el-input>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="addVisible = false">取 消</el-button>
            <el-button type="primary" @click="addNotebook">添 加</el-button>
        </div>
    </el-dialog -->

    <div style="text-align: center"
        v-if="state.notebooks.length === 0">
        <img src="../images/null_data.png"/>
    </div>

    <div style="height: 100%; overflow-y: auto">
    <el-card class="box-card"
        shadow="hover"
        style="margin-top: 10px;"
        v-for="notebook in state.notebooks"
        v-if="!notebook.deleted"
        :key="notebook.notebookId">
        <div slot="header" class="clearfix">
            <span>{{ notebook.notebookName }}</span>

            <div style="float: right; padding: 3px 0">
            <el-button-group>
                <el-button type="danger" plain
                    style="padding: 5px 8px"
                    size="small"
                    @click="deleteNotebook(notebook)"
                    icon="el-icon-delete"></el-button>
                <el-button type="primary" plain
                    style="padding: 5px 8px"
                    size="small"
                    icon="el-icon-edit"></el-button>
                <el-button type="primary" plain
                    style="padding: 5px 8px"
                    size="small"
                    v-if="notebook.stared" icon="el-icon-star-on"
                    @click="starNotebook(notebook)"></el-button>
                <el-button type="primary" plain
                    style="padding: 5px 8px"
                    size="small"
                    v-else icon="el-icon-star-off"
                    @click="starNotebook(notebook)"></el-button>
                <el-button type="primary" plain
                    style="padding: 5px 8px"
                    size="small"
                    icon="el-icon-arrow-right"
                    @click="selectNotebook(notebook)"></el-button>
            </el-button-group>
            </div>
        </div>
        <div class="text item">
            <p>{{ notebook.notebookDesc }}</p>
        </div>
    </el-card>
    </div>
    </div>
    `,

    data() {
        return {
            state: state,
            form: {
                name: '',
                desc: ''
            },
            addVisible: false
        }
    },

    methods: {
        selectNotebook(notebook) {
            state.currentNotebook=notebook;
            ax.get(`/notepages/notebooks/${notebook.notebookId}`).then((res) => {
                state.notepages = res.data;
            });
        },

        addNotebook() {
            let dialog = this;
            ax.post(`/notebooks/`, {
                ownerId: state.currentUser.userId,
                notebookName: this.form.name,
                notebookDesc: this.form.desc
            }).then((res) => {
                this.$message({
                    message: '添加笔记本成功',
                    type: 'success'
                });
                dialog.addVisible = false;
                id = res.data;
                state.notebooks = [];
                state.currentNotebook = null;
                state.notepages = [];
                state.currentNotepage = null;
                
                app.getAllNotebooks();
            });
        },

        deleteNotebook(notebook) {
            let id = notebook.notebookId;
            ax.delete(`/notebooks/${notebook.notebookId}`)
                .then((res) => {
                    let idx = state.notebooks.findIndex(n => n.notebookId === id);
                    state.notebooks[idx].deleted = true;
                    if (state.currentNotepage != null
                        && state.currentNotepage.notebookId === id) {
                        state.notepages.forEach((e, i, a) => {
                            e.deleted = true;
                        });
                        state.currentNotepage = null;
                    }
                    this.$message({
                        message: '笔记本删除成功',
                        type: 'success'
                    });
                    // bus.$emit(events.RELOAD);
                });
        },

        updateNotebook(notebook) {

        },

        starNotebook(notebook) {
            if (notebook.stared == true) {
                notebook.stared = false;
            } else {
                notebook.stared = true;
            }
            ax.put(`notebooks/${notebook.notebookId}`, {
                stared: notebook.stared
            }).then((res) => {

            });
        }
    }
});
