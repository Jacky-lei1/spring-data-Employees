<%--
  Created by IntelliJ IDEA.
  User: leiji
  Date: 2019/11/18
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath %>"/>
    <title>招聘系统</title>
    <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript">
        function del() {
            return  window.confirm("您确定要删除该条信息吗？")
        }
    </script>
</head>
<body style="text-align: center">
<div>
    <h1>招聘系统企业版</h1>
</div><br/>
<hr/>
<div style="position: absolute;right: 100px">
    <form action="http://localhost:8080/findByKeyWorlds" method="post">
        按职位：<input type="text" name="keyWorlds"/><input type="submit" value="查询"/>
    </form>
</div><br/>
<hr/>
<div style="position: absolute;right: 100px">
    <a href="form" >发布新的招聘信息</a>
</div><br/>
<center>
<div>
    <table style="border: 2px solid;text-align: center;position:center;left: 380px">
        <tr>
            <th>职位名称</th>
            <th>公司名称</th>
            <th>职位月薪</th>
            <th>工作地点</th>
            <th>发布日期</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${positions}" var="position">
            <tr>
                <td>${position.pname}</td>
                <td>${position.company.cname}</td>
                <td>${position.minsal}-${position.maxsal}</td>
                <td>${position.company.location}</td>
                    <%--        日期格式转换<fmt:formatDate/>--%>
                <td><fmt:formatDate value="${position.releasedate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td><a href="http://localhost:8080/delete?pid=${position.pid}" onclick="return del()">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div><br/>
<div>
    <form action="findByPaging" method="post">
        <p>显示第
            <input type="text" name="page" style="width: 20px" value="${page}">
            页
            每页显示
            <input type="text" name="num" style="width: 20px" value="${num}">
            条
            <input type="submit" value="确定"></p>
    </form>
</div>
</center>
</body>
</html>
