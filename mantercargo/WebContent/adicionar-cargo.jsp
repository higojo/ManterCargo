<%@page import="br.com.higojo.enumeration.SituacaoEnum"%>
<%@page import="br.com.higojo.model.Cargo"%>
<%@page import="br.com.higojo.enumeration.CBOEnum"%>
<%@page import="br.com.higojo.model.Categoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Adicionar/Editar Cargo</title>
	<% 
	if(request.getAttribute("validacao") != null && request.getAttribute("validacao").equals("true")){
		out.print("<script> alert('teste'); </script>"); 
	}
	%>
</head>
<body>
	<form action="cargoServlet" method="post" id='form'>
	<% Cargo cargo = (Cargo) request.getAttribute("cargoEdicao"); %>
	<input type='hidden' id='subid' value="<%= cargo.getSubcategoria().getId() %>">
		<table>
			<tr>
				<td>Nome do Cargo:</td>
				<td><input value="<%= cargo.getNome() %>" type="text" name="nome" required></td>
			</tr>
			<tr>
				<td>Descrição:</td>
				<td><textarea name="descricao" rows="2" cols="22"><%= cargo.getDescricao()  %></textarea></td>
			</tr>
			<tr>
				<td>CBO:</td>
				<td>
					<select name="cbo">
					<option>Selecione...</option>
					<%
					List<String> listaCBOs = CBOEnum.valores();
						for(String item : listaCBOs) {
							if(cargo.getCbo() != null && item.equalsIgnoreCase(cargo.getCbo().name())){
								out.print("<option selected value="+item+">"+item+"</option>");
							} else {
								out.print("<option value="+item+">"+item+"</option>");
							}
						}
					%>
					</select>
				</td>
			</tr>
			<tr>
				<td>Código Folha:</td>
				<td><input value="<%= cargo.getCodFolha() %>" type="number" name="codFolha" required min=1></td>
			</tr>
			<tr>
				<td>Valor Hora:</td>
				<td><input value="<%= cargo.getVlHora() %>" type="number" name="vlHora" min=1></td>
			</tr>
			<tr>
				<td>Horas por Semana:</td>
				<td><input value="<%= cargo.getHrSemana() %>" type="number" name="hrSemana" min=1></td>
			</tr>
			<tr>
				<td>Categoria:</td>
				<td>
					<select name="categoria" id="categoria">
					<option>Selecione...</option>
					<%
						List<Categoria> listaCategorias = (List<Categoria>) request.getAttribute("listaCategorias");
						for(Categoria item : listaCategorias) {
							if(item.getId() == cargo.getCategoria().getId()){
								out.print("<option selected value="+item.getId()+">"+item.getDescricao()+"</option>");
							} else {
							out.print("<option value="+item.getId()+">"+item.getDescricao()+"</option>");
							}
						}
					%>
					</select>
				</td>
			</tr>
			<tr>
				<td>Subcategoria:</td>
				<td><select name="subcategoria" id="subcategoria"></select></td>
			</tr>
			<tr>
				<td>Situação:</td>
				<td>
					<%
					if((cargo.getSituacao() == null) || (cargo.getSituacao() != null && cargo.getSituacao().equals(SituacaoEnum.ATIVO))) {
						out.print("<input type='radio' name='situacao' value='Ativo' checked> Ativo");
						out.print("<input type='radio' name='situacao' value='Inativo'> Inativo");
					} else {
						out.print("<input type='radio' name='situacao' value='Ativo'> Ativo");
						out.print("<input type='radio' name='situacao' value='Inativo' checked> Inativo");
					} 
					
					%>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Salvar">
				</td>				
			</tr>
		</table>
	</form>
</body>
</html>
<script>
$( document ).ready(function() {
	var carregar_select = function (obj){
		var idCategoria = obj;
		if(obj !== undefined)
			idCategoria = obj;
		else
			idCategoria = $('#categoria').val();
		var idSub = $('#subid').val();
		 	if(idCategoria !== 'Selecione...') {
		 	 $.ajax({
		 	 url: "subcategoriaServlet?idCat=" + idCategoria,
			 async: false, 
			 success: function(result) {
			  	var lista = $.parseJSON(result);
			  	// Limpa o conteúdo do select |
			  	$('select[name="subcategoria"]').children().remove();
			  	var opcoes = "";
				// Popula o select
			  	for(var i = 0; i < lista.length; i++) {
				  	if((idSub !== undefined || idSub !== '') && idSub == lista[i].id)
			  	    	opcoes += "<option value='" + lista[i].id + "' selected>" + lista[i].descricao + "</option>";
			  	    	else
			  	    		opcoes += "<option value='" + lista[i].id + "'>" + lista[i].descricao + "</option>";
			  	}
			  	$( 'select[name="subcategoria"]' ).append( opcoes );
			 },
			 error: function (request, status, error) {
			        alert(request.responseText);
			 }
		 });
		}
	}
	carregar_select();
	$("#categoria").change(function() {
		if($(this).val() !== 'Selecione...'){
			carregar_select($(this).val());
		}
	});
	$( "#form" ).submit(function( event ) {
		if($("#categoria").val() == 'Selecione...'){
			alert('Preencha a categoria');
			return false;
			}
		});
});
</script>