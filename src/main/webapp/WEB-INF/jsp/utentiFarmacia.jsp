<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Hello ${utente.nome}!</title>
</head>
<body>
    <h2 class="hello-title">Hello ${farmacista.nome}!</h2>
    <a href="utente">Utente</a>
</body>
</html>