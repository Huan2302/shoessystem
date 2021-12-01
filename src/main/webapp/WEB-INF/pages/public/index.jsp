<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

  <jsp:include page="./_header.jsp"></jsp:include>
  
  <!--===== End header =====--> 
  
  <!--===== Banner Slider =====-->
  
  <section id="main-slider">
    <div id="demo" class="carousel slide" data-ride="carousel">
    
      <div class="carousel-inner">
        
        <div class="carousel-item active"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/banner/12.jpg" alt="Banner 3">
          <div class="slider-content">
            <div class="container">
              <div class="row">
                <div class="col-xl-6 col-md-12 col-sm-12 offset-xl-3 bottom-15">
                  <div class="p-5 xx-p-15 text-center">
                    <h1 class="text-uppercase animated jackInTheBox"><span>New</span> Footwear </h1>
                    <p class="mt-20 mb-30 animated slideInLeft">Enjoy up to 30% Off</p>
                    <a class="btn theme-button animated slideInRight" href="${pageContext.request.contextPath}/danh-muc/${listCategory[0].id}">Shop Now </a> </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
  </section>
  
  <!--===== End Banner Slider =====--> 
  
  <!--===== Category Section =====-->
  <section class="page-section-ptb">
    <div class="container">
      <div class="row">
      	<div class="col-lg-6 col-sm-6 xs-mb-30">
     		 <div class="cat-wrapper">
     		 	<a href="javascript:void(0)"><img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/category/cat-03.jpg" alt="Card image"></a>
     		 </div>
      		 <div class="cat-text cat-1">
      		 	<h4><a href="${pageContext.request.contextPath}/danh-muc/${listCategory[0].id}">${listCategory[0].name}</a></h4>
      		 	<p>Nâng tầm cuộc sống</p>
      		 </div> 
      	</div>
      	<div class="col-lg-3 col-sm-3 xs-mb-30">
      		 <div class="cat-wrapper">
     		 	<a href="javascript:void(0)"><img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/category/cat-01.jpg" alt="Card image"></a>
     		 </div>
      		 <div class="cat-text cat-2">
               <h4><a href="${pageContext.request.contextPath}/danh-muc/${listCategory[1].id}">${listCategory[1].name}</a></h4>
      		 	<p>Sale 50% Off</p>
      		 </div>
      	</div>
      	<div class="col-lg-3 col-sm-3">
     		 <div class="cat-wrapper mb-30">
     		 	<a href="javascript:void(0)"><img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/category/cat-04.jpg" alt="Card image"></a>
     		 </div>
      		 <div class="cat-text cat-3">
               <h4><a href="${pageContext.request.contextPath}/danh-muc/${listCategory[2].id}">${listCategory[2].name}</a></h4>
      		 	<p>Sale 30% Off</p>
      		 </div>
      		 <div class="cat-wrapper">
     		 	<a href="javascript:void(0)"><img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/category/cat-02.jpeg" alt="Card image"></a>
     		 </div>
      		 <div class="cat-text cat-4">
               <h4><a href="${pageContext.request.contextPath}/danh-muc/${listBrand[0].id}">${listBrand[0].name}</a></h4>
      		 	<p>Sale 20% Off</p>
      		 </div>
      	</div>
      </div>
    </div>
  </section>
  
  <!--===== End Category Section =====--> 
  
  <!--===== Trending Products Section =====-->
  <section>
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="col-lg-8 offset-lg-2 text-center title-line mb-50">
            <h2 class="slick-title">Trending Products</h2>
            <p>Lorem ipsum dolor sit amet adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magn a aliqua. Ut enim ad minim veniam quis nostrud acuad.</p>
          </div>
          
          <!-- Carousel Container -->
          <div class="slickcarousel"> 
            <!-- Item -->
            <c:forEach items="${listProduct}" var="product">
              <div class="productblock product-wrap">
                <div class="Content"> <a href="javascript:void(0)">
                  <img class="img-fluid" src="${pageContext.request.contextPath}/img/${product.imgs[0].name}" alt=""> </a> <span class="sale">-15%</span>
                  <div class="product-title"><a href="${pageContext.request.contextPath}/san-pham/${product.id}">${product.name}</a></div>
                  <div class="product-price"> <ins>${product.price}</ins> </div>
                </div>
              </div>
            </c:forEach>
            <!-- Item -->
          </div>
          <div class="arrow-center"><span class="arrows"></span></div>
          <!-- Carousel Container --> 
        </div>
      </div>
    </div>
  </section>
  <!--=====End Trending Products Section =====--> 
  
  <!--===== Best Selling Section =====-->
  <br><br><br>
  <!--=====End Best Selling Section =====--> 
  
  <!--===== Our Service Section =====-->
  <section class="page-section-pt">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 col-md-4 text-center hvr-wobble-horizontal"> <img class="img-fluid service-img" src="<%=request.getContextPath()%>/teamplate/public/images/fast-delivery.png" alt="">
          <h4>Fast Shipping</h4>
          <p>Lorem ipsum dolor sit amet</p>
        </div>
        <div class="col-lg-4 col-md-4 text-center hvr-wobble-horizontal"> <img class="img-fluid service-img" src="<%=request.getContextPath()%>/teamplate/public/images/credit-card.png" alt="">
          <h4>Secure Payment</h4>
          <p>Lorem ipsum dolor sit amet</p>
        </div>
        <div class="col-lg-4 col-md-4 text-center hvr-wobble-horizontal"> <img class="img-fluid service-img" src="<%=request.getContextPath()%>/teamplate/public/images/customer-service.png" alt="">
          <h4>Customer Support</h4>
          <p>Lorem ipsum dolor sit amet</p>
        </div>
      </div>
    </div>
  </section>
  <!--=====End Our Section =====--> 
  
  <!--===== Subscribe Section =====-->
  <section class="page-section-ptb">
    <div class="parallax-subscribe">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 offset-lg-2 text-center mb-50 pt-50 xs-mb-0">
            <h2 class="slick-title text-white">Subscribe Us</h2>
            <p class="text-white">Lorem ipsum dolor sit amet adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magn a aliqua. Ut enim ad minim veniam quis nostrud acuad.</p>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-6 offset-lg-3 text-center pb-50">
            <div class="subscribe-form">
              <form>
                <input class="form-control" type="email" value="" name="EMAIL" placeholder="Enter your email">
                <button class="btn btn-sub" type="submit" value="Subscribe" name="subscribe">Subscribe</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!--=====End Subscribe Section =====--> 
  
  <!--=====Blog Section =====-->

  <!--=====End Blog Section =====--> 
  
  <!--=====Our Brands Section =====-->
  <section class="page-section-ptb">
    <div class="container">
      <div class="row">
        <div class="col-lg-2 col-md-2 col-sm-4 col-4"> <img class="img-fluid brand" src="<%=request.getContextPath()%>/teamplate/public/images/brands/01.png" alt="">
          <div class="blog-effect"></div>
        </div>
        <div class="col-lg-2 col-md-2 col-sm-4 col-4"> <img class="img-fluid brand" src="<%=request.getContextPath()%>/teamplate/public/images/brands/02.png" alt=""> </div>
        <div class="col-lg-2 col-md-2 col-sm-4 col-4"> <img class="img-fluid brand" src="<%=request.getContextPath()%>/teamplate/public/images/brands/03.png" alt=""> </div>
        <div class="col-lg-2 col-md-2 col-sm-4 col-4"> <img class="img-fluid brand" src="<%=request.getContextPath()%>/teamplate/public/images/brands/04.png" alt=""> </div>
        <div class="col-lg-2 col-md-2 col-sm-4 col-4"> <img class="img-fluid brand" src="<%=request.getContextPath()%>/teamplate/public/images/brands/05.png" alt=""> </div>
        <div class="col-lg-2 col-md-2 col-sm-4 col-4"> <img class="img-fluid brand" src="<%=request.getContextPath()%>/teamplate/public/images/brands/06.png" alt=""> </div>
      </div>
    </div>
  </section>
  <!--=====End Our Brands Section =====--> 
  
  <!--===== Footer =====-->
  <jsp:include page="./_footer.jsp"></jsp:include>
  <!--=====End Footer =====--> 
