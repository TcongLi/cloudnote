Vue.component('notebook-list', {
    template: `
    <div class="notebook-list-area">

    <div class="notebook-header" style="margin-bottom: 10px; margin-left: 5px; margin-right: 5px">
        <span>我的笔记本</span>
        <el-button
            style="float: right; padding: 5px 8px"
            type="primary"
            icon="el-icon-plus"
            size="small"
            @click="addNotebook"
            v-if="state.currentUser"></el-button>
    </div>

    <div style="text-align: center"
        v-if="state.notebooks.length === 0">
        <img src="../images/null_data.png"/>
    </div>

    <el-card class="box-card"
        shadow="hover"
        style="margin-top: 10px;"
        v-for="notebook in state.notebooks"
        :key="notebook.notebookId">
        <div slot="header" class="clearfix">
            <span>{{ notebook.notebookName }}</span>
            
            <div style="float: right; padding: 3px 0">
            <el-button-group>
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
                    icon="el-icon-caret-right"
                    @click="selectNotebook(notebook)"></el-button>
            </el-button-group>
            </div>
        </div>
        <div class="text item">
            <p>{{ notebook.notebookDesc }}</p>
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
        selectNotebook(notebook) {
            state.currentNotebook=notebook;
            ax.get(`/notepages/notebooks/${notebook.notebookId}`).then((res) => {
                state.notepages = res.data;
            });
        },

        addNotebook() {

        },

        deleteNotebook(notebook) {

        },

        updateNotebook(notebook) {

        },

        starNotebook(notebook) {
            if (notebook.stared == true) {
                notebook.stared = false;
            } else {
                notebook.stared = true;
            }
        }
    }
});
