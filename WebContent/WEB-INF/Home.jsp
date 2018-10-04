<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Great Number Game</title>
</head>
<body>
	<% if(((boolean)session.getAttribute("correct"))==false || session.getAttribute("status") == null) { %>
	<h1>GUESS FROM 1-100</h1>
	<% } %>
	
	<h1><c:out value="${status}"/></h1>
	
	<%-- <% if(((String)session.getAttribute("status")) == "Too High") { %>
	<h1>Too High</h1>
	<% } %> --%>
	
	
	
	<div>
	<form method = "post" action = "">
	    <input type = "text" name = "guess"/>
	    <button>Please Work</button>
	</form>
	</div>
	
</body>
</html>