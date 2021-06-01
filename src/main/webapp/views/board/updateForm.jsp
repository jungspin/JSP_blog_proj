<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="${cp}/board?cmd=update" method="post">

		<div class="form-group">
			<input type="hidden" name="id" value="${dtoUpdate.id}"/>
			<input type="text" class="form-control" placeholder="Enter title" value="${dtoUpdate.title}" name="title" required="required" />
			
		</div>
		<div class="form-group">
			<textarea id="summernote" class="form-control" rows="5" cols="" name="content">
				${dtoUpdate.content}
			</textarea>
		</div>

		<button type="submit" class="btn btn-primary">글쓰기</button>
	</form>

</div>

<script>
	$(document).ready(function() {
		$('#summernote').summernote({
			height : 300
		});
	});
</script>

<%@ include file="../layout/footer.jsp"%>
