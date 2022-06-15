<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.assignmentjava.assignmentjava.entity.Food" %>
<%@ page import="com.example.assignmentjava.assignmentjava.entity.Category" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<jsp:include page="/admin/includes/head.jsp"/>
<head>
    <style>
        .invalid-feedback {
            color: red;
        }
    </style>
</head>
<body>
<%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors == null) {
        errors = new HashMap<>();
    }
    Category category = (Category) request.getAttribute("category");
    if(category == null) {
        category = new Category();
    }
%>
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
    <div class="main-panel">
        <div class="content">
            <div class="page-inner">
                <div class="row">
                    <div class="col-md-12">
                           <div class="card">
                               <div class="card-header">
                                   <div class="card-title">Category</div>
                               </div>
                               <form action="/category/create" method="post">
                               <div class="card-body">
                                   <div class="row">
                                       <div class="col-md-6 col-lg-4">
                                           <div class="form-group">
                                               <label>Name</label>
                                               <input id="name" class="form-control" name="name" value="<%= category.getName() %>" type="text">
                                               <%
                                                   if(errors.containsKey("name"))   {
                                               %>
                                               <div class="invalid-feedback">
                                                   <%= errors.get("name")%>
                                               </div>
                                               <% } %>
                                               <div class="card-action">
                                                   <button class="btn btn-success" type="submit">Submit</button>
                                                   <button class="btn btn-danger" type="reset">Reset</button>
                                               </div>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                               </form>
                           </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Custom template | don't include it in your project! -->
    <jsp:include page="/admin/includes/customer-template.jsp"/>
    <!-- End Custom template -->
</div>
<!--   Core JS Files   -->
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>