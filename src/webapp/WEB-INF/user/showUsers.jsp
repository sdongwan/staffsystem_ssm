<%@ page import="com.sdongwan.staffsystem.dao.PostDao" %>
<%@ page import="com.sdongwan.staffsystem.entity.Post" %>
<%@ page import="com.sdongwan.staffsystem.entity.User" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/10
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
    String contextPath = request.getServletContext().getContextPath();
%>

<%
    //    Integer pageCount = (Integer) request.getAttribute("pageCount");
%>

<html>
<head>
    <base href=<%=basePath%>>
    <title>员工列表</title>
    <style type="text/css">
        .table td {
            border: solid 1px black;

            margin-top: 0px;
            margin-bottom: 0px;
            text-align: center;

        }

        table td img.photo {
            width: 80px;
            height: 80px;
            cursor: pointer;
            transition: all 0.6s;
        }

        table td img.photo:hover {
            transform: scale(1.4);
        }

        a:hover {
            color: red;
        }

        a {
            text-decoration: none;
            color: cornflowerblue;
        }

        .position {
            float: left;
            margin-top: 35px;
            margin-left: 35px;
        }

        /*.table {*/
        /*position: absolute;*/
        /*margin-top: 10%;*/
        /*margin-left: 15%;*/
        /*}*/

        .addStaff {
            float: right;
            margin-top: 35px;
            margin-right: 35px;
        }

        table {
            /*position: absolute;*/
            border: 1px solid #888888;
            border-collapse: collapse;
            font-family: Arial, Helvetica, sans-serif;
            width: 100%;
            /*margin-left: 150px;*/
            /*margin-top: 150px;*/

        }

        table td {
            text-align: center;
            background-color: #EFEFEF;
            border: 1px solid #AAAAAA;
            padding: 5px 15px 5px 5px;
        }

        .page {
            width: 65%;
            text-align: center;
            position: relative;
            margin-top: 15px;

        }

        .pagination {
            color: black;
            text-decoration: none;
            border-top: 1px solid #312E3D;
            border-left: 1px solid #312E3D;
            border-right: 1px solid #312E3D;
            border-bottom: 1px solid #56536A;
            padding: 5px 10px;
            background-color: #ff2d17;

            float: right;
            margin-left: 5px;

        }

        .container {
            position: absolute;
            margin-left: 150px;
            margin-top: 150px;
            width: 550px;
        }


    </style>


</head>
<body>


<div class="position"><span>当前界面：用户管理界面</span></div>

<div class="addStaff">
    <a href="<%=contextPath%>/user/toAddUser">
        添加新员工
    </a>
</div>
<div class="container">
    <table>
        <c:forEach items="${users}" var="user">

            <%

                //                注意，使用jstl标签与struts标签不同，jstl标签要用pageContext来获取数据，struts从request中获取数据
                User user = (User) pageContext.getAttribute("user");
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
                PostDao postDao = (PostDao) applicationContext.getBean("postDao");
                Post post = postDao.finnByPostId(user.getPostId());
                request.setAttribute("post", post);
            %>
            <tr>
                <td rowspan="5">

                    <img src="<%=contextPath%>/upload/${user.photo}"
                         class="photo"/>
                </td>

                <td colspan="3">
                    <a href="<%=contextPath%>/user/toUpUser?userId=${user.userId}">修改</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="<%=contextPath%>/user/delUser?userId=${user.userId}"
                       onclick="return confirm('确定要删除吗？')">删除</a>
                </td>
            </tr>

            <tr>
                <td>
                    用户编号： ${user.userId}
                </td>
                <td>
                    登录账号： ${user.username}
                </td>
                <td>
                    登录密码：${user.userPass}
                </td>
            </tr>

            <tr>
                <td>
                    用户姓名：${user.name}
                </td>
                <td>
                    用户性别：${user.sex}
                </td>
                <td>
                    出生日期：${user.birthday}
                </td>
            </tr>

            <tr>
                <td>
                    入职日期： ${user.entryDate}
                </td>
                <td colspan="2">
                    所属部门： ${post.postName}
                </td>
            </tr>
            <tr>

                <td colspan="3">
                    个人介绍：${user.remark}
                </td>
            </tr>

        </c:forEach>

    </table>

    <%--<%--%>
    <%--for (int i = pageCount - 1; i >= 0; i--) {--%>
    <%--%>--%>

    <%--<div class="page">--%>
    <%--<a href="<%=contextPath%>/user/showUsers?pagination=<%=i+1%>" class="pagination"><%=i + 1%>--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--<%--%>
    <%--}--%>
    <%--%>--%>
</div>
</body>
</html>
