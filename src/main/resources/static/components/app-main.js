Vue.component('app-main', {
    template: `
    <el-container>
        <el-row :gutter="20" style="width: 100%; height: 600px">
            <el-col :span="6" style="height: 100%; background-color: #E4E7ED; padding-top: 10px">
                <notebook-list></notebook-list>
            </el-col>

            <el-col :span="6" style="height: 100%; background-color: #F2F6FC; padding-top: 10px">
                <notepage-list></notepage-list>
            </el-col>

            <el-col :span="12" style="height: 100%">
                <notepage></notepage>
            </el-col>
        </el-row>
    </el-container>
    `,

    data() {
        return {

        }
    },

    methods: {

    }
});
