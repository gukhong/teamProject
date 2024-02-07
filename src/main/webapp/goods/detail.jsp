<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container">
	<c:if test="${sessionScope.isAdmin!=null}">
	<!-- 삭제버튼 -->
	<form style="display:inline-block" method="post" action="<%= request.getContextPath()%>/book?cmd=delete" >
		<input type="hidden" name="id" value="${book.bookId}"/>
		<button type="submit" class="btn btn-danger">삭제</button>
	</form>
	<!-- 수정버튼 -->
	<form style="display:inline-block" method="post" action="<%= request.getContextPath()%>/book?cmd=edit">
		<input type="hidden" name="id" value="${book.bookId}"/>
		<button type="submit" class="btn btn-primary">수정</button>
	</form>
	</c:if>
	
	<br />
	<br />
	
	<h3>NO12 상세보기</h3>
	<br />
	<br />
	
	
	<div class="m-2" style="display:flex;">
		<div style="width:50%">
		<h3 class="m-2">
		<b>${dto.bookname}</b></h3><hr /><br /><br />		
		 code : <i>${dto.code}</i><hr /><br /><br />		
		 타입 : <i>${dto.booktype}</i><hr /><br /><br />		
		 저자 : <i>${dto.author}</i><hr /><br /><br />		
		 출판사 : <i>${dto.publisher}</i><hr /><br /><br />		
		 가격 : <i>${dto.bookprice }</i><hr /><br /><br />		
		 발간일 : <i>${dto.publicationdate}</i><hr /><br /><br />		
		 </div>
		<div style="width:50%">
		<img src="upload/big/${dto.code}.jpg" />
		 </div>	
	</div>
	
	
	<hr />
	<div class="form-group">
		<div class="m-2" id="summernote">${dto.detailcontent } </div>
	</div>
	<hr />
</div>
	
<script>
      $('#summernote').summernote({
        tabsize: 2,
        height: 500
      });
    </script>

<%@ include file="../include/footer.jsp" %>