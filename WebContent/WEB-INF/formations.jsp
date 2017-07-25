<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="./header.jspf"%>

	<div id="titre">
		<h1>TP Web - Liste de formations</h1>
	</div>

<%@include file="./navigation.jspf"%>

	<div id="formations">
	<c:forEach items="${formations}" var="formation">
		   <div class="formationIndiv">
	            <h2>&nbsp;${formation.libelle}</h2>
	            <p>
	                ${formation.description}>
	            </p>
	            <ul>
	                <li>Date de début :<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="debut"/></li>
	                <li>Date de fin : <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="fin"/></li>
	            </ul>
	        </div>  
	</c:forEach>

	
	</div>
<%@include file="./footer.jspf"%>