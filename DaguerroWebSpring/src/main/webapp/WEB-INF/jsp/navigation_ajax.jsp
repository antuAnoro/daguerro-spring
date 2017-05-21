<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Daguerro Fotógrafos</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="public/quienesSomos">Quienes somos</a></li>
			<li><a href="public/ejemplos">Ejemplos</a></li>
			<li><a href="public/tarifas">Tarifas</a></li>			
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${user_rol == 'admin'}">
   				<li><a href="#"><span class="glyphicon glyphicon-user"></span>Gestión usuarios</a></li>
			</c:if>			
			<li><a href="public/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
		</ul>
	</div>
</nav>