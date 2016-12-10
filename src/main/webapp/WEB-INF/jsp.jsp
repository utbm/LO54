<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<!-- controle, iterations, tests, variables -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- formattage des donnees -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<p>Les parametres:</p>

<ul>
<c:forEach var="aParam" items="${param}">
  <li>un parametre :
    <c:out value="${aParam.key}"/> = <c:out value="${aParam.value}"/>
  </li>
</c:forEach>
</ul>

<c:choose>
  <c:when test="${param['question'] == 'oui'}">
     <p>OUI</p>
  </c:when>
  <c:otherwise>
     <p>NON</p>
  </c:otherwise>
</c:choose>

</body>
</html>