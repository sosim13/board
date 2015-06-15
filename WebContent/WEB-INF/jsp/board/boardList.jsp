<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<script type="text/javascript">
function goWrite(){
	//var url = "${contextPath}/board/boardWrite.do";
	var url = "${contextPath}/board/boardWrite.do";
	$("#brdForm").attr("action", url);
	$("#boardFlag").val("C");
	$("#brdForm").submit();
}
function goPage(currentPage){
	var url = "${contextPath}/board/boardMain.do";
	$("#brdForm").attr("action", url);
	$("#currentPage").val(currentPage);
	$("#brdForm").submit();
}
function goView(boardNo){
	var url = "${contextPath}/board/boardView.do";
	$("#brdForm").attr("action", url);
	$("#boardFlag").val("R");
	$("#boardNo").val(boardNo);
	$("#brdForm").submit();
}
</script>
</head>
<body>
<div align="center">
<form id="brdForm" name="brdForm" method="post">
<input type="hidden" id="boardNo" name="boardNo" value="" />
<input type="hidden" id="boardFlag" name="boardFlag" value="" />
<input type="hidden" id="currentPage" name="currentPage" value="${paging.currentPage}" />
<table border="1">
	<colgroup>
		<col width="70px"/>
		<col width="250px"/>
		<col width="120px"/>
		<col width="120px"/>
	</colgroup>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일시</th>
	</tr>
	<c:forEach items="${boardList}" var="board">
		<tr>
			<td style="text-align:center;">${board.rNum}</td>
			<td style="text-align:center;"><a href="javascript:goView('${board.boardNo}');">${board.title}</a></td>
			<td style="text-align:center;">${board.name}</td>
			<td style="text-align:center;"><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="center"><input type="button" value="글쓰기" onclick="goWrite();" /></td>
	</tr>
	<tr>
		<td colspan="5" align="center">
			<!-- 이전 -->
			<c:if test="${paging.viewPage < paging.startPage}">
				<a href="javascript:goPage(1);">처음</a>
				<a href="javascript:goPage(${paging.startPage-1});">이전</a>
			</c:if>
			<c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
				<c:if test="${paging.currentPage ne p}">
					<a href="javascript:goPage(${p});">${p}</a>
				</c:if>
				<c:if test="${paging.currentPage eq p}">
					${p}
				</c:if>
			</c:forEach>
			<!-- 다음 -->
			<c:if test="${paging.totalPage > paging.endPage}">
				<a href="javascript:goPage(${paging.endPage+1});">다음</a>
				<a href="javascript:goPage(${paging.totalPage});">마지막</a>
			</c:if>
		</td>
	</tr>
</table>
</form>
<%-- <c:out value="${paging.startPage}" /><br/>
<c:out value="${paging.endPage}" /><br/>
<c:out value="${paging.totalPage}" /><br/> --%>
</div>
</body>