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
		uw rijksregisternummer is ${patient.rijksregisternr} <br> <br>
		<form:form method="POST" action="patient/bewaren" commandName="patient">
		<form:hidden path = "id" value = "${patient.id}"/>
			<div class="panel panel-success">
				<div class="panel-heading">	
					<form:label path='dossier.huisarts' class="panel-title">Mijn huisarts: </form:label>
				</div>
				<div class="panel-body">
					<form:input path='dossier.huisarts'/>
				</div>
			</div>
			<br>
			<input type="submit" value="Bewaren" name="save"/>
		</form:form>
		<br>
	</div>
	<br>
	<v:footer />
</body>
</html>