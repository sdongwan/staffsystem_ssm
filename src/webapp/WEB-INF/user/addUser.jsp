<%@ page import="com.sdongwan.staffsystem.entity.Post" %>
<%@ page import="com.sdongwan.staffsystem.util.MethodUtil" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%--注意加上isELIgnored="false"，不然使用el表达式不灵--%>
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
    <base href="<%=basePath%>">
    <title>添加员工信息</title>
    <style type="text/css">

        .position {
            float: left;
            margin-top: 35px;
            margin-left: 35px;
        }

        .container {
            position: absolute;
            margin-left: 150px;
            margin-top: 150px;
            /*width: 100%;*/
            width: 550px;
        }

        table {
            /*position: absolute;*/
            border: 1px solid #888888;
            border-collapse: collapse;
            font-family: Arial, Helvetica, sans-serif;
            float: left;
            /*width: 65%;*/
            /*margin-left: 150px;*/
            /*margin-top: 150px;*/

        }

        table td {
            text-align: center;
            background-color: #EFEFEF;
            border: 1px solid #AAAAAA;
            padding: 5px 15px 5px 5px;
        }

        .error {
            position: relative;
            margin-top: 10px;
            float: left;
        }


    </style>
</head>
<body>


<div class="position"><span>当前位置：添加新员工</span></div>

<div class="container">
    <%--enctype="multipart/form-data"--%>
    <form:form action="/user/addUser" method="post" commandName="user" enctype="multipart/form-data">
        <table class="table">

            <tr>
                <td>
                    <span>员工用户名</span>
                </td>

                <td>
                    <input type="text" name="username"/>
                </td>

                <td>
                <span>
                    6-10为英文字母或数字
                </span>
                </td>
            </tr>

            <tr>
                <td>
                    <span>员工密码</span>
                </td>
                <td>
                    <input type="text" name="userPass"/>

                </td>
                <td>
                <span>
                    6-10为英文字母或数字
                </span>
                </td>
            </tr>

            <tr>
                <td>
                    <span>员工姓名</span>
                </td>

                <td>
                    <input type="text" name="name">
                </td>

                <td>
                <span>
                    10位以内中文
                </span>
                </td>
            </tr>

            <tr>
                <td>
                    <span>员工性别</span>
                </td>

                <td>
                    <input type="radio" value="男" name="sex" checked="checked">男
                    <input type="radio" value="女" name="sex">女
                </td>
                <td>
                <span>
                   选择用户性别
                </span>
                </td>

            </tr>

            <tr>
                <td>
                    <span>出生日期</span>
                </td>

                <td>
                    <input type="text" name="birthday">
                </td>
                <td>
                <span>
                    格式：YYYY-MM-DD
                </span>
                </td>

            </tr>


            <tr>

                <td>
                    <span>入职日期</span>
                </td>

                <td>
                    <input type="text" name="entryDate">
                </td>

                <td>
                <span>
                      格式：YYYY-MM-DD
                </span>
                </td>

            </tr>


            <tr>

                <td>
                    <span>所属部门</span>
                </td>

                <td>
                    <select name="postId">
                        <option value="0">
                            选择部门....
                        </option>

                        <c:forEach items="${postLt}" var="post">
                            <option value="${post.postId}">
                                    ${post.postName}
                            </option>
                        </c:forEach>

                    </select>
                </td>
                <td>
                <span>
                   选择所在部门
                </span>
                </td>
            </tr>


            <tr>
                <td>
                    <span>员工图片</span>
                </td>
                <td colspan="2">
                    <input type="file" name="images[0]">
                </td>
            </tr>


            <tr>
                <td>
                    <span>个人简介</span>
                </td>
                <td colspan="2">
                <textarea name="remark" cols="40" rows="5">

                </textarea>
                </td>
            </tr>


            <tr>
                <td colspan="3">
                    <input type="reset" value="重置">
                    <input type="submit" value="确定">
                </td>

            </tr>

        </table>

    </form:form>

    <div class="error">
        <form:errors/>
    </div>
</div>
</body>
</html>
