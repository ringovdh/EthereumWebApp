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
		uw rijksregisternummer is ${patient.rijksregisternr}
		<br>
		<br>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h4 class="panel-title">
					Mijn huisarts
				</h4>
			</div>
			<div class="panel-body">
				<p>${patient.dossier.huisarts}</p>
			</div>
		</div>
		<br>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h4 class="panel-title">
					dossier gegevens (Ethereum)
				</h4>
			</div>
			<table class = "table">    
      			<tr>
         			<td>contractadres</td>
         			<td>${patient.dossier.contractaddress}</td>
      			</tr>
				<tr>
			    	<td>transactieadres</td>
			        <td>${patient.dossier.transactieaddress}</td>
			    </tr>
   </table>
		</div>
		<br>
		<a href="<c:url value='/patient/registreer'/>" class="btn btn-primary">Dossier bewaren</a>
		<br>
	</div>
	<br>
	<v:footer />
</body>
</html>