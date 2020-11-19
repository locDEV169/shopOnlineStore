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
			<div class="block">
				<c:if test="${list != null }">
				<table class="data display datatable" id="example">
						<tr>
							<th>Day</th>
							<th>Description</th>
							<th>Total</th>					
						</tr>
						<c:forEach var="list" items="${list }" >
						<tr>
							<td>${list.getDate_of_sale() }</td>
							<td>${list.getDescription() }</td>
							<td>${list.getTotal() }</td>
						</tr>
						</c:forEach>
				</table>
				</c:if>
			</div>
		</div>
	</div>
<%@include file="resourcesAdmin/inc/footer.html" %>	
</body>
</html>