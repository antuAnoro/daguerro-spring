<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Daguerro Fotógrafos</title>

<!-- Bootstrap -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->

<!-- CSS propio -->
<link href="/css/miEstilo.css" rel="stylesheet">

<!--  Uso de taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

</head>

<body>

	<!-- Incluyo la barra de navegación -->
	<%@include file="navigation_iframe.jsp"%>

	<!-- Incluyo la página principal -->
	<div class="container">	
		<!-- Comprobamos si estamos logados -->
		<sec:authorize var="anonimo" access="isAnonymous()" ></sec:authorize>
		<iframe id="main" name="main" src="${anonimo?'/public/home':'/user/welcome'}"></iframe>
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/js/jquery.js"></script>
</body>
</html>