<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://healthCheck.be/tags'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='Index - Health Check' />
</head>
<body>
	<div class="container">
		
		<h1>Health Check </h1>
		<p>Beheer hier uw medisch dossier.</p>
		<div class="banner">
			<img src="images/banner.png"
				alt="Health Check - Health Check banner afbeelding"
				title="Health Check banner" />
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-4">
				<div class="panel panel-default home-panel">
					<h3>Burgers</h3>
					<p>U kan hier al uw medische gegevens beheren. U bepaald wie er toegang heeft tot uw gegevens</p>
					<a href="<c:url value='/patient'/>" class="btn btn-primary">Inloggen</a>
				</div>
			</div>
			<div class="col-xs-12 col-md-4">
				<div class="panel panel-default home-panel">
					<h2>Dokters</h2>
					<p>Dokters kunnen via dit portaal het globaal medisch dossier beheren.</p>
					<a href="<c:url value='/dokter/'/>" class="btn btn-primary">Inloggen</a>
				</div>
			</div>
			<div class="col-xs-12 col-md-4">
				<div class="panel panel-default home-panel">
					<h2>Verpleging</h2>
					<p>Verpleegkundigen kunnen via dit portaal het medicatieschema beheren.</p>
					<a class="btn btn-primary">Inloggen</a>
				</div>
			</div>
		</div>
		<v:footer />
</body>
</html>