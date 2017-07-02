<%@ page import="java.util.List" %>
<%@ page import="com.sdongwan.staffsystem.entity.Post" %>
<%@ page import="com.sdongwan.staffsystem.util.MethodUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>

<%
    String pathParam = request.getSession().getServletContext().getRealPath("");
    List<Post> postLt = MethodUtil.getPosts();
    request.setAttribute("postLt", postLt);
    String contextPath = request.getServletContext().getContextPath();
%>
<html>
<head>
    <base href=<%=basePath%>>
    <title>修改员工信息</title>
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
            width: 65%;
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

<div class="position"><span>当前位置：修改员工信息</span></div>


<form:form action="/user/upUser" method="post" enctype="multipart/form-data" commandName="user">
    <table>

        <tr>
            <td>
                员工用户名
            </td>

            <td>
                <input type="hidden" name="userId" value="${user.userId}">
                <input type="text" name="username" value="${user.username}">
            </td>

            <td>
                6-10位英文字母或数字
            </td>

        </tr>

        <tr>
            <td>
                员工密码
            </td>

            <td>
                <input type="text" name="userPass" value="${user.userPass}">
            </td>

            <td>
                6-10位英文字母或数字
            </td>

        </tr>

        <tr>

            <td>
                <span>员工姓名</span>
            </td>

            <td>
                <input type="text" name="name" value="${user.name}">
            </td>

            <td>
                <span>
                    10位以内中文
                </span>
            </td>

        </tr>


        <tr>

            <td>
                员工性别
            </td>

            <td>
                <input type="radio" name="sex" value="男" checked="checked">
                <input type="radio" name="sex" value="女">
            </td>

            <td>
                选择用户性别
            </td>

        </tr>

        <tr>
            <td>
                出生日期
            </td>
            <td>
                <input type="text" name="birthday" value="${user.birthday}">
            </td>
            <td>
                格式YYYY-MM-DD
            </td>

        </tr>

        <tr>
            <td>
                入职日期
            </td>

            <td>
                <input type="text" name="entryDate" value="${user.entryDate}">
            </td>

            <td>
                格式YYYY-MM-DD
            </td>

        </tr>
        <tr>

            <td>
                所属部门
            </td>

            <td>
                <select name="postId">
                    <option value="0">选择部门</option>
                    <c:forEach items="${postLt}" var="post">
                        <option value="${post.postId}">
                                ${post.postName}
                        </option>
                    </c:forEach>
                </select>
            </td>

            <td>
                选择所属部门
            </td>

        </tr>

        <tr>

            <td>
                员工图片
            </td>
            <td colspan="2">
                <input type="file" name="file">
            </td>

        </tr>
        <tr>
            <td>
                个人简介
            </td>
            <td colspan="2">
               <textarea name="remark" cols="40" rows="5">
                   ${user.remark}
               </textarea>
            </td>
        </tr>

        <tr>

            <td colspan="3">
                <input type="submit" value="确定">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置">
            </td>

        </tr>

    </table>
</form:form>


</body>
</html>
