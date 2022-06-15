<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.assignmentjava.assignmentjava.entity.Food" %>
<%@ page import="com.example.assignmentjava.assignmentjava.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"/>
<head>
</head>
<body>
<div class="wrapper">
    <div class="main-header">
        <!-- Logo Header -->
        <div class="logo-header" data-background-color="blue">

            <a href="index.html" class="logo">
                <img src="/admin/assets/img/logo.svg" alt="navbar brand" class="navbar-brand">
            </a>
            <button class="navbar-toggler sidenav-toggler ml-auto" type="button" data-toggle="collapse" data-target="collapse" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon">
						<i class="icon-menu"></i>
					</span>
            </button>
            <button class="topbar-toggler more"><i class="icon-options-vertical"></i></button>
            <div class="nav-toggle">
                <button class="btn btn-toggle toggle-sidebar">
                    <i class="icon-menu"></i>
                </button>
            </div>
        </div>
        <!-- End Logo Header -->

        <!-- Navbar Header -->
        <nav class="navbar navbar-header navbar-expand-lg" data-background-color="blue2">

            <div class="container-fluid">
                <ul class="navbar-nav topbar-nav ml-md-auto align-items-center">
                    <li class="nav-item toggle-nav-search hidden-caret">
                        <a class="nav-link" data-toggle="collapse" href="#search-nav" role="button" aria-expanded="false" aria-controls="search-nav">
                            <i class="fa fa-search"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- End Navbar -->
    </div>

    <!-- Sidebar -->
    <jsp:include page="/admin/includes/slidebar.jsp"/>
    <!-- End Sidebar -->

    <html>
    <head>
        <title>Account Management Application</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Product Management App </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/category/create" class="nav-link">Category List</a></li>
            </ul>
        </nav>
    </header>
    <br>
        <%
    Category category = (Category) request.getAttribute("category");
%>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <form action="/category/update" method="post">
                    <fieldset class="form-group">
                        <input type="hidden"  class="form-control" name="id" value="<%= category.getId() %>" >
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Name</label> <input type="text"  class="form-control" name="name" value="<%= category.getName() %>" required="required">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Update</button>
                </form>
            </div>
        </div>
    </div>
    </html>
</body>
<!-- Custom template | don't include it in your project! -->
<jsp:include page="/admin/includes/customer-template.jsp"/>
<!-- End Custom template -->
</div>
<!--   Core JS Files   -->
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>