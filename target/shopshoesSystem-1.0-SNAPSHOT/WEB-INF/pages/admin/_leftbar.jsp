<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/19/21
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Shop Giay <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/trang-chu">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Interface
    </div>



    <li id="categoryActive" class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/manager/category">
            <i class="fas fa-fw fa-cog"></i>
            <span>Danh mục</span></a>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
<%--    <li class="nav-item">--%>
<%--        <a class="nav-link collapsed" href="${pageContext.request.contextPath}/manager/product" data-toggle="collapse" data-target="#collapseUtilities"--%>
<%--           aria-expanded="true" aria-controls="collapseUtilities">--%>
<%--            <i class="fas fa-fw fa-wrench"></i>--%>
<%--            <span>Sản phẩm</span>--%>
<%--        </a>--%>
<%--        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"--%>
<%--             data-parent="#accordionSidebar">--%>
<%--            <div class="bg-white py-2 collapse-inner rounded">--%>
<%--                <div class="bg-white py-2 collapse-inner rounded">--%>
<%--                    <a class="collapse-item" href="buttons.html">Giày Sneakers</a>--%>
<%--                    <a class="collapse-item" href="cards.html">Giày boot</a>--%>
<%--                    <a class="collapse-item" href="cards.html">Giày cao gốt</a>--%>
<%--                    <a class="collapse-item" href="cards.html">Giày xăng đan</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </li>--%>
    <li id="productActive" class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/manager/product">
            <i class="fas fa-fw fa-cog"></i>
            <span>Sản phẩm</span></a>
    </li>
    <li id="brandActive" class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/manager/brand">
            <i class="fas fa-fw fa-cog"></i>
            <span>Thương hiệu</span></a>
    </li>

    <!-- tài khoản -->
    <li id="userActive" class="nav-item ">
        <a class="nav-link" href="${pageContext.request.contextPath}/manager/user">
            <i class="fas fa-fw fa-table"></i>
            <span>Tài khoản</span></a>
    </li>


    <!-- bình luân -->
    <li id="oderActive" class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/manager/oder">
            <i class="fas fa-fw fa-table"></i>
            <span>Giỏ hàng</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">


    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>
</ul>
