<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Benvenuto${nomeUtente}!</title>
      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
      <%@ include file="parts/header.jsp" %>  
</head>
<body>
    <h2 class="hello-title">Benvenuto${nomeUtente}!</h2>
    <a href="utente">Utente</a>
    <div class="${hide ? 'hide' : 'show'}"><a href="logout">Logout</a></div>
</body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</html>