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
          <h1>Thông tin sản phẩm</h1>
        </div>
      </div>
    </div>
  </section>
  <!--===== End page-title =====--> 
  <c:if test="${not empty product}">
  <!--=====Product Detail Section =====-->
  <section class="page-section-ptb">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-md-5"> 
          
          <!--Top Slider start-->
          <div class="swiper-container gallery-top ">
            <div class="swiper-wrapper ">
              <c:forEach items="${product.imgs}" var="img">
                <div class="swiper-slide gallery-top-img"> <img class="img-fluid" src="${pageContext.request.contextPath}/img/${img.name}" alt=""> </div>
              </c:forEach>


            </div>
            <!--Controls-->
            <div class="swiper-button-next swiper-button-white control-btn"></div>
            <div class="swiper-button-prev swiper-button-white control-btn"></div>
          </div>
          <!--Top Slider end--> 
          
          <!--Bottom Slider start-->
          <div class="swiper-container gallery-thumbs">
            <div class="swiper-wrapper">
              <c:forEach items="${product.imgs}" var="img">
                <div class="swiper-slide gallery-top-img"> <img class="img-fluid" src="${pageContext.request.contextPath}/img/${img.name}" alt=""> </div>
              </c:forEach>
            </div>
            <!--Controls--> 
            <!--<div class="swiper-button-next swiper-button-white control-btn"></div>
						<div class="swiper-button-prev swiper-button-white control-btn"></div>--> 
          </div>
          <!--Bottom Slider end--> 
          
        </div>
        
        <!--Product detail-->
        <div class="col-lg-8 col-md-7">
          <div class="product-list-view xs-mb-20">
            <h5><a href="javascript:void(0)">${product.category.name}</a></h5>
            <h4><a href="javascript:void(0)">${product.name}</a></h4>
            <div class="product-rating"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i> <i class="far fa-star"></i> <span class="txt-gray">| 5 customer review</span> </div>
            <div class="product-price"> <ins>${product.price} đ</ins>  </div>
            <p class="d-md-none d-lg-block text-justify">${product.description}</p>

          </div>
          <div class="row">
            <div class="col-lg-4">
              <div class="mb-30">
                <p class="p-0">Size :</p>
                <ul class="size-detail">
                  <li><a href="javascript:void(0)">${product.size}</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-3 col-6">
              <div class="box mb-30">
                <button class="minus">-</button>
                <input id="quantity" value="1" class="quantity text-center bg-white">
                <button class="plus">+</button>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-6 xs-mb-15 sm-mb-15"> <a class="btn theme-button animated slideInRight" onclick="addCart(${product.id})" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i> Thêm vào giỏ hàng </a> <a class="btn-wishlist-detail" onclick="addCart(${product.id})" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-compare-detail" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
          </div>
        </div>
        <!--product detail end--> 
      </div>
    </div>
  </section>
  <!--=====End Product detail Section =====--> 
  
  <!--=====product info Section =====-->
  <section class="page-section-pb">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div id="accordion" class="accordion">
            <div class="card mb-0">
              <div class="card-header" data-toggle="collapse" href="#desc"> <a class="card-title">Description</a> </div>
              <div id="desc" class="card-body collapse show p-0 pb-15" data-parent="#accordion">
                <p>${product.description}</p>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--=====End product info Section =====-->

  </c:if>
  
  <!--===== Related Product Section =====-->
  <section>
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="col-lg-8 offset-lg-2 text-center title-line mb-50">
            <h2 class="slick-title">Related Product</h2>
            <p>Lorem ipsum dolor sit amet adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magn a aliqua. Ut enim ad minim veniam quis nostrud acuad.</p>
          </div>
          
          <!-- Carousel Container -->
          <div class="slickcarousel-tab"> 
            <!-- Item -->
            <div class="productblock product-wrap">
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/06.jpg" alt=""> </a> <span class="new">NEW</span>
                <div class="product-content-wrap">
                  <div class="product-content">
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
                  </div>
                </div>
                <div class="product-title"><a href="product-detail-fullwidth.html">Product name</a></div>
                <div class="product-rating"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i> <i class="far fa-star"></i></div>
                <div class="product-price"> <ins>$12.49</ins> <del>$24.99</del> </div>
              </div>
            </div>
            <!-- Item --> 
            <!-- Item -->
            <div class="productblock product-wrap">
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/07.jpg" alt=""> </a> <span class="sale">-15%</span>
                <div class="product-content-wrap">
                  <div class="product-content">
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
                  </div>
                </div>
                <div class="product-title"><a href="product-detail-fullwidth.html">Product name</a></div>
                <div class="product-rating"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i> <i class="far fa-star"></i></div>
                <div class="product-price"> <ins>$12.49</ins> <del>$24.99</del> </div>
              </div>
            </div>
            <!-- Item --> 
            <!-- Item -->
            <div class="productblock product-wrap">
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/08.jpg" alt=""> </a> <span class="new">NEW</span>
                <div class="product-content-wrap">
                  <div class="product-content">
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
                  </div>
                </div>
                <div class="product-title"><a href="product-detail-fullwidth.html">Product name</a></div>
                <div class="product-rating"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i> <i class="far fa-star"></i></div>
                <div class="product-price"> <ins>$12.49</ins> <del>$24.99</del> </div>
              </div>
            </div>
            <!-- Item --> 
            <!-- Item -->
            <div class="productblock product-wrap">
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/02.jpg" alt=""> </a> <span class="sale">-15%</span>
                <div class="product-content-wrap">
                  <div class="product-content">
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
                  </div>
                </div>
                <div class="product-title"><a href="product-detail-fullwidth.html">Product name</a></div>
                <div class="product-rating"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i> <i class="far fa-star"></i></div>
                <div class="product-price"> <ins>$12.49</ins> <del>$24.99</del> </div>
              </div>
            </div>
            <!-- Item --> 
            <!-- Item -->
            <div class="productblock product-wrap">
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/05.jpg" alt=""> </a> <span class="new">NEW</span>
                <div class="product-content-wrap">
                  <div class="product-content">
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
                  </div>
                </div>
                <div class="product-title"><a href="product-detail-fullwidth.html">Product name</a></div>
                <div class="product-rating"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i> <i class="far fa-star"></i></div>
                <div class="product-price"> <ins>$12.49</ins> <del>$24.99</del> </div>
              </div>
            </div>
            <!-- Item --> 
          </div>
          <div class="arrow-center"><span class="arrows-tab"></span></div>
          
          <!-- Carousel Container --> 
        </div>
      </div>
    </div>
  </section>
  <!--=====End Related product Section =====--> 
  
  <!--===== Add Banner Section =====-->
  <section class="page-section-ptb">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 banner-img xs-mb-15 sm-mb-30"><a href="javascript:void(0)"><img class="img-fluid w-100" src="<%=request.getContextPath()%>/teamplate/public/images/banner/add_banner03.jpg" alt=""></a> </div>
      </div>
    </div>
  </section>
  <!--=====End Add Banner Section =====--> 
  
  <!--===== Footer =====-->
<script type="text/javascript">
  function addCart(id){
    var quantity = $('#quantity').val();
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
        window.location.replace("${pageContext.request.contextPath}/dang-nhap");
      }
    });
    return false;
  }
</script>
<jsp:include page="./_footer.jsp"></jsp:include>
  <!--=====End Footer =====-->