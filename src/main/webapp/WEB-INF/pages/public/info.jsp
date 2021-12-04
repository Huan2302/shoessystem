<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--===== header =====-->

<jsp:include page="./_header.jsp"></jsp:include>

<!--===== page-title =====-->

<section class="page-title bg-overlay-black parallax page-title-bg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1>Thay đổi mật khẩu</h1>
            </div>
        </div>
    </div>
</section>

<!--===== End page-title =====-->

<!--===== End header =====-->
<section class="page-section-ptb">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="main-block">
                    <c:if test="${not empty msg}">
                        <div>
                            <p class="text-success">
                                <span class="text">${msg}</span>
                            </p>
                        </div>
                    </c:if>
                    <c:if test="${not empty err}">
                        <div>
                            <p class="text-danger">
                                <span class="text">${err}</span>
                            </p>
                        </div>
                    </c:if>
                    <div class="login-form">
                        <form action="${pageContext.request.contextPath}/thong-tin" method="post">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <input type="password" name="oldpass" class="form-control" placeholder="Mật khẩu củ">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <input type="password" name="password" class="form-control" placeholder="Mật khẩu mới">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <input type="password" name="repassword" class="form-control" placeholder="Nhập lại mật khẩu mới">
                                    </div>
                                </div>
                            </div>
                            <button class="btn theme-button animated slideInRight" href="javascript:void(0)">Register </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--=====End Add Banner Section =====-->

<!--===== Footer =====-->
<jsp:include page="./_footer.jsp"></jsp:include>
<!--=====End Footer =====-->
