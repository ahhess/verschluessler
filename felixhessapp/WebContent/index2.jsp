<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="hello" class="hello.Hello"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Felix Web App</title>
<body>
	<p>Name eingeben:
	<form>
		<input type="text" name="name">
	</form>
	<p>Ergebnis: <%= hello.sayHello(request.getParameter("name")) %>
</body>
</html>
