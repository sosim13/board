<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<script type="text/javascript">
function goProcess(){
	var url = "${contextPath}/board/editProcess.do";
	$("#brdForm").attr("action", url);
	
	var boardFlag = $("#boardFlag").val();
	//수정/삭제인 경우 password값 확인
	if(boardFlag == "U" || boardFlag == "D"){
		var boardNo = $("#boardNo").val();
		var password = $("#password").val();
		var url2 = "${contextPath}/board/passwordCheck.do";
		var param = {
			"boardNo" : boardNo,
			"password" : password
		};
		$.ajax({
			url : url2,
			data : param,
			type : "post",
			dataType : "text",
			async : false,
			cache : false,
			success : function (json){
				if(json.code == "200"){
					alert("성공");
				}else{
					alert("패스워드가 다릅니다.");
					$("#password").focus();
					return;
				}
				//$("#brdForm").submit();
				
			},
			error : function (){
				alert("비밀번호 확인중 오류가 발생하였습니다.");
			}
		});
	}else{
		$("#brdForm").submit();
	}
}
function goEdit(){
	var url = "${contextPath}/board/boardView.do";
	$("#brdForm").attr("action", url);
	$("#boardFlag").val("U");
	$("#brdForm").submit();
}
function goDel(){
	if(!confirm("삭제하시겠습니까?")){
		return;
	}
	$("#boardFlag").val("D");
	goProcess();
}
function goList(){
	var url = "${contextPath}/board/boardMain.do";
	$("#brdForm").attr("action", url);
	$("#brdForm").submit();
}
</script>
</head>
<body>
<div align="center">
<form id="brdForm" name="brdForm" method="post">
<c:if test="${param.boardFlag ne 'C'}">
<input type="hidden" id="boardNo" name="boardNo" value="${boardBean.boardNo}" />
</c:if>
<input type="hidden" id="boardFlag" name="boardFlag" value="${param.boardFlag}" />
<c:set var="boardFlag" value="${param.boardFlag}" />
<input type="hidden" name="currentPage" value="${param.currentPage}" />
<table border="1">
	<tr>
		<td>제목 : </td>
		<td>
			<c:if test="${boardFlag eq 'C' || boardFlag eq 'U'}">
				<input type="text" id="title" name="title" size="40" value="${boardBean.title}"/>
			</c:if>
			<c:if test="${boardFlag eq 'R'}">
				${boardBean.title}
			</c:if>
		</td>
	</tr>
	<tr>
		<td>내용 : </td>
		<td>
			<textarea id="contents" name="contents" cols="70" rows="20" <c:if test="${boardFlag eq 'R'}">readonly="readonly"</c:if>>${boardBean.contents}</textarea>
		</td>
	</tr>
	<tr>
		<td>ID : </td>
		<td>
			<c:if test="${boardFlag eq 'C' || boardFlag eq 'U'}">
				<input type="text" id="id" name="id" value="${boardBean.id}"/>
			</c:if>
			<c:if test="${boardFlag eq 'R'}">
				${boardBean.id}
			</c:if>
		</td>
	</tr>
	<tr>
		<td>이름 : </td>
		<td>
			<c:if test="${boardFlag eq 'C' || boardFlag eq 'U'}">
				<input type="text" id="name" name="name" value="${boardBean.name}"/>
			</c:if>
			<c:if test="${boardFlag eq 'R'}">
				${boardBean.name}
			</c:if>
		</td>
	</tr>
	<tr>
		<td>비밀번호 : </td>
		<td>
			<input type="password" id="password" name="password" value=""/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<c:if test="${boardFlag eq 'C' || boardFlag eq 'U'}">
				<input type="button" value="확인" onclick="goProcess();"/>
			</c:if>
			<c:if test="${boardFlag eq 'R'}">
				<input type="button" value="수정" onclick="goEdit();" />
				<input type="button" value="삭제" onclick="goDel();" />
			</c:if>
			<input type="button" value="목록" onclick="goList();" />
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>