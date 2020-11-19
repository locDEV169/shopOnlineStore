<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../sources/head" %></head>
<body>
<%@include file="../sources/header" %>
<div class="contact-left">
            <h3 style="color: rgb(59, 111, 255);">Information</h3>
            <form action="sendmail">
                <div class="input-row">
                    <div class="input-group">
                        <label for="">First Name</label>
                        <input type="text" name="" id="" placeholder="First Name..." pattern="[A-Za-z]{1,15}" title="Username should only contain lowercase letters. e.g. john">
                    </div>
                    <div class=" input-group">
                        <label for=" ">Last Name</label>
                        <input type="text " name=" " id=" " placeholder="Last Name... " pattern="[A-Za-z]{1,15}" title="">
                    </div>
                </div>
                <div class="input-row">
                    <div class="input-group ">
                        <label for=" ">Email</label>
                        <input type="email " name="email" id=" " placeholder="abc@gmail.com " pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="your email isn't connected">
                    </div>
                    <div class="input-group">
                        <label for=" ">Phone</label>
                        <input type="text " name=" " id=" " placeholder="0905 123 456 " pattern="[0-9]{10}">
                    </div>
                </div>
                <div class=" input-row ">
                    <div class="input-group ">
                        <label for=" ">Address</label>
                        <input type="text " name=" " id=" " placeholder="Location" required=true>
                    </div>
                </div>
                <div class="input-row ">
                    <div class="input-group ">
                        <input style="width:10px; " type="checkbox" name="save " id=" " placeholder=" ">
                        <label style="color:red " for="save ">Save Session</label>
                    </div>
                </div>
                <button type="submit " class="btn-ship ">BUY</button>
            </form>
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
</body>
</html>