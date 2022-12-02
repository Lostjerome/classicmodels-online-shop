<%--
  Created by IntelliJ IDEA.
  User: ben10
  Date: 11/20/2022
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>ProductList</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="container ml-2 p-2">--%>
<div class="row pt-4 align-items-center">
    <c:forEach items="${products}" var="p" varStatus="vs">
        <div class="col-2 my-1 mx-3">
            <div class="img-fluid img-thumbnail" title="${p.id}">
                <img src="model-images/${p.productLine}/${p.id}.jpg" height="120" width="180"/>
            </div>
            <div>${p.productName} <span style="text-align: right">${p.msrp}</span>
                <span style="color: darkred;margin-left: 2px;cursor: pointer">
                    <i class="bi bi-bag-plus" onclick="addToCart('${p.id}')"></i></span>
            </div>
        </div>
    </c:forEach>
</div>
<hr>
<div class="d-flex flex-row">
    <c:set var="totalPage" value="${itemCount / pageSize * (itemCount%pageSize==0 ? 0 : 1)}"/>
    <div class="px-1">page:</div>
    <div class="px-1 mx-1 div-link"
         onclick="loadProduct(page=${page<=1?totalPage:page-1}, ${pageSize})"> &lt;
    </div>
    <c:set var="totalPage" value="${itemCount/pageSize}"/>
    <c:forEach begin="1" end="${totalPage}" varStatus="vs">
        <c:choose>
            <c:when test="${vs.count==page}">
                <div class="px-1 mx-1 div-link text-light bg-dark"> ${vs.count} </div>
            </c:when>
            <c:otherwise>
                <%--                <a href="product-list?page=${vs.count}&pageSize=${pageSize}">--%>
                <div class="px-1 mx-1 div-link"
                     onclick="loadProduct(page=${vs.count}, ${pageSize})"
                >
                        ${vs.count}
                </div>
                <%--                </a>--%>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <div class="px-1 mx-2 div-link"
         onclick="loadProduct(page=${page>=totalPage? 1 : page+1}, ${pageSize})"> &gt;
    </div>
    <div class="px-4 mx-1">
        items per page:
        <select id="itemsPage" onchange="loadProduct(1)">
            <option value="5" ${pageSize==5?'selected':''}>5</option>
            <option value="10" ${pageSize==10?'selected':''}>10</option>
            <option value="15" ${pageSize==15?'selected':''}>15</option>
            <option value="20" ${pageSize==20?'selected':''}>20</option>
            <option value="50" ${pageSize==50?'selected':''}>50</option>
        </select>
    </div>
</div>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>
