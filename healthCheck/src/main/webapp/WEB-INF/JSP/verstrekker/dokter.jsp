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
	<h1>Mijn dossiers</h1>
		<p>
			welkom <b>${dokter.voornaam} ${dokter.naam}</b>
		</p>
		<div class="panel panel-success">
				<div class="panel-heading">	
					<p class="panel-title">dossiers</p>
				</div>
				<div class="panel-body">
					<table class="table table-hover">
                		<thead>
                    		<tr>
                        		<th>Dossier</th>
                        		<th>Patient id</th>
                        		<th>Naam</th>
                        		<th width="100"></th>
                    		</tr>
                		</thead>
		                <tbody>
			                <c:forEach items="${dossiers}" var="dossier">
			                    <tr>
			                        <td>${dossier.dossier_id}</td>
			                        <td>${dossier.patient_id}</td>
			                        <td>${dossier.patient}</td>
			                        <td><a href="<c:url value='/patient/consultaties?dossier=${dossier.dossier_id}' />" class="btn btn-success custom-width">Open dossier</a></td>
			                    </tr>
			                </c:forEach>
		                </tbody>
            		</table>
            	</div>
        </div>
	</div>
	<br>
	<v:footer />
</body>
</html>