<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/23/21
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>E-shoppers - Responsive Multi-purpose HTML5 Template</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/teamplate/public/images/favicon.ico">

    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Plugins -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/teamplate/public/css/plugins-css.css">

    <!-- Typography -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/teamplate/public/css/typography.css">

    <!-- Style -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/teamplate/public/css/style.css">

    <!-- Responsive -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/teamplate/public/css/responsive.css">
</head>

<body>

<!--===== header start =====-->

<div class="wrapper">

    <!--===== header =====-->

<header id="header" class="header default fullWidth">
    <!--===== mega menu =====-->
    <div class="menu">
        <!-- menu start -->
        <nav id="menu" class="mega-menu">
            <!-- menu list items container -->
            <section class="menu-list-items">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12">
                            <!-- menu logo -->
                            <ul class="menu-logo">
                                <li> <a href="index.jsp"><img id="logo_img" src="<%=request.getContextPath()%>/teamplate/public/images/logo.png" alt="logo"> </a> </li>
                            </ul>
                            <!-- menu links -->
                            <div class="menu-bar">
                                <ul class="menu-links">
                                    <li><a href="${pageContext.request.contextPath}/trang-chu" data-hover="TRANG&nbsp;CHỦ">TRANG&nbsp;CHỦ<i class="fa fa-angle-down d-sm-none set-icon"></i></a> </li>
                                    <li><a href="javascript:void(0)" data-hover="Danh&nbsp;mục">Danh&nbsp;mục<i class="fa fa-angle-down d-lg-none set-icon"></i></a>
                                        <!-- drop down multilevel  -->
                                        <ul class="drop-down-multilevel">
                                            <c:forEach items="${listCategory}" var="category">
                                                <li><a href="${pageContext.request.contextPath}/danh-muc/${category.id}">${category.name}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </li>

                                    <li><a href="javascript:void(0)" data-hover="Thương&nbsp;hiệu">Thương&nbsp;hiệu<i class="fa fa-angle-down d-lg-none set-icon"></i></a>
                                        <!-- drop down multilevel  -->
                                        <ul class="drop-down-multilevel">
                                            <c:forEach items="${listBrand}" var="brand">
                                                <li><a href="${pageContext.request.contextPath}/thuong-hieu/${brand.id}">${brand.name}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li><a class="cart-border" href="contact.html" data-hover="Liên&nbsp;hệ">Liên&nbsp;hệ</a></li>
                                </ul>

                                <!-- Shopping cart -->
                                <div class="search-cart">
                                    <div class="search"> <a class="search-btn" href="#search"></a> </div>
                                    <div class="shpping-cart"> <a class="cart-btn txt-white" href="cart.html"> <i class="fa fa-shopping-cart icon"></i> <strong class="item">2</strong></a>
                                        <div class="cart">
                                            <c:choose>
                                                <c:when test="${not empty listCart}">
                                                    <c:forEach items="${listCart}" var="cart">
                                                        <div class="cart-item">
                                                            <div class="cart-image"> <img class="img-fluid" src="${pageContext.request.contextPath}/img/${cart.product.imgs[0].name}" alt=""> </div>
                                                            <div class="cart-name clearfix"> <a href="product-detail-fullwidth.html">${cart.product.name} </a>
                                                                <div class="cart-name"></div>
                                                                <div class="cart-name"><small>x ${cart.quantity}</small></div>
                                                                <div class="cart-price"> <ins>${cart.unitPrice} đ </ins> </div>
                                                            </div>
                                                            <div class="cart-close"> <a href="javascript:void(0)"> <i class="fa fa-times-circle"></i> </a> </div>
                                                        </div>
                                                    </c:forEach>

                                                    <div class="cart-total">
                                                        <h6 class="mb-15"> Subtotal: $104.00</h6>
                                                        <div class="d-flex justify-content-center mb-10"> <a class="btn theme-button" href="cart.html">View Your Cart</a> </div>
                                                        <div class="d-flex justify-content-center"> <a class="btn black-button" href="checkout.html">Proceed Checkout</a> </div>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="cart-total">
                                                        <h6 class="mb-15"> Không có đơn hàng</h6>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>
                                    <div id="search">
                                        <button type="button" class="close">×</button>
                                        <form>
                                            <input type="search" placeholder="Search for products">
                                            <button type="submit" class="btn btn-primary"><span class="ti-search"></span></button>
                                        </form>
                                    </div>
                                    <div class="more"> <a class="more-btn txt-white" href="javascript:void(0)"> <i class="fas fa-align-left"></i></a>
                                        <div class="sub-more">
                                            <ul class="my-account">
                                                <c:choose>
                                                    <c:when test="${user == null}">
                                                        <li><a href="${pageContext.request.contextPath}/dang-nhap">Đăng&nbsp;nhập</a></li>
                                                        <li><a href="${pageContext.request.contextPath}/dang-ky">Đăng&nbsp;ký</a></li>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <li><a href="${pageContext.request.contextPath}/dang-xuat">Đăng&nbsp;xuất</a></li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </nav>
        <!-- menu end -->
    </div>
</header>
