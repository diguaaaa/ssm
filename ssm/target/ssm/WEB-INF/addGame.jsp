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
    <style>
        #init_zone{
            width: 25%;
            height: auto;
            margin: 100px auto;
        }
    </style>
    <% String id = request.getParameter("userId");%>

</head>
<body>
<input type="hidden" id="id" name="id" value="<%=id %>"  />

<div id="init_zone">

    <form>
        <div>
            <label>游戏编号</label>
            <input type="text"   v-model="g_id" width="200" />
        </div>
        <div>
            <label>游戏名称</label>
            <input type="text"  v-model="g_name" width="200"/>
        </div>
        <div>
            <label>存储路径</label>
            <input type="text"  v-model="g_address" width="200"/>
        </div>

    </form>
    <div class="btn-toolbar list-toolbar">
        <button class="btn btn-primary" v-on:click="doAdd" type="button"> 提交</button>
        <button class="btn btn-primary" v-on:click="doRes" type="button"> 返回</button>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/vue.js"></script>--%>
<script>

    new Vue({
        el: "#init_zone",
        data: {
            g_id:"",
            g_name: "",
            g_address: "",
        },
        methods: {
            doRes: function () {
                window.location="toShowUser";
            },
            doAdd: function () {
                $.ajax({
                    url: "/addGame",
                    <%--${pageContext.request.contextPath}--%>
                    data: {
                        gId: this.g_id,
                        gName: this.g_name,
                        gAddress: this.g_address,

                    },
                    type:"post",
                    dataType: "json",
                    success: function () {
                        alert("添加成功");
                        window.location = "/toPage?page=index1";
                    },
                    error:function () {
                        alert("失败");
                    }
                })
            },
        },
        // mounted: function () {
        //     const this_ = this;
        //     $.ajax({
        //         url: "/selectUser",
        //         data:{
        //             id:$("#id").val(),
        //         },
        //         type: "get",
        //         dataType: "json",
        //         success: function (res) {
        //             this_.user_id = res.data.userId;
        //             this_.user_name = res.data.userName;
        //             this_.g_name = res.data.g_name;
        //             console.log(res);
        //         },
        //         error: function () {
        //             alert("服务器发生错误");
        //         }
        //     })
        // },
    })
</script>
</body>
</html>