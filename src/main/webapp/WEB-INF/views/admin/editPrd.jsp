<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="resourcesAdmin/inc/header.html" %>
<%@include file="resourcesAdmin/inc/sidebar.html" %>
</head>
<body>
	<div class="grid_10">
    <div class="box round first grid">
        <h2>Add New Product</h2>
        <div class="block">               
         <form:form action="update" method="post" modelAttribute="prd" enctype="multipart/form-data">
            <table class="form">             
                <tr>
                    <td>
                        <label>Name</label>
                    </td>
                    <td>
                        <form:input path="name_Prd" readonly="true" class="medium" />
                    </td>
                </tr>				
				
				 <tr>
                    <td style="vertical-align: top; padding-top: 9px;">
                        <label>Description</label>
                    </td>
                    <td>
                        <textarea class="tinymce" name="descrip"></textarea>
                    </td>
                </tr>
				<tr>
                    <td>
                        <label>Price</label>
                    </td>
                    <td>
                        <form:input path="price_Prd" class="medium" />
                    </td>
                </tr>
            
                <tr>
                    <td>
                        <label>Upload Image</label>
                    </td>
                    <td>
                    <form:form modelAttribute="myFile">
                        <form:input type="file" path="multipartFile" />
                    </form:form>
                    <br>
                    <img style="width: 50px;height: 50px" src='<c:url value="/resources/img/products/${prd.getImg_Prd() }" ></c:url>' alt="">
                    <input type="hidden" name = "img" value="${prd.getImg_Prd() }">
                    </td>
                </tr>
				
				<tr>
                    <td>
                        <label>Product Type</label>
                    </td>
                    <td>
                       <form:input path="id_type"/>
                        
                    </td>
                </tr>

				<tr>
                    <td></td>
                    <td>
                        <input type="submit" name="submit" Value="Update" />
                    </td>
                </tr>
            </table>
            </form:form>
        </div>
    </div>
</div>
<!-- Load TinyMCE -->
<script src="js/tiny-mce/jquery.tinymce.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        setupTinyMCE();
        setDatePicker('date-picker');
        $('input[type="checkbox"]').fancybutton();
        $('input[type="radio"]').fancybutton();
    });
</script>
<%@include file="resourcesAdmin/inc/footer.html" %>	
</body>
</html>