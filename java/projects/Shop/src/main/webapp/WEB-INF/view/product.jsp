<%--
  Created by IntelliJ IDEA.
  User: zhoushun
  Date: 2018/6/8
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<%--<c:if test="${!empty products}">--%>
<table border = 1px align = "center">
    <tr>
        <th>产品id</th>
        <th>产品名称</th>
        <th>产品数量</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
        <th>${product.id}</th>
        <th>${product.name}</th>
        <th>${product.number}</th>
            <%--<br>--%>
        <!-- 此处设置了一个修改<a>标签,做修改操作.并将上面拿到的数据传给update.jsp,当进入修改页面的时候,原来的数据会显示 -->
        <th><a href="update.jsp?id=${product.getId()}&name=${product.getName()}&
                &number=${product.getNumber()}">修改</a>
            <!-- 删除操作,只把name字段传给Delete_Servlet.java,用来做删除操作 -->
            <a href="Delete_Servlet?id=${product.id}" onclick="confirm('确定删除该条记录?')">删除</a>
        </th>
        </tr>
    </c:forEach>
</table>
<%--</c:if>--%>
</body>
</html>
