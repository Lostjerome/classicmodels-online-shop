<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<style>
    .div-link {
        cursor: pointer;
        border: 1px burlywood solid;
    }

    .div-link:hover {
        background-color: bisque;
    }

    .cart-info {
        margin-left: -1em;
        border-radius: 12px;
        background-color: bisque;
        position: absolute;
        z-index: 100;
        border: none;
        padding-left: 5px;
        padding-right: 5px;
        display: none;
    }

    .order-card {
        border: 1px deepskyblue solid;
        border-radius: 12px;
        padding: 10px;
        margin-bottom: 10px;
    }
</style>
<script>
    function loadOffice(officeCode) {
        setLoading("on");
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            setLoading("off");
            document.getElementById("body-content").innerHTML = xhttp.responseText;
        }
        xhttp.open("GET", "office-list?officeCode=" + officeCode);
        xhttp.send();
    }

    function loadProduct(page, pageSize = document.getElementById("itemsPage").value) {
//alert('page: '+ page +", size: "+ pageSize)
        setLoading("on");
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            setLoading("off");
            document.getElementById("body-content").innerHTML = xhttp.responseText;
        }
        xhttp.open("GET", "product-list?page=" + page + "&pageSize=" + pageSize);
        xhttp.send();
    }

    function loadOrderHistory(){
        setLoading("on");
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            setLoading("off");
            document.getElementById("body-content").innerHTML = xhttp.responseText;
        }
        xhttp.open("GET", "order-history");
        xhttp.send();
    }

    function addToCart(productCode) {
        setLoading('on')
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            setLoading('off')
            cartInfo = document.getElementById("noOfItemInCart");
            noOfItem = xhttp.responseText;

            if (noOfItem > 0) {
                cartInfo.style.display = 'inline';
            } else {
                cartInfo.style.display = 'none'
            }
            cartInfo.innerHTML = noOfItem;
        }
        xhttp.open("GET", "add-to-cart?productCode=" + productCode);
        xhttp.send();
    }

    function viewCart() {
        setLoading('on')
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            setLoading('off');
            document.getElementById("view-cart").innerHTML = xhttp.responseText;
            $('#viewCartModal').modal('show');
        }
        xhttp.open("GET", "ViewCart.jsp");
        xhttp.send();
    }


    function setLoading(on_off) {
        let loading = document.getElementById("loading");
        if (on_off == 'on') {
            loading.classList.remove("d-none");
            loading.classList.add("d-inline");
        } else {
            loading.classList.remove("d-inline");
            loading.classList.add("d-none");
        }
    }

    function showLoginForm() {
        let menu = document.getElementById("login-menu").innerHTML;
        if (menu.includes('Logout')) {
            logout();
        } else {
            $('#modalLoginForm').modal('show');
        }
    }

    function logout() {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            location.reload();

        }
        xhttp.open("GET", "logout");
        xhttp.send();
    }

    function login(userName, password) {
        if (userName == '' || password == '' || userName == undefined) {
            document.getElementById("login-message").innerHTML = "Invalid user name or password !!!";
        }
        setLoading('on')
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            setLoading('off');
            if (xhttp.status == 200) {
                $('#modalLoginForm').modal('hide');
                document.getElementById("login-menu").innerHTML = "<i class='bi bi-box-arrow-left'></i> Logout"
            } else if (xhttp.status > 400) {
                document.getElementById("login-message").innerHTML = xhttp.statusText;
            } else {
                document.getElementById("login-message").innerHTML = "Wrong user name or password !!!";
            }
        }
        let urlEncodedData = "", urlEncodedDataPairs = [];
        urlEncodedDataPairs.push(encodeURIComponent("userName") + '=' + encodeURIComponent(userName));
        urlEncodedDataPairs.push(encodeURIComponent("password") + '=' + encodeURIComponent(password));
        urlEncodedData = urlEncodedDataPairs.join('&').replace(/%20/g, '+');
        xhttp.open("POST", "login");
        xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhttp.send(urlEncodedData);
    }

    // after reload page
    $(document).ready(function () {
        addToCart()
    });


</script>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand text-warning" href="javascript:void(0)">Classic Model</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="javascript:loadOffice('')">Office</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:loadProduct(1,15)">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:loadOrderHistory()">Order History</a>
                </li>
                <li class="nav-item ml-4">
                    <a id="login-menu" class="nav-link text-light"
                       href="javascript:showLoginForm()"><i
                            class="bi bi-box-arrow-in-right"></i> Login</a>
                </li>
            </ul>
            <div style="margin-right: 20px">
                <img src="assets/images/cart.png" width="42" onclick="viewCart()"/>
                <button id="noOfItemInCart" class="cart-info" onclick="viewCart()"></button>
            </div>
            <form class="d-flex">
                <input id="searchBox" class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-primary" type="button" onclick="search(thisContent)">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="modal" tabindex="-1" id="viewCartModal">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header"><h5 class="modal-title">Your Cart</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                        onclick="$('#viewCartModal').modal('hide')"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body" id="view-cart"><p>Modal body text goes here.</p></div>
        </div>
    </div>
</div>

<div class="container" id="body-content">
    <jsp:include page="assets/home-info.html"/>
</div>
<div class="d-flex justify-content-center modal d-none" id="loading">
    <div class="spinner-border text-primary" style="margin-top: 10%; width: 6rem; height: 6rem;"></div>
</div>
<jsp:include page="login-form.html"/>

</body>
</html>