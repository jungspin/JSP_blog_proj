<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!-- 회원정보수정!!!!!!! -->
<div class="container">
	<form action="${cp}/user?cmd=update" method="post">
		<div class="form-group">
			<input type="hidden" name="id" value="${userUpEntity.id}"/>
			<input type="text" class="form-control" value="${userUpEntity.username}" name="username" required="required" />
		</div>
		<div class="form-group">
			<input type="password" class="form-control" value="${userUpEntity.password}" name="password" required="required" />
		</div>
		<div class="form-group">
			<input type="email" class="form-control" value="${userUpEntity.email}" name="email" required="required" />
		</div>
		<div class="form-group">
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-info" onClick="goPopup();">주소검색</button>
			</div>
			<input type="text" class="form-control" value="${userUpEntity.address}" name="address" id="address" required readonly />
		</div>
		<button type="submit" class="btn btn-primary">회원정보수정</button>
	</form>
	<br />
	<form action="${cp}/user?cmd=delete" method="post">
		<input type="hidden" name="id" value="${userUpEntity.id}" />
		<button type="submit" class="btn btn-primary">회원탈퇴</button>
	</form>
</div>
<script>
	// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
	//document.domain = "abc.go.kr";

	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("/blog/views/user/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadFullAddr) {
		var addressEl = document.querySelector("#address");
		addressEl.value = roadFullAddr;

	}
</script>
<%@ include file="../layout/footer.jsp"%>