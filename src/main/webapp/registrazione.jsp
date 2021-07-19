<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/clienti.css" rel="stylesheet">
      <%@ include file="parts/header.jsp" %>  
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="email" class="form-control" placeholder="Email"
                                autofocus="true"></form:input>
                    <form:errors path="email"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="nome">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="nome" class="form-control" placeholder="Nome"
                                autofocus="true"></form:input>
                    <form:errors path="nome"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="cognome">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="cognome" class="form-control" placeholder="Cognome"
                                autofocus="true"></form:input>
                    <form:errors path="cognome"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="dataDiNascita">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="date" path="dataDiNascita" class="form-control" placeholder="Data di Nascita"
                                autofocus="true"></form:input>
                    <form:errors path="dataDiNascita"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="codiceFiscale">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="codiceFiscale" class="form-control" placeholder="Codice Fiscale"
                                autofocus="true"></form:input>
                    <form:errors path="codiceFiscale"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Registrati</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
