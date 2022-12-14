<%--
  Created by IntelliJ IDEA.
  User: ben10
  Date: 12/14/2022
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>

<c:forEach var="order" items="${orders}">
    <div class="order-card">
        <b>Order number:</b> ${order.orderNumber}&nbsp;
        <b>Order date:</b> ${order.orderDate}&nbsp;
        <b>Required date:</b> ${order.requiredDate}&nbsp;
        <b>Shipped date:</b> ${order.shippedDate}&nbsp;
        <b>Status:</b> ${order.status}<br>
        <c:if test="${order.comments != null}">
            <b>Comment:</b> ${order.comments}<br><br>
        </c:if>
        <hr>
        <table class="table">
            <thead>
            <tr>
                <th>No.</th>
                <th>Product code</th>
                <th>Quantity</th>
                <th>Price each</th>
                <th>Order line number</th>
            </tr>
            </thead>

            <c:forEach var="orderDetail" items="${order.orderDetails}" varStatus="vs">
                <tr>
                    <td>${vs.index + 1}</td>
                    <td>${orderDetail.productCode}</td>
                    <td>${orderDetail.quantityOrdered}</td>
                    <td>${orderDetail.priceEach}</td>
                    <td>${orderDetail.orderLineNumber}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <br></div>
</c:forEach>

</body>
