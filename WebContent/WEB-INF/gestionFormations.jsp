<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="./header.jspf"%>

	<div id="titre">
		<h1>TP Web - Gestion des formations</h1>
	</div>
	<div id="formations">
		<c:forEach items="${formations}" var="formation">
			<div class="formationIndiv">
				<form action="${pageContext.request.contextPath()}/GererFormations"
					method="POST">
					<input type="submit" name="supprimer" value="Supprimer" /> <input
						type="hidden" value="${formation.id}" name="id" />
				</form>
	
				<h2>&nbsp;${formation.libelle}</h2>
				<span>Date de début :<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="debut" /></span>
				<span>>Date de fin : <fmt:formatDate type="date" pattern="dd/MM/yyyy" value="fin" /></span>
			</div>
		</c:forEach>
	</div>
<%@include file="./footer.jspf"%>