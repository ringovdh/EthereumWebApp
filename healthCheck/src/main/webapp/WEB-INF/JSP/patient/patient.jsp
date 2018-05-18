<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='v' uri='http://healthCheck.be/tags'%>
<%@taglib prefix='s' uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='Mijn overzicht - Health Check' />
</head>
<body>
	<v:menu />
	<div class="container">
		<h1>Mijn overzicht</h1>
		<p>
			welkom <b>${patient.voornaam}</b>
		</p>
			<div class="panel panel-success">
				<div class="panel-heading">	
					Mijn rijksregisternummer:
				</div>
				<div class="panel-body">
					${patient.rijksregisternr}
				</div>
			</div>
			<br>
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
                        		<th width="100"></th>
                    		</tr>
                		</thead>
	                	<tbody>
							<c:forEach var="verstrekker" items="${dossier.verstrekkers}" varStatus="row">
								<tr>
	                        		<td>${verstrekker.rol}</td>
	                        		<td>${verstrekker.naam}</td>
	                        		<td>${verstrekker.voornaam}</td>
	                        		<td>${verstrekker.rizivNr}</td>
	                        		<td><a href="<c:url value='/verwijder-${verstrekker.verstrekker_id}' />" class="btn btn-danger custom-width">delete</a></td>
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
			<br>
		<br>
		<c:choose>
			<c:when test="${check == false}">
				<div class="panel panel-danger">				
					<div class="panel-heading">	
						<p class="panel-title">Status in blockchain: </p>
					</div>
					<div class="panel-body">
						<img alt="invalid" src="images\invalid_check.png">
						<p>De huidige status is niet gelijk aan de blockchain status!</p>
					</div>
					<form:form method="POST" action="patient/bewaren" commandName="dossier">
						<form:hidden path="dossier_id" />
						<input type="submit" value="Status valideren" name="save"/>
					</form:form>
				</div>
			</c:when>
			<c:otherwise>
				<div class="panel panel-succes">
					<div class="panel-heading">	
						<p class="panel-title">Status in blockchain: </p>
					</div>
					<div class="panel-body">
						<img alt="valid" src="images\valid_check.png">
						<p>De huidige status is gelijk aan de blockchain status!</p>
					</div>
				</div>
			
			</c:otherwise>
		</c:choose>
	</div>
	<br>
	<v:footer />
</body>
</html>