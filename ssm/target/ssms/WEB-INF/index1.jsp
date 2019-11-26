<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/29
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
</head>
<body>
<div id="list_zone">

    <el-table
            :data="tableData"
            style="width: 100%">
        <el-table-column
                prop="userId"
                label="申请编号">
        </el-table-column>
        <el-table-column
                prop="userName"
                label="员工编号">
        </el-table-column>
        <el-table-column
                prop="gName"
                label="游戏目录">
        </el-table-column>
        <el-table-column
                fixed="right"
                label="操作"
                width="150">
            <template slot-scope="scope">
                <el-button @click="doEdit(scope.row)" type="text" size="small">编辑</el-button>
                <el-button @click="doSave(scope.row)" type="text" size="small">拷贝</el-button>
                <el-button @click="doDel(scope.row)" type="text" size="small">删除</el-button>
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
            // user_id: "",
            // user_name: "",
            // choiceList:"",
            // choicedetailList:"",
            // game:"",
            // g_name:"",
        },
        //删除申请信息
        methods:{
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
                window.location ="toEditUser?userId="+row.userId;

            },
            doSave:function(row){
            }

        },
        //显示员工信息
        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"/showUser",
                data:{},
                type:"post",
                dataType:"json",
                success:function (res) {
                    this_.tableData = res.data;

                    console.log(res.data);
                },
                error:function () {
                    alert("服务器出错");
                }
            })
        }

    })
</script>
</body>
</html>
