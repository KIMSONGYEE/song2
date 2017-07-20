<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/menuCreate.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#codebtn").click(codeCheck);
		$("#create").click(menuCreate);
	});
	
	var menuCreate = function() {
		$.ajax({
			url:"/MenuMgnt/menuCreate.do"
			,type:"post"
				, data:{"code":$("#iptCode").val()
						,"name":$("#iptName").val()
						,"display":$("#iptDisplaySeq").val()
						,"url":$("#iptUrl").val()}
			,dataType:"json"
			,success:createSuccess
			,error:errorCallback
		});
	};
	
	var createSuccess = function(data) {
		if (data) {
			location.href="/MenuMgnt/findAll.do";
		}else{
			alert("등록실패");
		}

	}

	var codeCheck = function() {
		$.ajax({
			url:"/MenuMgnt/codeCheck.do"
			,type:"get"
			, data:{"code":$("#iptCode").val()}
			,dataType:"json"
			,success:codeSuccess
			,error:errorCallback
		});
	};

	var codeSuccess = function(data) {
		if (data) {
			$("#message").html("코드사용가능");
		}else{
			$("#message").html("코드중복");
		}
	};
	
	var errorCallback = function(data) {
		console.log(data);
		alert("수행중 오류가 발생했습니다.");
	};
</script>
<title>메뉴등록</title>
</head>
<body>
	<div id="container">
		<h1>메뉴등록</h1>
			<dl>
				<dt>메뉴코드</dt>
				<dd>
					<input type="text" size="10" name="code" id="iptCode">
					<input type="submit" value="중복확인" id="codebtn">
					<span id="message"></span>
				</dd>
				<dt>메뉴명</dt>
				<dd>
					<input type="text" size="20" name="name" id="iptName">
				</dd>
				<dt>화면표시순서</dt>
				<dd>
					<input type="text" size="10" name="displaySeq" id="iptDisplaySeq">
				</dd>
				<dt>URL</dt>
				<dd>
					<input type="text" size="50" name="url" id="iptUrl">
				</dd>
			</dl>
			<p>
				<input type="submit" value="저장" id="create">
			</p>
	</div>
</body>
</html>