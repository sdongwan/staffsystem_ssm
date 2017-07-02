<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/12
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%
    String contextPath = request.getServletContext().getContextPath();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>修改口令</title>
    <style type="text/css">

        .position {
            float: left;
            margin-top: 35px;
            margin-left: 35px;
        }

        table {
            position: absolute;
            border: 1px solid #888888;
            border-collapse: collapse;
            font-family: Arial, Helvetica, sans-serif;
            width: 45%;
            margin-left: 150px;
            margin-top: 150px;

        }

        table td {
            text-align: center;
            background-color: #EFEFEF;
            border: 1px solid #AAAAAA;
            padding: 5px 15px 5px 5px;
        }


    </style>
</head>
<body>
<div class="position"><span>当前位置：修改口令</span></div>

<form:form method="post" target="_top" action="/admin/updateAdmin" commandName="admin">

    <table class="table">
        <tr>
            <td>
                <label for="adminName">管理员名字</label>
            </td>

            <td>
                <input type="hidden" name="adminId" id="adminId" value="${admin.adminId}">
                <input type="hidden" name="loginCount" value="${admin.loginCount}">

                <input type="text" name="adminName" id="adminName" value="${admin.adminName}">
            </td>
        </tr>

        <tr>
            <td>
                <label for="adminUserName">管理员用户账号</label>
            </td>

            <td>
                <input type="text" name="adminUserName" value="${admin.adminUserName}" id="adminUserName">
            </td>
        </tr>

        <tr>
            <td>
                <label for="adminPwd">管理员用户密码</label>
            </td>
            <td>
                <input type="text" name="adminPwd" id="adminPwd" value="${admin.adminPwd}">
            </td>
        </tr>


        <tr>
            <td>
                <input type="reset" value="重置">

            </td>
            <td>
                <input type="submit" value="确定">
            </td>
        </tr>

    </table>

</form:form>


</body>
</html>
