<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>

<a href="logout">Logout</a>
<h1><spring:message code="welcome"/></h1>

<ol class="breadcrumb">
    <li><a href="service">Home</a></li>
    <li><a href="#">Library</a></li>
    <li class="active">Data</li>
</ol>

<div class="alert alert-success" role="alert">...</div>

<div class="progress">
    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
        <span class="sr-only">60% Complete (warning)</span>
    </div>
</div>

<table id="table_id" class="display">
    <thead>
        <tr>
            <th>Column 1</th>
            <th>Column 2</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Row 1 Data 1</td>
            <td>Row 1 Data 2</td>
        </tr>
        <tr>
            <td>Row 2 Data 1</td>
            <td>Row 2 Data 2</td>
        </tr>
    </tbody>
</table>

<button type="button" class="btn btn-default navbar-btn">OK</button>