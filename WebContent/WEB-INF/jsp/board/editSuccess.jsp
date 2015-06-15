<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<script type="text/javascript">
$(document).ready(function (){
	var flag = $("#boardFlag").val();
	if(flag == "C"){
		alert("등록하였습니다.");
	}else if(flag == "U"){
		alert("수정하였습니다.");
	}else if(flag == "D"){
		alert("삭제하였습니다.");
	}
	var url = "${contextPath}/board/boardMain.do";
	$("#brdForm").attr("action", url);
	$("#brdForm").submit();
});
</script>
</head>
<body>
<form name="brdForm" id="brdForm" method="post">
<input type="hidden" id="boardFlag" name="boardFlag" value="${param.boardFlag}"/>
<input type="hidden" name="currentPage" value="${param.currentPage}" />
</form>
</body>