<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/13
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" href="/index.css" >
    <script src="/index.js"></script>
</head>
<body>
<body>
<div id="list_zone">
    <el-button @click="doUser">用户管理</el-button>
    <el-button @click="doIndex1">订单列表</el-button>
    <el-table
            :data="tableData"
            style="width: 100%">
        <el-table-column
                prop="userId"
                label="用户账号">
            <%--<template slot-scope="scope">--%>
            <%--&lt;%&ndash;{{ scope.row.choiceList.choiceId }}&ndash;%&gt;--%>
            <%--</template>--%>
        </el-table-column>
        <el-table-column
                prop="userName"
                label="用户姓名">
        </el-table-column>
        <el-table-column
                prop="userPass"
                label="用户密码">
            <%--<template slot-scope="scope">--%>
            <%--&lt;%&ndash;{{ scope.row.choiceList.choicedetailList.game.gName }}&ndash;%&gt;--%>
            <%--</template>--%>
        </el-table-column>
        <el-table-column
                prop="userPower"
                label="用户权限">
            <%--<template slot-scope="scope">--%>
            <%--&lt;%&ndash;{{ scope.row.choiceList.choicedetailList.game.gAddress }}&ndash;%&gt;--%>
            <%--</template>--%>
        </el-table-column>
        <el-table-column
                fixed="right"
                label="操作"
                width="300">
            <template slot-scope="scope">
                <el-button @click="doEdit(scope.row)"  size="mini">编辑</el-button>
                <el-button @click="doSave(scope.row)"  size="mini">拷贝</el-button>
                <el-button @click="doDel(scope.row)"  size="mini">删除</el-button>
            </template>
        </el-table-column>

    </el-table>
</div>
<script>
    var context = "<%=request.getContextPath()%>";
    new Vue({
        el:"#list_zone",
        data:{
            tableData:[],
        },
        //删除申请信息
        methods:{
            doIndex1:function(){
                window.location ="toIndex1";
            },
            doShowGame:function(){
                window.location ="toShowGame";
            },
            doDel:function (row){
                if(confirm("是否确定删除本记录(注：此处删除系统数据库也会删除对应信息)")) {
                    $.ajax({
                        url: "/delUser",
                        data: {
                            userId: row.userId
                        },
                        type: "post",
                        dataType: "json",
                        success: function (res) {
                            if (res.status == 200) {
                                alert("删除成功！");
                                location.reload();
                            }
                        },
                        error: function () {
                            alert("服务器错误");
                        }
                    })
                }
            },
            doEdit:function (row){
                window.location ="toEditUser?choiceId="+row.choiceId;
            },
            doSave:function(row){
                $.ajax({
                    url:"${pageContext.request.contextPath}/toCopy",
                    data:{
                        gAddress: row.gAddress,
                    },
                    type:"post",
                    dataType:"json",
                    success:function () {
                        alert("拷贝成功");
                    },
                    error:function () {
                        alert("拷贝失败");
                    }
                })
            }

        },
        //显示员工信息
        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"/showUserTable",
                data:{},
                type:"post",
                dataType:"json",
                success:function (res) {
                    this_.tableData = res.data;
                    console.log(res.data);
                },
                error:function () {
                    alert("index1 错误 ");
                }
            })
        }

    })
</script>
</body>
</body>
</html>
