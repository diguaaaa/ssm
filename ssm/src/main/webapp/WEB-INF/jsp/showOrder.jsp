
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下单成功</title>
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
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b"
                text-color="#e6a23c">
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
                prop="choiceId"
                value="订单编号"
        <%--width="300px"--%>
                align="center"
                label="订单编号">
        </el-table-column>
        <el-table-column
                prop="sizeTotal"
                value="游戏总大小"
        <%--width="200px"--%>
                align="center"
                label="游戏总大小 /G">
        </el-table-column>
        <el-table-column
                style="margin-right: 30px;float:right"
                width="300px"
                label="操作"
                align="center">
            <template slot-scope="scope">
                <el-button @click="doCopyOrder(scope.row)"  size="mini">复制订单编号</el-button>
                <el-button @click="doShowGameList(scope.row)"  size="mini">查看购买游戏目录</el-button>
            </template>
        </el-table-column>
    </el-table>

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
        methods: {
            doShowGameList: function () {
                window.location = "/toPage?page=/jsp/myCart";
            },
            doCopyOrder: function (row) {
                $.ajax({
                    url: "/addCartRedis",
                    data: {
                        gId: row.gId,
                        gName: row.gName,
                        gSize: row.gSize,
                        // sizeTotal:row.sizeTotal,
                    },
                    type: "post",
                    dataType: "json",
                    success: function (res) {
                        alert("添加成功");
                        console.log(res.data);
                        console.log(res.data.count);
                    },
                    error: function () {
                        alert("添加失败");
                    }
                })
            }
        },
            //显示游戏列表
            mounted: function () {
                const this_ = this;
                $.ajax({
                    url: "/showOrderList",
                    data: {},
                    type: "post",
                    dataType: "json",
                    success: function (res) {
                        this_.tableData = res.data;
                        console.log(res.data);
                        console.log(res.data.sizeTotal);
                        console.log(res.data.count);

                    },
                    error: function () {
                        alert("goodsList 错误 ");
                    }
                })
            }
        })
</script>
</body>
</html>
