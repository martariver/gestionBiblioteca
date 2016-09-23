<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>BIBLIOTECA</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	type="text/css" rel="stylesheet" />
	
	<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>  
</head>
<body class="container-fluid"> 
	<header class="row"> 
	<h1 class="col-xs-12">IPARTEK - BIBLIOTECA</h1> 
	<nav>
		<ul class="nav nav-tabs">
  			<li role="presentation"><a href="<c:url value='/usuarios'/>">USUARIOS</a></li>
  			<li role="presentation"><a href="<c:url value='/libros'/>">LIBROS</a></li>
		</ul>
	</nav>
   	  	
	
	
	
	</header>
	