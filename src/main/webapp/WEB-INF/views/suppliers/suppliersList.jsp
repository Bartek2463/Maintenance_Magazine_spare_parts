<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../dynamic/css.jspf"%>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <%@include file="../dynamic/navigationMain.jspf" %>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>



                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">


                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Dostawcy</h1>
                <p class="mb-4"> Lista aktualnie dodanych dostawców </p>


                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Tabela Dostawców</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table action-panel table-bordered" id="dataTable" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Nazwa Firmy</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Nazwa Firmy</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${supplier}" var="title">
                                    <tr>
                                        <td>${title.supplier}</td>
                                        <td><a href="#" role="button" class="btn btn-success btn-circle" data-toggle="modal" data-target="#umiejetnosci"><i class="fas
                                        fa-check"></i></a></td>

                                        <td><a href='<c:url value="/editSupplier/${title.id}"/>'
                                               class="btn-right btn btn-primary" role="button">Edytuj</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>





            </div>
            <!-- /.container-fluid -->

            <!-- /.container-fluid -->
            <div class="card-header py-3">


                <a href='<c:url value="/addSupplier"/>' class="btn btn-info btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-info-circle"></i>
                    </span>
                    <span class="text">Dodaj nowego</span>
                </a>


            </div>




        </div>
        <!-- End of Main Content -->

        <%@include file="../dynamic/board.jspf"%>

        <%@include file="../dynamic/javaScript.jspf" %>



</body>

</html>
