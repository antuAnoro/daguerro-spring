<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Daguerro Fotógrafos</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="public/home" target="main">Home</a></li>
			<li><a href="public/quienesSomos" target="main">Quienes somos</a></li>
			<li><a href="public/ejemplos" target="main">Ejemplos</a></li>
			<li><a href="public/tarifas" target="main">Tarifas</a></li>		
			<li><a href="http://www.marca.com" target="main">Marca</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<sec:authorize access="hasRole('ADMIN')">				
   				<li><a href="#"><span class="glyphicon glyphicon-user"></span>Gestionar usuarios</a></li>
			</sec:authorize>			
			<li><a href="public/login" target="main"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
		</ul>
	</div>
</nav>