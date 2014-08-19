<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:useBean id="ueb" class="verschluesseler.Uebersetzer" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Felix Web App</title>
</head>
<body>
	<p><a href="index1.jsp">index1.jsp</a> <a href="index2.jsp">index2.jsp</a>
	<h1>Verschlüssler</h1>
	<form method="post">
		<table>
			<tr>
				<td>Codewort eingeben:</td>
				<td><input name="codeword"
					value='<%=request.getParameter("codeword") == null ? "" : request.getParameter("codeword")%>'></td>
			</tr>
			<tr>
				<td>Eingabetext:</td>
				<td><textarea rows="4" cols="80" name="in"><%=request.getParameter("in") == null ? "" : request.getParameter("in")%></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" name="codiere" value="Verschlüsseln"></td>
				<td><input type="submit" name="decodiere" value="Entschlüsseln"></td>
			</tr>
			<tr>
				<td>Übersetzung:</td>
				<td>
					<%
						if (request.getParameter("codiere") != null) {
					%><%=ueb.codiere(request.getParameter("codeword"), request.getParameter("in"))%>
					<%
						}
						if (request.getParameter("decodiere") != null) {
					%><%=ueb.decodiere(request.getParameter("codeword"), request.getParameter("in"))%>
					<%
						}
					%>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
