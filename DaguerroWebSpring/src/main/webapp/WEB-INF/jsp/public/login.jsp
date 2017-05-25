<!--  Cargamos bootstrap -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"	rel="stylesheet">

<!--  Uso de taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form name='loginForm' action="<c:url value='/public/login' />" method="POST">
	<div class="form-group">
		<c:if test="${param.logout != null}">
			<label>Desconectado correctamente</label><br>
		</c:if>		
		<c:if test="${param.error != null}">
			<label class="has-error">Nombre de usuario o contraseña incorrectos</label><br>			
		</c:if>
		<label>Email address:</label> <input name="username" class="form-control" />
		<label>Password:</label> <input name="password" type="password" class="form-control" />
	</div>
	<button type="submit" class="btn btn-default" >Enviar</button>
</form>