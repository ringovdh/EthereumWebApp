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
		<h1>Overzicht</h1>
		<p>
			Dossierreferentie: ${patient.referentie}
			<v:submenu />
		</p>
			<div class="panel panel-success">
				<div class="panel-heading">	
					Mijn gegevens:
				</div>
				<div class="panel-body">
					<table class="table table-hover">
						<tr>
							<td>Voornaam: </td>
							<td><b>${patient.voornaam}</b></td>
							<td>Naam: </td>
							<td><b>${patient.naam}</b></td>
						</tr>
						<tr>
							<td>Rijksregisternr: </td>
							<td><b>${patient.rijksregisternr}</b></td>
							<td> </td>
							<td></td>
						</tr>
						<tr>
							<td>Geboortedatum: </td>
							<td><b>${patient.geboortedatum}</b></td>
							<td>Geslacht: </td>
							<td><b>${patient.geslacht}</b></td>
						</tr>
					</table>
				</div>
			</div>
		<br>
		<c:choose>
			<c:when test="${check == false}">
				<div class="panel panel-danger">				
					<div class="panel-heading">	
						<p class="panel-title">Status in de blockchain: </p>
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
						<p class="panel-title">Status in de blockchain: </p>
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