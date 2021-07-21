<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Farmaci</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/farmacia.css" rel="stylesheet">
</head>
<body>
    <section class="header">
        <a href="/farmacia" class="title"><h1>Elenco Farmaci</h1></a>
    </section>
    <div class="logout-button">
        <a href="/farmacia/logout"><button class="button">Logout</button></a>
    </div>
    <c:if test="${not empty farmaci}">
        <div class="elencoFarmaci">
            <table>
                <tr>
                    <th>Nome</th>
                    <th>ID</th>
                    <th>Quantità</th>
                    <th>Scadenza</th>
                </tr>
                <c:forEach var="entry" items="${farmaci}">
                    <tr>
                        <td>
                            <c:out value="${entry.key.nome}" />
                        </td>
                        <td>
                            <c:out value="${entry.key.id}" />
                        </td>
                        <td>
                            ${entry.value.quantita}&emsp;

                        </td>
                        <td>
                            <fmt:formatDate value="${entry.value.scadenza}" pattern="dd/MM/yyyy" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</body>
</html>