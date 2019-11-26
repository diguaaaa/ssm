<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/30
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

</head>
<body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.4.0/jquery.js"></script>
<table class="table table-bordered" id='tabletest'>
    <tr>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>操作</th>
    </tr>

    <tbody id="showUserBody"></tbody>
</table>
<%--<script src="${pageContext.request.contextPath}lib/bootstrap/js/bootstrap.js"></script>--%>
<script type="text/javascript">
    $(function () {
        $.ajax({
            type: "POST",
            url: "/showUser",
            dataType: "json",
            data: {},
            success:function (data) {
                //表格内容---------------------------------------------------------------
                $.each(data.data, function (index, item) {
                    var tr;
                    tr = "<td>" + item.userId + "</td>" +
                        "<td>" + item.userName + "</td>" +
                        "<td><button >删除</button></td>";
                    $("#showUserBody").append('<tr>' + tr + '</tr>');
                    // $(function(){
                    //     $(this).click(btn1);
                    // });
                    console.log(data);
                });

            },
            error: function (data) {
                alert(data);
                console.log("服务器错误" + data);
            }
        })
    })
    function btn1(){//移除
        // $('input[name="checkbox"]:checked').each(function(){
        //     $(this).parent().parent().remove();
        //     //移除当前行 checkbox的父级是td，td的父级是tr，然后删除tr。就ok了。用each，选择多行遍历删除
        // });
        console.log("按钮有反应");
    }

</script>

</body>
</html>
