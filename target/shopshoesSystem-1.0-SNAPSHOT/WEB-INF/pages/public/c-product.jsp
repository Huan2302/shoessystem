<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <!--===== header =====-->

  <jsp:include page="./_header.jsp"></jsp:include>

  <!--===== End header =====-->
  
  <!--===== page-title =====-->
  
  <section class="page-title bg-overlay-black parallax page-title-bg">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <h1>${name}</h1>

        </div>
      </div>
    </div>
  </section>
  
  <!--===== End page-title =====--> 
  
  <!--=====Product List Section =====-->
  <section class="page-section-pt">
    <div class="container">
      <div class="row"> 
        <!--Product Right-->
        <div class="col-lg-12 col-md-12"> 
          <!-- Start Product List top-->
          <div class="product-widget mb-3">
            <div class="row ">
              <div class="col-lg-3 col-7">
                <select name="selectvalue" class="custom-select">
                  <option selected="">Popularity</option>
                  <option value="new">New</option>
                  <option value="low">Price Low - High</option>
                  <option value="high">Price High - Low</option>
                </select>
              </div>
            </div>
          </div>
          <!-- End Product List top--> 
          
          <!-- Start Product List-->
          <c:if test="${not empty listById}">
            <c:forEach items="${listById}" var="item">
              <div class="row">
                <div class="col-lg-3 col-md-4">
                  <div class="productblock product-list-wrap product-list">
                    <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="${pageContext.request.contextPath}/img/${item.imgs[0].name}" alt=""> </a>

                    </div>
                  </div>
                </div>
                <div class="col-lg-9 col-md-8">
                  <div class="product-list-view xs-mb-20">
                    <h5><a href="javascript:void(0)">${item.category.name}</a></h5>
                    <h4><a href="${pageContext.request.contextPath}/san-pham/${item.id}">${item.name}</a></h4>
<%--                    <div class="product-rating"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i> <i class="far fa-star"></i></div>--%>
                    <div class="product-price"> <ins>${item.price} đ</ins> </div>
                    <p class="d-md-none d-lg-block">${item.description}</p>
                    <a class="btn theme-button animated slideInRight" href="${pageContext.request.contextPath}/add-cart?id=${item.id}&quantity=1"><i class="fas fa-shopping-cart"></i> Thêm vào giỏ hàng </a> </div>
                </div>
              </div>
            </c:forEach>
          </c:if>



          <!-- Start Pagination-->
          <div class="product-widget">
            <ul class="pagination justify-content-center">
              <li class="page-item"><a class="page-link" href="javascript:void(0)"><span class="ti-angle-double-left"></span></a></li>
              <li class="page-item active"><a class="page-link" href="javascript:void(0)">1</a></li>
              <li class="page-item"><a class="page-link" href="javascript:void(0)">2</a></li>
              <li class="page-item"><a class="page-link" href="javascript:void(0)">3</a></li>
              <li class="page-item"><a class="page-link" href="javascript:void(0)"><span class="ti-angle-double-right"></span></a></li>
            </ul>
          </div>
          <!-- End Pagination--> 
        </div>
        <!-- End Product List--> 
      </div>
      <!--Product Right--> 
    </div>
  </section>
  <!--=====End Product List Section =====--> 
  
  <!--===== Add Banner Section =====-->
  <section class="page-section-ptb">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 banner-img xs-mb-15 sm-mb-30"><a href="javascript:void(0)"><img class="img-fluid w-100" src="<%=request.getContextPath()%>/teamplate/public/images/banner/add_banner03.jpg" alt=""></a> </div>
      </div>
    </div>
  </section>
  <!--=====End Add Banner Section =====-->
<script type="text/javascript">
  function addCart(id){
    var quantity = 1;
    $.ajax({
      url: '${pageContext.request.contextPath}/add-cart',
      type: 'POST',
      cache: false,
      data:{
        id:id,
        quantity:quantity,
      },
      success: function (data){
        alert("Thêm thành công");
      },
      error:function (){
        alert("lỗi");
      }
    });
    return false;
  }
</script>
  <!--===== Footer =====-->
  <jsp:include page="./_footer.jsp"></jsp:include>
  <!--=====End Footer =====--> 
