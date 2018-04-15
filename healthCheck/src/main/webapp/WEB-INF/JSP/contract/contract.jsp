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
		<h1>Mijn contractgegevens</h1>

		<p> contractadres: ${contractaddress}</p>
		<p> transactieadres: ${transactionaddress}</p>
	</div>
	<br>
	<v:footer />
</body>
</html>