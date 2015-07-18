<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Felix Web App</title>
<body>
<h1>Hallo Nicole und Andreas!</h1>
<p>Die Seite wurde von Felix und Andreas Hess erstellt.</p>
<p>Gibt mal bitte drei Zahlen ein:</p>
<form>
	<input type="text" name="zahl"> +
	<input type="text" name="zahl2"> - 
	<input type="text" name="zahl3">
	<input type="submit" value="Los!">
</form>
<%	
String zahl = request.getParameter("zahl");
String zahl2 = request.getParameter("zahl2");
String zahl3 = request.getParameter("zahl3");	
if (zahl != null) {
		try {		
			long z = Long.parseLong(zahl) + Long.parseLong(zahl2) - Long.parseLong(zahl3);
%>
          	<p>ergibt: <%= z %></p>
<%
		} catch (Exception e){
%>
			<h1>Fehler! <%= e.getMessage() %></h1>	
<%
		}
	}
%>
</body>
</html>
