<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<h1>Bienvenido ${user.username}</h1>