<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../sources/head" %>
<style type="text/css">
body {
    background: #81c644;
    font-family: 'Josefin Sans', sans-serif;
}
</style>
</head>
<body>
<!------------header------------------>
     <%@include file="../sources/header" %>
  <div class="wrapper">
        <label>Our Team</label>
        <div class="team">
            <div class="team_member">
                <div class="team_img">
                    <img src='<c:url value="/resources/img/frontend/vuong.jpg" ></c:url>' alt="Team_image" style="width:100px; height:100px; zoom:1;" class="ava">
                </div>
                <h3>Duy Vương</h3>
                <p class="role ">Backend Developer</p>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est quaerat tempora, voluptatum quas facere dolorum aut cumque nihil nulla harum nemo distinctio quam blanditiis dignissimos.</p>
            </div>
            <div class="team_member ">
                <div class="team_img ">
                    <img src='<c:url value="/resources/img/frontend/vu.jpg" ></c:url>' alt="Team_image" style="width:100px; height:100px;" class="ava">
                </div>
                <h3>Anh Vũ</h3>
                <p class="role ">Database Developer</p>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est quaerat tempora, voluptatum quas facere dolorum aut cumque nihil nulla harum nemo distinctio quam blanditiis dignissimos.</p>
            </div>
            <div class="team_member ">
                <div class="team_img ">
                    <img src='<c:url value="/resources/img/frontend/loc.jpg" ></c:url>' alt="Team_image" style="width:100px; height:100px;" class="ava">
                </div>
                <h3>Lộc Nguyễn</h3>
                <p class="role ">Design and FrontEnd Developer</p>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est quaerat tempora, voluptatum quas facere dolorum aut cumque nihil nulla harum nemo distinctio quam blanditiis dignissimos.</p>
            </div>
        </div>
    </div>  
    
    
    
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
<!----js for toggle Form----->
</body>
</html>