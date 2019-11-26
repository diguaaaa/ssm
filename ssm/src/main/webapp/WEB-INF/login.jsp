<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
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
            <input width="100" type="text" v-model="loginName"/>
        </div>
        <div>
            <label>密&nbsp码</label>
            <input width="100" type="password" v-model="passWord"/>
        </div>
        <button v-on:click="doLogin(this)" type="button" >登陆</button>
    </form>
</div>

<script>
    new Vue({

        el: "#login_zone",
        data: {
            loginName: "",
            passWord: "",
            power:"",
        },
        methods: {
            doLogin:function () {
                const this_ = this;
                $.ajax({
                    url:"/login1",
                    data:{
                        loginname: this.loginName,
                        password: this.passWord,
                        // power:this.power,
                    },
                    type: "POST",
                    dataType: "JSON",
                    success: function (res) {
                        this_.power = res.power;
                        console.log(this_.power);
                        // console.log(1);
                        // if (this_.power == 1) {
                            window.location = "/toPage?page=index1";
                        // }
                        // else {
                        //     window.location = "/toPage?page=showGame";
                        // }
                    },
                    error: function (res) {
                        alert("登陆服务器出错");
                    },
                })
            },
        },
    })
</script>
</body>
</html>
