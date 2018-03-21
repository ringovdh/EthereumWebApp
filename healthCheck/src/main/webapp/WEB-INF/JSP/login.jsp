<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://goedBezig.be/tags'%>
<%@taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='login - Goed Bezig' />
</head>
<body>
	<v:menu />
	<div class="container">
		<div class="banner">
			<img src="images/banner.jpg"
				alt="Give a day - Goed Bezig banner afbeelding"
				title="Goed Bezig banner" />
		</div>
		<h1>Aanmelden</h1>

		<div id="mainWrapper">
			<div class="login-container">
				<div class="login-card">
					<div class="login-form">
						<c:url var="loginUrl" value="/login" />
						<form action="${loginUrl}" method="post" class="form-horizontal">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Ongeldige gebruikersnaam en paswoord.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>Je bent succesvol uitgelogd.</p>
								</div>
							</c:if>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="username"><i
									class="fa fa-user"></i></label> <input type="text" class="form-control"
									id="username" name="username" placeholder="Gebruikersnaam"
									required>
							</div>
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i
									class="fa fa-lock"></i></label> <input type="password"
									class="form-control" id="password" name="password"
									placeholder="Paswoord" required>
							</div>
							<br>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<div class="form-actions">
								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Log in">
							</div>
							<br>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<v:footer />
</body>
</html>