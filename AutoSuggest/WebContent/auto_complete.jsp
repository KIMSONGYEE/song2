<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>auto complete</title>
<link rel="stylesheet" href="style/css/reset.css">
<link rel="stylesheet" href="style/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#auto_complete").keyup(showKeyword);
	});

	$(document).on("click", "li", function() {
		$("#auto_complete").val($(this).html());
	});
	
	// 	var inputText = function() {
	// 		console.log("실행");
	// 		var list = $("#keywordList");
	// 		$.each(list, function(index, item) {
	// 			$(item).click(function() {
	// 				$("#auto_complete").val(item.word);
	// 			});
	// 		})
	// 	}

	var showKeyword = function() {
		$.ajax({
			url : "/AutoSuggest/serach.do",
			type : "post",
			data : {
				"keyword" : $("#auto_complete").val()
			},
			dataType : "json",
			success : showSuccess, //성공 콜백
			error : errorCallback
		//에러 콜백(함수명)
		});
	}

	var showSuccess = function(data) {
		$(".auto_complete_list").empty();
		var rowItem = "<ul>";
		console.log(data.length);
		$.each(data, function(index, item) {
			rowItem += "<li>" + item.word + "</li>"
		})
		rowItem += "</ul>";
		$(".auto_complete_list").css("visibility", "visible");
		$(".auto_complete_list").append(rowItem);
	}

	var errorCallback = function(data) {
		console.log(data);
		alert("수행중 오류가 발생했습니다.");
	};
</script>
</head>
<body>
	<div id="auto_wrap">
		<h1>namoosori-자동완성기능</h1>

		<!-- 나무소리 로고 -->
		<img src="style/image/namoosori_logo.png" alt="namoosori"
			title="namoosori" class="namoosori_logo">

		<!-- 검색창 -->
		<form action="">
			<div class="search_box">
				<input type="text" id="auto_complete" class="form_text"
					placeholder="namoosori 검색 또는 URL 입력"> <input type="button"
					class="img_button">
			</div>
		</form>

		<!-- 검색 리스트 style 삭제시 검색리스트 보임. -->
		<div class="auto_complete_list" style="visibility: hidden"></div>
	</div>
</body>
</html>