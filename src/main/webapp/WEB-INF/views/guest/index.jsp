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
     <%@include file="../sources/header_index" %>
     
    <!------------feature categories------------------>
    
    <!------------feature categories------------------>
    <div class="small-container">
        <h2 class="title">Feature Products</h2>
        <div class="row">
            <c:forEach var ="fp" items="${listFP }">
        
            <div class="col-4">
                <a href="detail?id=${fp.getName_Prd()}">
                    <img src='<c:url value="/resources/img/products/${fp.getImg_Prd() }" ></c:url>' alt="">
                    <h4>${fp.getName_Prd() }</h4>
                    <div class="rating">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star-half"></i>
                    </div>
                    <p>${fp.formatVND() }</p>
                </a>
            </div>
             
           </c:forEach>
        </div>
        <!------------feature categories------------------>
        <h2 class="title">Lastest Products</h2>
        <div class="row">
            <c:forEach var ="lp" items="${listLP }">
        
            <div class="col-4">
                <a href="detail?id=${lp.getName_Prd()}">
                    <img src='<c:url value="/resources/img/products/${lp.getImg_Prd() }" ></c:url>' alt="">
                    <h4>${lp.getName_Prd() }</h4>
                    <div class="rating">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star-half"></i>
                    </div>
                    <p>${lp.formatVND() }</p>
                </a>
            </div>
             
           </c:forEach>

        </div>
    </div>
    <!------------Offer------------------>
    <div class="offer">
        <div class="small-container">
            <div class="row">
                <div class="col-2">
                    <img src="images/exclusive.png" alt="" class="offer-img">
                </div>
                <div class="col-2">
                    <p>Exclusively Available on Online Store</p>
                    <h1 style=" color:rgb(223, 90, 90) ">Mi Band</h1>
                    <small>
                        The Mi Smart Band 4 feature  a 39.9% larger (than Mi Band 3) AMOLED color full-touch display with adjustable brightness, so everything is clear as can be.          
                    </small><br> <a href="#" class="btn">Buy Now &#8594</a>
                </div>
            </div>
        </div>
    </div>
    <!---testimonial--->
    <div class="testimonial">
        <div class="small-container">
            <div class="row">
                <div class="col-3">
                    <i class="fa fa-quote-left"></i>
                    <p>
                        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Minima necessitatibus voluptate, veniam voluptatem expedita sint ex cumque quas iusto ipsam totam, accusamus at. Harum sapiente adipisci, veritatis autem animi laudantium.

                    </p>
                    <div class="rating">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                    </div>
                    <img src='<c:url value="/resources/img/frontend/vuong.jpg" ></c:url>' alt="">
                    <h3>Duy Vương</h3>
                </div>
                <div class="col-3">
                    <i class="fa fa-quote-left"></i>
                    <p>
                        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Minima necessitatibus voluptate, veniam voluptatem expedita sint ex cumque quas iusto ipsam totam, accusamus at. Harum sapiente adipisci, veritatis autem animi laudantium.

                    </p>
                    <div class="rating">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                    </div>
                    <img src='<c:url value="/resources/img/frontend/vu.jpg" ></c:url>' alt="">
                    <h3>Anh Vũ</h3>
                </div>
                <div class="col-3">
                    <i class="fa fa-quote-left"></i>
                    <p>
                        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Minima necessitatibus voluptate, veniam voluptatem expedita sint ex cumque quas iusto ipsam totam, accusamus at. Harum sapiente adipisci, veritatis autem animi laudantium.

                    </p>
                    <div class="rating">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                    </div>
                    <img src='<c:url value="/resources/img/frontend/loc.jpg" ></c:url>' alt="">
                    <h3>Lộc Nguyễn</h3>
                </div>
            </div>
        </div>
    </div>
    <!---brands--->
    <div class="brands">
        <div class="small-container">
            <div class="row">
                <div class="col-5">
                    <img src="images/logo-godrej.png" alt="">
                </div>
                <div class="col-5">
                    <img src="images/dusk.final_300x300.png" alt="">
                </div>
                <div class="col-5">
                    <img src="images/logo-paypal.png" alt="">
                </div>
                <div class="col-5">
                    <img src="images/logo.png" alt="">
                </div>
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
</body>

<!-- <body>
	<c:forEach var = "a" items="${list }">
		<p>ten : ${a.getIdPrd() }</p>
		<img alt="" style="width: 50px;height: 50px;" src='<c:url value="/resources/img/products/${a.getImg_Prd() }" ></c:url>'>
	</c:forEach>
	<a href="test" >a</a>
</body> -->
</html>