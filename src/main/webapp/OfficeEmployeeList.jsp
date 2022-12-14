<%--
  Created by IntelliJ IDEA.
  User: ben10
  Date: 11/7/2022
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Classic Model Offices</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<title>Classic Model Offices</title>--%>
<%--<div class="container">--%>
<div class="row bg-primary">
    <h1>Classic Model Offices</h1>
</div>
<div class="row">
    <c:forEach items="${offices}" var="office">
        <div onclick="loadOffice('${office.officeCode}')"
             class="col-2 border border-secondary p-2 m-2 div-link ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
            <div>${office.city}, ${office.country}</div>
            <div>${office.phone}</div>
        </div>
    </c:forEach>
</div>

<br>

<div class="row bg-light">
    <b>Employees ::</b>
</div>
<div class="row">
    <c:forEach items="${selectedOffice.employees}" var="employee">
        <div class="col-2 border border-secondary pl-2 m-2 rounded-pill">
            <div>${employee.firstName} ${employee.lastName} - ${employee.jobTitle}</div>
        </div>
    </c:forEach>
</div>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
