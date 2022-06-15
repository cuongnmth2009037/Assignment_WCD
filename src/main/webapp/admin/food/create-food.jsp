<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.assignmentjava.assignmentjava.entity.Food" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.assignmentjava.assignmentjava.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.assignmentjava.assignmentjava.entity.entityEnum.FoodStatus" %>
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
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    if (categories == null){
        categories = new ArrayList<>();
    }
%>

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
                            <form action="/food/create" method="post">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6 col-lg-4">
                                            <div class="form-group">
                                                <label>Name</label>
                                                <input type="text" class="form-control" name="name">
                                            </div>
                                            <div class="form-group">
                                                <div class="form-group col-md-4">
                                                    <label>Category</label>
                                                    <select name="status"  class="form-control">
                                                        <%for (int i = 0; i < categories.size(); i++) {%>
                                                        <option value="<%= categories.get(i).getId()%>"><%=categories.get(i).getName()%></option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Description</label>
                                                <input type="text" class="form-control" name="description">
                                            </div>
                                            <div class="form-group">
                                                <label>Thumbnail</label>
                                                <div class="m-2">
                                                    <button id="upload_widget" type="button" class="btn btn-primary">Choose Image</button>
                                                </div>
                                                <div>
                                                    <img class="img-size-10 img-rounded" id="preview-image" src="">
                                                    <input type="hidden" name="thumbnail" id="hidden-thumbnails">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label>Price</label>
                                                <input type="text" class="form-control" name="price">
                                            </div>
                                            <div class="form-group">
                                                <label>StartDate</label>
                                                <input type="date" class="form-control" name="startDate">
                                            </div>
                                            <div class="form-group col-md-4">
                                                <label>Status</label>
                                                <select name="status" id="inputState" class="form-control">
                                                    <%for (int i = 0; i < FoodStatus.values().length; i++) {%>
                                                    <option value="<%= FoodStatus.values()[i].getValue()%>"><%=FoodStatus.values()[i].name()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="card-action">
                                                <button class="btn btn-success" type="submit">Submit</button>
                                                <button class="btn btn-danger" type="reset">Reset</button>
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
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'cuongclound0999',
            uploadPreset: 'fz7f745w'}, (error, result) => {
            if (!error && result && result.event === "success") {
                $('#preview-image').attr('src',result.info.secure_url)
                $('#hidden-thumbnails').val(result.info.secure_url)
            }
        }
    )

    document.getElementById("upload_widget").addEventListener("click", function(){
        myWidget.open();
    }, false);
</script>


    <!-- Custom template | don't include it in your project! -->
    <jsp:include page="/admin/includes/customer-template.jsp"/>
    <!-- End Custom template -->
</div>
<!--   Core JS Files   -->
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>