<!DOCTYPE html>
<%@page import="br.com.tecnosul.model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="cliente">
		E-mail: <input type="text" value="" name="email" />
		 <input type="submit" value="Save">
	</form>
	<%
	List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
	for (Cliente c: lista) {
		out.print(c.getEmail() + "</br>");
	}
	%>
</body>
</html>