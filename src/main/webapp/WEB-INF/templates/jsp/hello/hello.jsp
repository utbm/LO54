<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ include file="../util/taglibs.jsp" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title><tiles:insertAttribute name="title"/></title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width">
	<spring:url value="/bundle/main.css" var="cssUrl"/>
	<link rel="stylesheet" href="${cssUrl}">
	<style>
		body {
			padding-top: 50px;
			padding-bottom: 20px;
		}
	</style>

	<%--<script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>--%>
</head>
<body>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>

<spring:url value="/bundle/main.js" var="jsUrl"/>
<script src="${jsUrl}"></script>
</body>
</html>