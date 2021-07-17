<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Hello ${utente.nome}!</title>
</head>
<body>
    <h2 class="hello-title">Hello ${utente.nome}!</h2>

    <form:form action="/utente" method="post" modelAttribute="utente1">
        <form:label path="nome">Book Name: </form:label> <form:input type="text" path="nome"/>
        <input type="submit" value="submit"/>
    </form:form>
    <h2 class="hello-title">Hello ${utente1.nome}!</h2>
</body>
</html>