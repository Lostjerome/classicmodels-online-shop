<%--
  Created by IntelliJ IDEA.
  User: ben10
  Date: 12/16/2022
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html>
<head>
    <title>OrderList</title>
</head>
<body>
Customer List by 64130500017 Naronkrach Tanajarusawas
<br>
<br>
customerNumber: ${customer.customerNumber}, customerName: ${customer.customerName}, city: ${customer.city},
country: ${customer.country}
<hr>
<c:forEach items="${orders}" var="order" varStatus="vs">
017-${vs.count}
orderNumber: <a href="./order-detail-list?orderId=${order.orderNumber}">${order.orderNumber}<a>
    , orderDate: ${order.orderDate},
    shippedDate: ${order.shippedDate}, status: ${order.status}
    <br>
    </c:forEach>
</body>
</html>
