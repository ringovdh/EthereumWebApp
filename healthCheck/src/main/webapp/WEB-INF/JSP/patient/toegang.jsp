<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='v' uri='http://healthCheck.be/tags'%>
<%@taglib prefix='s' uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='Toegangsbeheer - Health Check' />
</head>
<body>
	<v:menu />
	<div class="container">
		<h1>Toegangsbeheer</h1>
		<p>
			Dossierreferentie: RVdH090178
			<v:submenu />
		</p>
		<div class="panel panel-success">
			<div class="panel-heading">	
				<p class="panel-title">Volgende zorgverstrekkers hebben toegang tot mijn dossier: </p>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
               		<thead>
                   		<tr>
                       		<th>Rol</th>
                       		<th>Voornaam</th>
                       		<th>familienaam</th>
                       		<th>rizivnummer</th>
                       		<th>leesrecht</th>
                       		<th>schrijfrecht</th>
                       		<th width="80"></th>
                   		</tr>
               		</thead>
	               	<tbody>
						<c:forEach var="verstrekker" items="${dossier.verstrekkers}" varStatus="row">
							<tr>
								<td>${verstrekker.rol}</td>
	                        	<td>${verstrekker.naam}</td>
	                        	<td>${verstrekker.voornaam}</td>
	                       		<td>${verstrekker.rizivNr}</td>
	                       		<td>
	                       			<c:choose>
   										<c:when test="${verstrekker.leesRechten}">
     										Ja
									   	</c:when>
									   	<c:otherwise>
									     	Nee
									   	</c:otherwise>
									</c:choose>
								</td>
								<td>
	                       			<c:choose>
   										<c:when test="${verstrekker.schrijfRechten}">
     										Ja
									   	</c:when>
									   	<c:otherwise>
									     	Nee
									   	</c:otherwise>
									</c:choose>
								</td>
	                       		<td><a href="<c:url value='/verwijder-${verstrekker.verstrekker_id}' />" class="btn btn-danger custom-width">verstrekker verwijderen</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form:form method="POST" action="verstrekker/toevoegen" commandName="dossier">
					<form:hidden path="dossier_id" />
					<input class="btn btn-success custom-width" type="submit" value="verstrekker toevoegen" name="toevoegen"/>
				</form:form>				
			</div>
		</div>
	</div>
	<br>
	<v:footer />
</body>
</html>