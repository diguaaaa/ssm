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
    <link rel="stylesheet" href="/index.css" >
    <script src="/index.js"></script>
</head>
<body>


<div id="list_zone">
    <div>
        <el-menu
                :default-active="activeIndex2"
                class="el-menu-demo"
                mode="horizontal"
        <%--@select="handleSelect"--%>
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b"
                text-color="#e6a23c"
        >
            <el-menu-item @click="doLogin" >管理员登录</el-menu-item>
            <el-menu-item style="float:right">我的</el-menu-item>
            <el-menu-item style="float:right" >订单管理</el-menu-item>
            <el-menu-item @click="doShowGame" style="float:right" >返回游戏列表</el-menu-item>
        </el-menu>
    </div>
    <el-table
            :data="tableData"
            style="width: 100%"
            ref = "multipleTable "
            @selection-change="changeFun">
        <el-table-column
                type="selection"
                @selection-change="changeFun"
                <%--prop="gId"--%>
                width="100px">
        </el-table-column>
        <el-table-column
                prop="gName"
                label="游戏名称">
        </el-table-column>
        <el-table-column
                prop="gSize"
                label="游戏大小">
        </el-table-column>

        <el-table-column
                fixed="right"
                label="操作">
            <template slot-scope="scope">
                <el-button @click="doRemoveCart(scope.row)" type="warning" size="mini">移除购物车</el-button>
                <el-button @click="doOrder(scope.row)" type="danger" size="mini">提交订单</el-button>
                <%--<el-button @click="doDel(scope.row)"  size="mini">删除</el-button>--%>
            </template>
        </el-table-column>

    </el-table>
    <div style="position:fixed;bottom:10px;width:100%;background-color: #545c64" >
            <el-badge :value="12" style="float:right;margin-right: 50px">
                <el-button @click="doOrderList" type="danger">提交订单</el-button>
            </el-badge>
            <el-badge :value="3" style="float:right;margin-right: 30px">
                <el-button @click="doButtomRemoveCart" type="warning" select="row">移除购物车</el-button>
            </el-badge>
    </div>
    <div>
        <span>选择的值为: {{this.multipleSelection}}</span>
    </div>
</div>

<script>
    var context = "<%=request.getContextPath()%>";
    new Vue({
        el:"#list_zone",
        data:{
            activeIndex: '1',
            activeIndex2: '1',
            tableData:[],
            multipleSelection:[],
        },
        //删除申请信息
        methods:{
            changeFun (val) {
                this.multipleSelection = val // 返回的是选中的列的数组集合
                console.log(this.multipleSelection)
            },
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            doShowGame:function(){
                window.location ="/toPage?page=/jsp/goodsList";
            },
            doLogin:function(){
                window.location ="toLogin";
            },
            doOrderList:function (row){
                $.ajax({
                    url:"/submitOrderRedis",
                    data: JSON.stringify(this.multipleSelection),
                    type: "post",
                    dataType: "json",
                    contentType : "application/json;charset=utf-8",
                    success:function () {
                        window.location ="/toPage?page=/jsp/myCart";
                        alert("下单成功");
                    },
                    error:function () {
                        alert("系统错误");
                    }
                })

            },
            doOrder:function(row){
                $.ajax({
                    url:"/submitOrder",
                    data:{
                        gId:row.gId,
                    },
                    type:"post",
                    dataType:"json",
                    success:function () {
                        window.location ="/toPage?page=/jsp/goodsList";
                        alert("下单成功");
                    },
                    error:function () {
                        alert("系统错误");
                    }
                })
            },
            doAddCart:function (row){
                $.ajax({
                    url:"/addCart",
                    data:{
                        gId:row.gId,
                        // gName:row.gName,
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        alert("添加成功");
                        console.log(res.cart)
                    },
                    error:function () {
                        alert("添加失败");
                    }
                })


            },

            doRemoveCart:function(row){
                $.ajax({
                    url:"/removeRedis",
                    data:{
                        gId:row.gId,
                    },
                    type:"post",
                    dataType:"json",
                    success:function () {
                        window.location ="/toPage?page=/jsp/myCart";
                        // location.reload(); 莫名其妙有时会报错
                        alert("移除成功");
                    },
                    error:function () {
                        alert("移除失败");
                    }
                })
            },
            doButtomRemoveCart:function (row) {
                $.ajax({
                    url:"/buttomRemoveRedis",
                    data: JSON.stringify(this.multipleSelection),
                    type: "post",
                    dataType: "json",
                    contentType : "application/json;charset=utf-8",
                    success: function (res) {
                        window.location ="/toPage?page=/jsp/myCart";
                        alert("移除成功");
                        console.log(res.data);
                    },
                    error: function () {
                        alert("移除失败");
                    }
                })
            }
        },
        //显示游戏列表
        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"/showRedis",
                data:{},
                type:"post",
                dataType:"json",
                success:function (res) {
                    this_.tableData = res.data;
                    console.log(res.data.gSize);
                },
                error:function () {
                    alert("goodsList 错误 ");
                }
            })
        }
    })
</script>
</body>
</html>
