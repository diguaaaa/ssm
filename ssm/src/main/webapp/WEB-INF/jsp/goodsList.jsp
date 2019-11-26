
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <link rel="stylesheet" href="/index.css" >
    <script src="/index.js"></script>
    <style>
        #list_zone{
            width: auto;
            height: auto;
            margin-bottom: 80px ;
        }
    </style>
</head>
<body>
</div>
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
            <%--<el-menu-item @click="doLogin" >管理员登录</el-menu-item>--%>
            <el-menu-item style="float:right">我的</el-menu-item>
            <el-menu-item style="float:right" text-color="danger">订单管理</el-menu-item>
            <el-menu-item @click="doMyCart" style="float:right" >购物车</el-menu-item>
        </el-menu>
    </div>
    <el-table
            :data="tableData"
            ref = "multipleTable "
            @selection-change="changeFun">
        <el-table-column
                type="selection"
                <%--v-model="checkedNames"--%>
                @selection-change="changeFun"
                width="100px">
        </el-table-column>
        <el-table-column
                prop="gName"
                value="游戏名称"
                <%--width="300px"--%>
                align="center"
                label="游戏名称">
        </el-table-column>
        <el-table-column
                prop="gSize"
                value="游戏大小"
                <%--width="200px"--%>
                align="center"
                label="游戏大小 /G">
        </el-table-column>
        <el-table-column
                style="margin-right: 30px;float:right"
                width="300px"
                label="操作"
                align="center">
            <template slot-scope="scope">
                <el-button @click="doAddCart(scope.row)"  size="mini">加入购物车</el-button>
                <el-button @click="doOrder(scope.row)"  size="mini">提交订单</el-button>
            </template>
        </el-table-column>
    </el-table>
    <div>
        <span>选择的值为: {{this.multipleSelection}}</span>
    </div>
    <div style="position:fixed;bottom:10px;width:100%;background-color: #545c64">
            <el-badge style="float:right;margin-right: 50px">
                <el-button @click="doOrderList" type="danger" >提交订单</el-button>
            </el-badge>
            <el-badge :value="3"  style="float:right;margin-right: 30px">
                <el-button @click="doButtomAddCart" type="warning">加入购物车</el-button>
            </el-badge>
            <el-badge style="width: 150px;float:right;margin-right: 50px">
                <el-output text-color="#FFFFFF">总大小:{{ }}</el-output>
            </el-badge>
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
            doMyCart:function(){
                window.location ="/toPage?page=/jsp/myCart";
            },
            doLogin:function(){
                window.location ="toLogin";
            },
            doAddCart:function (row){
                $.ajax({
                    url:"/addCartRedis",
                    data:{
                        gId:row.gId,
                        gName:row.gName,
                        gSize:row.gSize,
                        // sizeTotal:row.sizeTotal,
                    },
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        alert("添加成功");
                        console.log(res.data);
                        console.log(res.data.count);
                    },
                    error:function () {
                        alert("添加失败");
                    }
                })
            },
            doButtomAddCart:function(row){
                // if (multipleSelection != null && multipleSelection.length > 0) {
                    $.ajax({
                        url: "/buttomAddCartRedis",
                        data: JSON.stringify(this.multipleSelection),
                        type: "post",
                        dataType: "json",
                        contentType : "application/json;charset=utf-8",
                        success: function (res) {
                            alert("添加成功");
                            console.log(res.data);
                        },
                        error: function () {
                            alert("添加失败");
                        }
                    })
                // }
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
                        window.location ="/toPage?page=/jsp/showOrder";
                        alert("下单成功");
                    },
                    error:function () {
                        alert("系统错误");
                    }
                })
            },
            doOrderList:function(row){
                $.ajax({
                    url:"/submitOrderRedis",
                    data: JSON.stringify(this.multipleSelection),
                    type: "post",
                    dataType: "json",
                    contentType:"application/json;charset=utf-8",
                    success:function (res) {
                        alert("下单成功");
                        window.location ="/toPage?page=/jsp/showOrder";
                    },
                    error:function () {
                        alert("系统错误");
                    }
                })
            }

        },
        //显示游戏列表
        mounted:function () {
            const this_ = this;
            $.ajax({
                url:"/showGame",
                data:{},
                type:"post",
                dataType:"json",
                success:function (res) {
                    this_.tableData = res.data;
                    console.log(res.data);
                    console.log(res.data.sizeTotal);
                    console.log(res.data.count);
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
