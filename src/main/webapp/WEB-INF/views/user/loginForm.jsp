<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<form action="/login" method="post">
	<div class="form-group">
		<input type="text" name="username" class="form-control"
			placeholder="Enter username" required="required">
	</div>
	<div class="form-group">
		<input type="password" name="password" class="form-control"
			placeholder="Enter password" required="required">
	</div>
	<button type="submit" class="btn btn-primary">Login</button>
</form>
<%@ include file="../layout/footer.jsp" %>