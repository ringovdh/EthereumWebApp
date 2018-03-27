<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://healthCheck.be/tags'%>
<%@taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='Registreren - Health Check' />
</head>
<body>
	<v:menu />
	<div class="container">
		<div class="banner">
			<img src="images/banner.png"
				alt="Health Check - Health Check banner afbeelding"
				title="Health Check banner" />
		</div>
		<h1>Registreren</h1>
		<p>
			Vul de volgende gegevens in:
		</p>
		<br>
		<form:form class="form-group" action="patient/registreren" method="POST" modelAttribute="patient">
			<c:choose>
				<c:when test='${error != null}'>
					<div class="alert alert-danger">
						<p>${error}</p>
					</div>

				</c:when>
			</c:choose>
			<table>
				<tr>
					<td><form:label path='naam'>naam: </form:label></td>
					<td><form:input path='naam'/></td>
				</tr>
				<tr>
					<td><form:label path='voornaam'>voornaam: </form:label></td>
					<td><form:input path='voornaam'/></td>
				</tr>
				<tr>
					<td><form:label path='rijksregisternr'>rijksregisternummer: </form:label></td>
					<td><form:input path='rijksregisternr'/></td>
				</tr>
				<tr>
					<td><form:label path='email'>email: </form:label></td>
					<td><form:input path='email'/></td>
				</tr>
				<tr>
					<td><form:label path='username: '>username: </form:label></td>
					<td><form:input path='username: '/></td>
				</tr>
				<tr>
					<td><form:label path='password: '>paswoord: </form:label></td>
					<td><form:input type="password" path='password: '/></td>
				</tr>
				<tr>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

				<div class="form-actions">
					<input type="submit" class="btn btn-block btn-primary btn-default" value="Log in">
				</div>
				
			</table>
		</form:form>
	</div>
	<v:footer />
</body>
</html>