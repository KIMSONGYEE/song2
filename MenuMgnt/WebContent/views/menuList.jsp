<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴목록</title>
<link href="${pageContext.request.contextPath}/resources/css/menuList.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#menuBox").click(menu);
		$("#menuContainer").mouseover(menuover);
	}); 
	
	var menuover = function() {
		var menus = $(".menus");
		$.each(menus, function (index, item) {
			$(item).mouseover(function() {
				$(item).addClass("menuActive");
			});
			$(item).mouseout(function() {
				$(item).removeClass("menuActive");
			});
		});
	};

	var menu = function() {
		$("#menuContainer").toggle();
	};
</script>
</head>
<body>
	<h2>메뉴목록</h2>
	<div id="menuBox">메뉴보기</div>
	<div class="seperator"></div>
	<div id="menuContainer">
		<c:forEach var="menu" items="${menus}" varStatus="sts">
			<div class="menus">${menu.name}</div>
		</c:forEach>
	</div>
	<br>
	<a href="${pageContext.request.contextPath}/views/menuCreate.jsp">처음으로</a>
</body> 
</html>