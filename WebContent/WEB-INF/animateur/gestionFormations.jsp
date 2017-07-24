<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page  import ="fr.eni_ecole.tpweb.bean.*, java.util.*, java.text.*" %>
	
	<div id="listeFormations">
		<form id="gestionFormations" action="<%=request.getContextPath()%>/animateur/gestionFormations" method="post">
			<c:forEach var="formations" items="${listeFormations}">
					<div class="formationEntete">
						<span class="formationId" class="hidden">${formation.id}</span>
						<label id="formationLibelle">${formation.libelle}</label>
						<span id="formationDate"><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${formation.dateDebut}"/></span>
						<span id="formationDate"><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${formation.dateFin}"/></span>
						<input type="submit" name="bSupprimer_${formation}" value="Supprimer" />
						<input type="submit" name="bModifier_${formation}" value="Modifier" />
					</div>	
			</c:forEach>
			<input type="submit" name="bAjouter" value="Ajouter"/>
		</form>
	</div>