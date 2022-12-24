<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ben10
  Date: 12/16/2022
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrderDetailList</title>
</head>
<body>
017-customerNumber: ${customer.customerNumber}, customerName: ${customer.customerName} -
orderNumber: ${order.orderNumber}, orderDate: ${order.orderDate}, status: ${order.status}
<br>
<br>
<c:forEach items="${order.orderDetails}" var="orderDetail">
    orderLineNumber: ${orderDetail.orderLineNumber},
    productCode: ${orderDetail.productCode},
    quantityOrdered: ${orderDetail.quantityOrdered},
    priceEach: ${orderDetail.priceEach},
    total: ${orderDetail.quantityOrdered * orderDetail.priceEach},
    <br>
</c:forEach>
</body>
</html>
