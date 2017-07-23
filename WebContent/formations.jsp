<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, fr.eni_ecole.tpweb.bean.Formation, fr.eni_ecole.tpweb.tools.ManipDate" %>
<%@include file="/header.jsp"%>

	<div id="titre">
		<h1>TP Web - Liste de formations</h1>
	</div>

<%@include file="/navigation.jsp"%>

	<div id="formations">
	<% 
		List<Formation> listeFormations = (List<Formation>)request.getAttribute("formations");
		for(Formation f : listeFormations){
	%>
		<div class="formationIndiv">
			<h2>&nbsp;<%=f.getLibelle()%></h2>
			<p><%=f.getDescription()%></p>
			<ul>
				<li>Date de début : <%=ManipDate.dateAuFormatLong(f.getDateDebut())%></li>
				<li>Date de fin : <%=ManipDate.dateAuFormatLong(f.getDateFin())%></li>
			</ul>
		</div>		
	<% 
		} 
	%>
	
	</div>
<%@include file="/footer.jsp"%>