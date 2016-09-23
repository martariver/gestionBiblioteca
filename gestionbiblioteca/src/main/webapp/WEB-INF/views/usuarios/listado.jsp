<%@page import="com.ipartek.formacion.dao.persistencia.Usuario"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../includes/header.jsp"/>

<main>

	<a href="usuarios/addUsuario" 
		class="btn btn-info" role="button">
		<span class="glyphicon glyphicon-plus" aria-hidden="true">NUEVO</span>
	</a>

	
	 <% 
	List<Usuario>usuarios = (List<Usuario>)request.getAttribute("listado-usuarios");
	if((usuarios!=null) && (usuarios.size()>0)){
		%>
		
		

	<div class="panel panel-primary">
		<div class="panel-heading">LISTADO DE USUARIOS</div>
		<div class="panel-body">
			<p>Información de los usuarios de la biblioteca</p>
		</div>
		
		<table class="table">
			<tr>
			<th>NOMBRE</th>
			<th>APELLIDO</th>
			<th>FECHA NACIMIENTO</th>
			<th>EDITAR</th>
			<th>BORRAR</th>
		</tr>
		<% 
		for(Usuario usuario: usuarios){
			%>
			<tr>
				<td><%=usuario.getNombre() %></td>
				<td><%=usuario.getApellidos() %></td>
				<td><%=usuario.getfNacimiento() %></td>
				<td>
					<a href="usuarios/<%=usuario.getId() %>" class="btn btn-success" role="button">
					<span class="glyphicon glyphicon-pencil"></span>
					</a>
				</td>
				<td>
					<form action="usuarios/<%=usuario.getId()%>" method="post">
					<button type="submit" class="btn btn-danger">
						<span class="glyphicon glyphicon-remove"></span>
					</button>
					</form>
				</td>
			</tr>
				
		<%
		}
	}
		%>	
	
		</table>
	</div>
	
</main>
		