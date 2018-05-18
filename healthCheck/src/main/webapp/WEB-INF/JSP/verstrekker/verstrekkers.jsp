<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='v' uri='http://healthCheck.be/tags'%>
<%@taglib prefix='s' uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='Verstrekker toevoegen - Health Check' />
</head>
<body>
	<v:menu />
	<div class="container">
		<h1>Verstrekker toevoegen</h1>
		<form:form method="POST" action="add" commandName="form">
		<table class="table table-hover">
        	<thead>
           		<tr>
                	<th>Rol</th>
                    <th>Voornaam</th>
                    <th>familienaam</th>
                    <th>rizivnummer</th>
                    <th>id</th>
                    <th width="100"></th>
                </tr>
            </thead>
	        <tbody>
				<c:forEach var="verstrekker" items="${form.verstrekkers}" varStatus="row">
					<tr>
	                	<td>${verstrekker.rol}</td>
	                    <td>${verstrekker.naam}</td>
	                    <td>${verstrekker.voornaam}</td>
	                    <td>${verstrekker.rizivNr}</td>
	                    <td><input type = "hidden" value="${verstrekker.verstrekker_id}" name ="verstrekker_id" ></td>                   
	                    <td><input class="btn btn-success custom-width" type="submit" value="voeg toe" name="add"/></td>
	                    <form:hidden path="dossier_id" />
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</form:form>
	</div>
	<br>
	<v:footer />
</body>
</html>