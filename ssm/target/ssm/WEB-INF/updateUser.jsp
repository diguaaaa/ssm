<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>员工信息修改</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link href='http://fonts.useso.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>--%>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="http://localhost:8080/lib/font-awesome/css/font-awesome.css">
    <%--<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/stylesheets/premium.css">
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" href="/index.css" >
    <script src="/index.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <style>
        #init_zone{
            width: 25%;
            height: auto;
            margin: 100px auto;
        }
    </style>
    <% String choiceId = request.getParameter("choiceId");%>
</head>
<body>
<input  id="choiceId" name="choiceId" value="<%=choiceId %>"  />

<div id="init_zone">
    <form>
        <div>
            <label>订单编号</label>
            <input type="text"  v-model="choice_id" width="200"/>
        </div>
        <div>
            <label>客户姓名</label>
            <input type="text"  v-model="user_name" width="200"/>
        </div>
        <div>
            <label>游戏名称</label>
            <input type="text"  v-model="g_name" width="200" height="400"/>
        </div>
        <div>
            <label>存放路径</label>
            <input type="text"  v-model="g_address" width="200" height="400"/>
        </div>
    </form>
    <div class="btn-toolbar list-toolbar">
        <button class="btn btn-primary" v-on:click="doUpdate" type="button"> 提交</button>
        <button class="btn btn-primary" v-on:click="doRes" type="button"> 返回</button>
    </div>
</div>

<%--<script src="${pageContext.request.contextPath}/js/vue.js"></script>--%>
<script>
    new Vue({
        el: "#init_zone",
        data: {
            // user_id:"",
            choice_id: "",
            user_name: "",
            g_name:"",
            g_address:"",
        },
        methods: {
            doRes: function () {
                window.location="toShowUser";
            },
            doUpdate: function () {
                $.ajax({
                    url: "/upUser",
                    <%--${pageContext.request.contextPath}--%>
                    data: {
                        // userId: this.user_id,
                        choiceId:this.choice_id,
                        userName: this.user_name,
                        gName:this.g_name,
                        gAddress:this.g_address,
                    },
                    type:"post",
                    dataType: "json",
                    success: function () {
                        window.location = "/toPage?page=index1";
                    },
                    error:function () {
                        alert("失败");
                    }
                })
            },
        },
        mounted: function () {
            const this_ = this;
            $.ajax({
                url: "/selectUser",
                data:{
                    choiceId:$("#choiceId").val(),
                },
                type: "get",
                dataType: "json",
                success: function (res) {
                    this_.choice_id = res.data.choiceId;
                    this_.user_name = res.data.userName;
                    this_.g_name = res.data.gName;
                    this_.g_address=res.data.gAddress;
                    console.log(res);
                },
                error: function () {
                    alert("服务器发生错误");
                }
            })
        },
    })
</script>
</body>
</html>