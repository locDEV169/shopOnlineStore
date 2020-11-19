<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../sources/head" %>
</head>
<body>
	 <!------------header------------------>
     <%@include file="../sources/header" %>
     <form action="cart/add?id=${prd.getName_Prd() }" method="post">
     <div class="small-container single-product">
        <div class="row">
            <div class="col-2">
                <img src='<c:url value="/resources/img/products/${prd.getImg_Prd() }" ></c:url>' alt="" width="100%" id="ProductImg">
               </div>
            <div class="col-3">
                <p>${prd.getName_Prd() }</p>
                
                <h4>${prd.formatVND() } </h4>
                <select name="" id="">
                    <option value="">Select Size</option>
                    <option value="">XXl</option>
                    <option value="">XL</option>
                    <option value="">Large</option>
                    <option value="">Mediun</option>
                    <option value="">Small</option>
                </select>
                <input type="number" value="1" name="quanlity">
                <input type="submit" class="btn" value="Add to Cart">
                <h3>Products Details <i class="fa fa-indent"></i></h3>
                <br>
                <p>Give your summer wardrobe a style upgrade with the HDX Men's Active T-shirt.Team it with a pair of shorts for your moring outfit or workout</p>
            </div>
        </div>
    </div>
    </form>
     <!----footer----->
    <%@include file="../sources/footer" %>
    <!----js for MenuToggle()----->
    <script>
        var MenuItems = document.getElementById("MenuItems");
        MenuItems.style.maxHeight = "0px";

        function menuToggle() {
            if (MenuItems.style.maxHeight == "0px") {
                MenuItems.style.maxHeight = "200px";
            } else {
                MenuItems.style.maxHeight = "0px";
            }
        }
    </script>
</body>
</html>