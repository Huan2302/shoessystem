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
                    <a class="btn theme-button animated slideInRight" href="shop-grid-left-sidebar.html">Shop Now </a> </div>
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
      		 	<h4><a href="javascript:void(0)">Women's wear</a></h4>
      		 	<p>Sale 20% Off</p>
      		 </div> 
      	</div>
      	<div class="col-lg-3 col-sm-3 xs-mb-30">
      		 <div class="cat-wrapper">
     		 	<a href="javascript:void(0)"><img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/category/cat-01.jpg" alt="Card image"></a>
     		 </div>
      		 <div class="cat-text cat-2">
      		 	<h4><a href="javascript:void(0)">men's Shoes</a></h4>
      		 	<p>Sale 50% Off</p>
      		 </div>
      	</div>
      	<div class="col-lg-3 col-sm-3">
     		 <div class="cat-wrapper mb-30">
     		 	<a href="javascript:void(0)"><img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/category/cat-04.jpg" alt="Card image"></a>
     		 </div>
      		 <div class="cat-text cat-3">
      		 	<h4><a href="javascript:void(0)">men's wear</a></h4>
      		 	<p>Sale 30% Off</p>
      		 </div>
      		 <div class="cat-wrapper">
     		 	<a href="javascript:void(0)"><img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/category/cat-02.jpg" alt="Card image"></a>
     		 </div>
      		 <div class="cat-text cat-4">
      		 	<h4><a href="javascript:void(0)">Women's Bags</a></h4>
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
            <div class="productblock product-wrap">
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/01.jpg" alt=""> </a> <span class="new">NEW</span>
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
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
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
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/03.jpg" alt=""> </a> <span class="sale">-10%</span>
                <div class="product-content-wrap">
                  <div class="product-content">
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
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
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/04.jpg" alt=""> </a> <span class="new">NEW</span>
                <div class="product-content-wrap">
                  <div class="product-content">
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
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
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
                  </div>
                </div>
                <div class="product-title"><a href="product-detail-fullwidth.html">Product name</a></div>
                <div class="product-rating"> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star-half-alt"></i> <i class="far fa-star"></i></div>
                <div class="product-price"> <ins>$12.49</ins> <del>$24.99</del> </div>
              </div>
            </div>
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
  <section>
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="col-lg-8 offset-lg-2 text-center title-line mb-50">
            <h2 class="slick-title">Best Selling</h2>
            <p>Lorem ipsum dolor sit amet adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magn a aliqua. Ut enim ad minim veniam quis nostrud acuad.</p>
          </div>
          
          <!-- Carousel Container -->
          <div class="slickcarousel-tab"> 
            <!-- Item -->
            <div class="productblock product-wrap">
              <div class="Content"> <a href="javascript:void(0)"> <img class="img-fluid" src="<%=request.getContextPath()%>/teamplate/public/images/shop/06.jpg" alt=""> </a> <span class="new">NEW</span>
                <div class="product-content-wrap">
                  <div class="product-content">
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
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
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
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
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
                  </div>
                </div>
                <div class="product-title"><a href="shop-grid-left-sidebar.html">Product name</a></div>
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
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
                  </div>
                </div>
                <div class="product-title"><a href="shop-grid-left-sidebar.html">Product name</a></div>
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
                    <div class="product-hover"> <a class="btn-cart" title="Add To Cart" href="javascript:void(0)"><i class="fas fa-shopping-cart"></i></a> <a class="btn-view" title="Quick View" href="javascript:void(0)" data-toggle="modal" data-target="#quickview" data-keyboard="true"><i class="fas fa-eye"></i></a> <a class="btn-wishlist" title="Add To Wishlist" href="javascript:void(0)"><i class="fas fa-heart"></i></a> <a class="btn-wishlist" title="Add To Compare" href="compare.html"><i class="fas fa-sync-alt"></i></a> </div>
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
