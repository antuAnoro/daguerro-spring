<!--  Uso de taglib -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <form name='loginForm' action="<c:url value='j_spring_security_check' />" method="POST"> --%>
<form name='loginForm' action="<c:url value='/public/login' />" method="POST">
	<div class="form-group">
		<c:if test="${not empty error}">
			<label class="has-error">${error}</label>
		</c:if>
		<label>Email address:</label> <input name="username" class="form-control" />
		<label>Password:</label> <input name="password" class="form-control" />
	</div>
	<button type="submit" class="btn btn-default" >Enviar</button>
</form>