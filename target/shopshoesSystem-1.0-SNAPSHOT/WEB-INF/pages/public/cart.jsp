<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <!--===== header =====-->

  <jsp:include page="./_header.jsp"></jsp:include>

<!--===== page-title =====-->

<section class="page-title bg-overlay-black parallax page-title-bg">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h1>Giỏ hàng</h1>

      </div>
    </div>
  </div>
</section>

<!--===== End page-title =====-->

<!--===== End header =====-->
<section class="page-section-ptb">
  <div class="container">
    <div class="main-block bg-light">
      <div class="row">
        <div class="col-lg-12">
          <div class="table-responsive cart-table border-radius bg-white mb-20">
            <table class="table mb-0">
              <thead>
              <c:if test="${not empty msg}">
                <div>
                  <p class="text-success">
                    <span class="text">${msg}</span>
                  </p>
                </div>
              </c:if>
              <c:choose>
                <c:when test="${not empty listCart}">
              <tr>
                <th>Thumbnail</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
                <th>Remove</th>
              </tr>
              </thead>
              <tbody>
                  <c:forEach items="${listCart}" var="cart">
                    <tr>
                      <td class="thumbnail"><img class="img-fluid" src="${pageContext.request.contextPath}/img/${cart.product.imgs[0].name}" alt=""></td>
                      <td>${cart.product.name}</td>
                      <td>${cart.unitPrice} đ</td>
                      <td><div class="box xs-w-150">
                        <p class="quantity text-center ml-150 bg-white">${cart.quantity}</p>
                      </div></td>
                      <td>${cart.total} đ</td>
                      <td class="remove-product"><a href="${pageContext.request.contextPath}/gio-hang/del?id=${cart.id}&oderId=${oder.id}&total=${cart.total}&oderTotal=${oder.total}"><i class="fas fa-trash-alt"></i></a></td>
                    </tr>
                  </c:forEach>
                </c:when>
                <c:otherwise>
              </thead>
              <tbody>
                  <tr><p>Chưa có đơn hàng </p></tr>

                </c:otherwise>
              </c:choose>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    <div class="row mt-30">
      <div class="col-lg-4 col-md-6 offset-lg-4">


      </div>

        <c:if test="${not empty oder}">
          <div class="col-lg-4 col-md-6">
            <div class="main-block">
              <div class="filter-title">
                <h5>Thanh toán</h5>
              </div>
              <table class="table table-borderless mb-0">
                <tr class="border-theme">
                  <td>Grand Total</td>
                  <td class="float-right">${oder.total} đ</td>
                </tr>
                </tbody>
              </table>
              <div class="text-center"> <a class="btn black-button animated slideInRight" href="${pageContext.request.contextPath}/pay?id=${oder.id}">Thanh toán giỏ hàng <i class="fas fa-arrow-alt-circle-right"></i></a> </div>
            </div>
          </div>
        </c:if>

    </div>
  </div>
</section>>
  <!--=====End Add Banner Section =====-->

  <!--===== Footer =====-->
  <jsp:include page="./_footer.jsp"></jsp:include>
  <!--=====End Footer =====--> 
