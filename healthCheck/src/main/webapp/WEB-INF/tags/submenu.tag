<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='s' uri='http://www.springframework.org/security/tags'%>
<header>
	<div class="container">
		<div class="glyphicon glyphicon-menu-hamburger"></div>
		<div class="navigation-wrapper">
			<nav>
				<ul class="navigation-items">
					<li><a href="<c:url value='/patient?dossier=${dossier.dossier_id}'/>">Algemeen</a></li>
					<li><a href="<c:url value='/patient/consultaties?dossier=${dossier.dossier_id}'/>">Consultaties</a></li>
					<li><a href="<c:url value='/patient/toegang?dossier=${dossier.dossier_id}'/>">Toegangsbeheer</a></li>	
				</ul>
			</nav>
		</div>
	</div>
</header>