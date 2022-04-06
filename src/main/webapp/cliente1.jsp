<!DOCTYPE html>
<%@page import="br.com.tecnosul.model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script>
	function confirma(pi) {
		if (window.confirm("Tem certeza que deseja excluir?")) {
			location.href = "cliente?acao=exc&i=" + pi;
		}
	}
</script>

</head>
<body>

	<div>${requestScope.msg}</div>

	<form method="post" action="cliente">

		<input type="hidden" name="i" value="${requestScope.iCli}">
		E-mail: 
		<input type="text" value="${requestScope.cli.email}"
				name="email" /> <input type="submit" value="Save">
	</form>

	<table border="1">

		<tr>
			<th>E-mail</th>
			<th>Ação</th>
		</tr>

		<c:set var="i" value="0" />
		<c:forEach items="${requestScope.lista}" var="c">

			<tr>
				<td>${c.email}</td>

				<td>
				<a href="javascript:confirma(${i})"> excluir </a> | 
				<a href="cliente?i=${i}&acao=edit"> editar </a>
				</td>
			</tr>
			<c:set var="i" value="${i+1}"/>
		</c:forEach>

	</table>
</body>
</html>