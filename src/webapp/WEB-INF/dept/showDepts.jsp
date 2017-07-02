<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sdongwan.staffsystem.service.PostService" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
    String contextPath = request.getServletContext().getContextPath();

//    PostDao postDao=new PostDaoImpl();


%>

<%!
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    PostService postService = (PostService) applicationContext.getBean("postService");
%>
<%!
    private boolean isCanDelete(int postId) {

        System.out.println("postId " + postId);
        if (postService.isDel(postId)) {
            return true;
        }
        return false;
    }
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>部门管理</title>
    <style type="text/css">
        /*.table td {*/
        /*!*border: solid 1px black;*!*/
        /*text-align: center;*/
        /*}*/

        /*.table {*/
        /*width: 50%;*/
        /*height: 50%;*/
        /*}*/

        a:hover {
            color: red;
        }

        a {
            text-decoration: none;
            color: cornflowerblue;
        }

        .position {
            float: left;
            position: absolute;
            margin-top: 35px;
            margin-left: 35px;
        }

        /*.table {*/
        /*position: absolute;*/
        /*margin-top: 10%;*/
        /*margin-left: 15%;*/
        /*}*/

        .right_post {
            float: right;
            /*position: absolute;*/
            margin-top: 35px;
            margin-right: 35px;
        }

        .error {
            margin-left: 150px;
            margin-top: 100px;
            position: absolute;
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

<div class="position"><span>当前位置：部门管理</span></div>
<div class="right_post">
    <a href="/dept/toAddPost">添加部门</a>
</div>

<div class="error">
    <form:errors/>
</div>

<table class="table">
    <tr>
        <td>部门编号</td>
        <td>部门名称</td>
        <td>部门人数</td>
        <td>部门介绍</td>
        <td>操作</td>
    </tr>


    <c:forEach items="${posts}" var="post">
        <tr>
            <td>${post.postId} </td>
            <td>${post.postName}</td>
            <td>${post.postNum}</td>
            <td>${post.postRemark}</td>
            <td>

                <a href="<%=contextPath%>/dept/toUpdatePost?postId=${post.postId}">修改</a>
                <a href="<%=contextPath%>/dept/delPost?postId=${post.postId}"
                   onclick="return confirm('确定删除这个部门吗？')">删除</a>
            </td>
        </tr>

    </c:forEach>

</table>


</body>
</html>
