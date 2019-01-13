<%--
  Created by IntelliJ IDEA.
  User: xiaotian
  Date: 2019/1/12
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
商品：<br>
<table border="1">
    <tr>
        <th>名称</th>
        <th>图片</th>
        <th>价格</th>
        <th>描述</th>
        <th>日期</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${itemsList}" var="items">
        <tr>
            <td>${items.name}</td>
            <td><img src="${items.pic}" width="50px" height="50px"> </td>
            <td>${items.price}</td>
            <td>${items.detail}</td>
            <td>${items.createtime}</td>
            <td>
                <a href="${pageContext.request.contextPath}/items/edit.do?id=${items.id}"><button>修改</button></a>
                &nbsp;<a href="${pageContext.request.contextPath}/items/delete.do?id=${items.id}"><button>删除</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
