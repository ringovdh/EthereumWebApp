<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='v' uri='http://healthCheck.be/tags'%>
<%@taglib prefix='s' uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='Mijn consultaties - Health Check' />
</head>
<body>
	<v:menu />
	<div class="container">
		<h1>Consultaties</h1>
		<p>
			Dossierreferentie: RVdH090178
			<v:submenu />
		</p>
		<div class="panel panel-success">
			<div class="panel-heading">	
				<p class="panel-title">Nieuwe consultatie: </p>
			</div>
			<form:form class="form-group" action="patient/bewaarItem?dossier=${dossier.dossier_id}" method="POST" modelAttribute="item">
				<div class="form-group ">
					<form:label class="control-label " path='omschrijving'>omschrijving:</form:label>
					<form:textarea class="form-control" path='omschrijving'/>

					<form:label class="control-label " path='medicatie'>medicatie: </form:label>
					<form:textarea class="form-control" path='medicatie'/>

					<form:label class="control-label " path='verstrekker'>uitgevoerd door: </form:label>
					<form:input class="form-control" path='verstrekker' value="${dossier.patient}"/>
				</div>
					<input class="btn btn-success custom-width" type="submit" value="consultatie toevoegen" name="toevoegen"/>
				
			</form:form>
		</div>	
			
		<div class="panel panel-success">
			<div class="panel-heading">	
				<p class="panel-title">Overzicht consultaties: </p>
			</div>
				<div class="panel-body">
					<table class="table table-hover">
	                	<thead>
	                    	<tr>
	                        	<th>Datum</th>
	                        	<th>Omschrijving</th>
	                        	<th>Voorschrift</th>
	                        	<th>Uitgevoerd door</th>
	                    	</tr>
	                	</thead>
		                <tbody>
							<c:forEach var="item" items="${dossier.items}" varStatus="row">
								<tr>
		                        	<td>${item.datum}</td>
		                        	<td>${item.omschrijving}</td>
		                        	<td>${item.medicatie}</td>
		                        	<td>${item.verstrekker}</td>
		                        <tr>
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