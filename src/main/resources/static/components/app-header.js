Vue.component('app-header', {
    template: `
    <div style="padding-right: 20px; padding-top: 5px">

        <!-- icon -->
        <img src="../images/notebook_icon.png" height="30px" style="margin-top: 10px; float: left"/>
        <h2 style="color: #ffffff; margin-left: 10px; margin-top: 5px; float: left">云笔记系统</h2>

        <!-- 显示当前用户名 -->
        <span v-if="state.currentUser" style="color: #ffffff; margin-right: 10px">{{ state.currentUser.userName }}</span>

        <!-- 登陆按钮 -->
        <el-button style="color: #ffffff" type="text"
            v-if="!state.currentUser"
            @click="signInDialogVisible=true" >登陆</el-button>
        <!-- 登陆对话框 -->
        <el-dialog title="登陆"
            :visible.sync="signInDialogVisible"
            width="40%"
            style="text-align: left">
            <el-form :model="form">
                <el-form-item label="用户名">
                    <el-input v-model="form.username"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input type="password" v-model="form.password"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="signInDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="signIn">登 陆</el-button>
            </div>
        </el-dialog>

        <!-- 注册按钮 -->
        <el-button style="color: #ffffff; margin-left: 10px" type="text"
            v-if="!state.currentUser"
            @click="signUpDialogVisible=true">注册</el-button>
        <!-- 注册对话框 -->
        <el-dialog title="注册"
            :visible.sync="signUpDialogVisible"
            width="40%"
            style="text-align: left">
            <el-form :model="form">
                <el-form-item label="用户名">
                    <el-input v-model="form.username"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input type="password" v-model="form.password"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="signUpDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="signUp">注 册</el-button>
            </div>
        </el-dialog>


        <!-- 退出按钮 -->
        <el-button style="color: #ffffff" type="text"
            v-if="state.currentUser"
            @click="signOut">退出</el-button>
    </div>
    `,

    data() {
        return {
            state: state,
            form: {
                username: '',
                password: ''
            },
            signInDialogVisible: false,
            signUpDialogVisible: false
        }
    },

    methods: {
        signIn() {
            let dialog = this;
            ax.get('/users/signin', {
                params: {
                    username: this.form.username,
                    password: this.form.password
                }
            }).then((res) => {
                console.log(res.data);
                if (res.data === '') {
                    this.$message({
                        message: "用户名或密码错误!",
                        type: "error"
                    });
                } else { // 登陆成功
                    this.$message({
                        message: "登陆成功!",
                        type: "success"
                    });
                    state.currentUser = res.data;
                    dialog.signInDialogVisible = false;
                    bus.$emit(events.SIGN_IN_SUCCESS);
                }
            });

        },

        signOut() {
            console.log("sign out");
            bus.$emit(events.SIGN_OUT);
        },

        signUp() {
            let dialog = this;
            ax.post('/users/signup', {
                userName: this.form.username,
                userPassword: this.form.password
            }).then((res) => {
                console.log(res.data);
                dialog.signUpDialogVisible = false;
                dialog.signIn();
            });
        }
    }
});
