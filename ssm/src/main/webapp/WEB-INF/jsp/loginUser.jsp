<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆注册</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <style>
        body{
            width: 100%;
            height: 100%;
        }
        #login_zone{
            width: 25%;
            height: auto;
            margin: 100px auto;
        }
    </style>
</head>
<body>
<div id="login_zone">
    <form>
        <div >
            <label>用户名</label>
            <input width="100" type="text" v-model="userId"/>
        </div>
        <div>
            <label>密&nbsp码</label>
            <input width="100" type="password" v-model="userPass"/>
        </div>
        <button v-on:click="doLogin(this)" type="button" >登陆</button>
    </form>
</div>

<script>
    new Vue({
        el: "#login_zone",
        data: {
            userId: "",
            userPass: "",
            userPower: "",
        },
        methods: {
            doLogin:function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/clientLogin",
                    data:{
                        userId: this.userId,
                        userPass: this.userPass,
                        userPower: this.userPower,
                    },
                    type: "POST",
                    dataType: "JSON",
                    success: function (res) {
                        console.log(res);
                        // alert(res.data.userPower);
                        // $("#AjaxData").data(res);
                        if (res.data.userPower != 1) {
                            window.location = "/toPage?page=/jsp/goodsList";
                        } else {
                            window.location = "/toPage?page=/index1";
                        }
                    },
                    error: function (res) {
                        alert("登陆出错");
                    },
                })
            },
        },
    })
</script>
</body>
</html>
