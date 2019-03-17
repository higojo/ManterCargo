<%@page import="br.com.higojo.model.Cargo"%>
<%@page import="br.com.higojo.enumeration.OpcoesMostrarEnum"%>
<%@page import="br.com.higojo.enumeration.CBOEnum"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>Manter Cargo</title>
<script>
function confirma(idCargo) {
	if(window.confirm("Deseja realmente excluir o registro?")){
		location.href="cargoServlet?acao=excluir&idExc="+idCargo;
	}
}
</script>
</head>
<body>
	<form action="cargoServlet" method="get">
		<table>
			<tbody>
				<tr>
					<td>Nome do Cargo:</td>
					<td><input type="text" name="nomeFiltro"></td>
				</tr>
				<tr>
					<td>CBO:</td>
					<td>
						<select name="cboFiltro">
							<option>Selecione...</option>
						<%
						List<String> listaCBOs = CBOEnum.valores();
							for(String item : listaCBOs) {
								out.print("<option value="+item+">"+item+"</option>");
							}
						%>
						</select>
					</td>
				</tr>
				<tr>
					<td>Código Folha:</td>
					<td><input type="number" name="codFolhaFiltro"></td>
				</tr>
				<tr>
					<td>Mostrar somente:</td>
					<td>
					<select name="opcoesFiltro">
						<%
						List<String> listaOpcoes = OpcoesMostrarEnum.listaOpcoes();
							for(String item : listaOpcoes) {
								out.print("<option value="+item+">"+item+"</option>");
							}
						%>
					</select></td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="cargoServlet?acao=novo"><input type="button" value="Adicionar novo"></a>
						<input type="submit" value="Pesquisar">
					</td>				
				</tr>
			</tbody>
		</table>
		<table border="1">
			<tr style="background-color: black; color: white;">
				<td style="font-weight: bold; font-size: 18px">Nome do Cargo</td>
				<td style="font-weight: bold; font-size: 18px">CBO</td>
				<td style="font-weight: bold; font-size: 18px">Código Folha</td>
				<td style="font-weight: bold; font-size: 18px">Situação</td>
				<td style="font-weight: bold; font-size: 18px">Ações</td>
			</tr>
			
	<% List<Cargo> listaCargos = (List<Cargo>) request.getAttribute("listaCargos"); 
		for(Cargo c : listaCargos) {
			out.print("<tr>");
				out.print("<td>");
					out.print(c.getNome());
				out.print("</td>");
				
				out.print("<td>");
					out.print(c.getCbo());
				out.print("</td>");
				
				out.print("<td>");
					out.print(c.getCodFolha());
				out.print("</td>");
				
				out.print("<td>");
					out.print(c.getSituacao());
				out.print("</td>");
				
				out.print("<td>");
					out.print(" <a href='cargoServlet?acao=editar&idEdit="+ c.getId() +"'>editar</a> ");
					out.print(" | <a href='javascript:confirma("+c.getId()+")'>excluir</a> ");
				out.print("</td>");
			out.print("</tr>");
		}
	%>
		</table>
	</form>
</body>
</html>