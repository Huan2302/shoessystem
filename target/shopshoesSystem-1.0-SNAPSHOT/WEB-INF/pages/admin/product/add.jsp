<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/13/21
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link href="<%=request.getContextPath()%>/teamplate/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/teamplate/admin/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="<%=request.getContextPath()%>/teamplate/admin/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../_leftbar.jsp"></jsp:include>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <jsp:include page="../_search.jsp"></jsp:include>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <div class="col-md-7 col-lg-8">
                    <h4 class="mb-3">Thêm danh mục</h4>

                    <s:form method="POST"  modelAttribute="product" action="${pageContext.request.contextPath}/manager/product/new" enctype="multipart/form-data">
                        <!-- input text code -->
                        <s:hidden path="id" class="form-control" />
                        <!-- input text code-->
                        <div class="table-responsive">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="">Name</span>
                                </div>
                                <s:input path="name" class="form-control" />
                            </div>
                            <div class="input-group mb-3">
                                <s:errors path="name" class="text-danger"></s:errors>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="">Price</span>
                                </div>
                                <s:input path="price" class="form-control" />
                            </div>

                        </div>
                        <div class="table-responsive">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="">Description</span>
                                </div>
                                <s:textarea path="description" class="form-control"/>
                            </div>
                            <div class="input-group mb-3">
                                <s:errors path="description" class="text-danger"></s:errors>
                            </div>
                        </div>
                        <div class="table-responsive mt-3">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="">Size</span>
                                </div>
                                <s:input path="size" class="form-control"/>
                            </div>
                            <div class="input-group mb-3">
                                <s:errors path="size" class="text-danger"></s:errors>
                            </div>
                        </div>
                        <div class="table-responsive mt-3">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="">Stock</span>
                                </div>
                                <s:input path="stock" class="form-control"/>
                            </div>
                        </div>

                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Photo</span>
                            </div>
                            <div class="custom-file">
                                <!-- id="inputGroupFile01 -->
                                <input type="file" name="file" multiple="multiple" class="custom-file-input"/>
                                <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                            </div>
                        </div>

                        <div class="table-responsive">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="">Category</span>
                                </div>
                                <s:select path="category.id" class="custom-select" id="inputGroupSelect01">
                                    <c:forEach items="${listCategory}" var="category">
                                        <s:option value="${category.id}">${category.name}</s:option>
                                    </c:forEach>
                                </s:select>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="">Brand</span>
                                </div>
                                <s:select path="brand.id" class="custom-select" id="inputGroupSelect01">
                                    <c:forEach items="${listBrand}" var="brand">
                                        <s:option value="${brand.id}">${brand.name}</s:option>
                                    </c:forEach>
                                </s:select>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary">Submit</button>
                    </s:form>
                </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="<%=request.getContextPath()%>/teamplate/admin/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/teamplate/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="<%=request.getContextPath()%>/teamplate/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="<%=request.getContextPath()%>/teamplate/admin/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="<%=request.getContextPath()%>/teamplate/admin/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/teamplate/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="<%=request.getContextPath()%>/teamplate/admin/js/demo/datatables-demo.js"></script>

</body>

</html>