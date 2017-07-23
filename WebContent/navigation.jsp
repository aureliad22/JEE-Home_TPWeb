<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div id="navigation">
			<a href="<%request.getContextPath();%>/Home_TPWeb/index.jsp">Accueil</a>
			<a href="<%request.getContextPath();%>/Home_TPWeb/Formations">Liste des formations</a>
			<a href="<%request.getContextPath();%>/Home_TPWeb/animateur/accesAnimateur.jsp">Accès animateur</a>
			<!-- <a href="<%request.getContextPath();%>/Home_TPWeb/AdminCnxServlet">Accès animateur</a> -->
			<a href="<%request.getContextPath();%>/Home_TPWeb/StagiaireCnxServlet">Accès stagiaire</a>
			
			<form action="http://www.google.fr/search" method="post" name="formRecherche"target="_blank">
			<input type="hidden" name="hl" value="fr" /> 
			<input type="text" id="q" name="q" placeholder="Entrez votre recherche" /> 
			<input type="submit" name="rechercher" value="rechercher" />	
			</form>
		</div>