<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../util/taglibs.jsp" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <c:url value="/login" var="loginUrl"/>
        <form action="${loginUrl}" method="post">
            <c:if test="${param.error != null}">
                <p>
                    <div class="alert alert-danger" role="alert">Invalid username and password.</div>
                </p>
            </c:if>
            <c:if test="${param.logout != null}">
                <p>
                    <div class="alert alert-warning" role="alert">You have been logged out.</div>
                </p>
            </c:if>
            <p>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>
            </p>
            <p>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
            </p>
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <button type="submit" class="btn">Log in</button>
        </form>
    </body>
</html>
