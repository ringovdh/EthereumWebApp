<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='v' uri='http://goedBezig.be/tags'%>
<%@taglib prefix='s' uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='Overzicht groepen - Goed Bezig' />
</head>
<body>
	<v:menu />
	<div class="container">
		<h1>Overzicht van mijn groepen</h1>
		<p>
			Lid van de organizatie: <b>${student.organization.name}</b>
		</p>
		<div class="panel-group" id="accordion">
			<c:forEach items='${student.groups}' var='group'>
				<div class="panel panel-default accordion-panel">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapse1">${group.name}</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse in">
						<div class="panel-body">

							<p>Andere studenten in deze groep</p>

							<c:forEach items='${group.students}' var='stdnt'>
								<div class="col-xs12 col-md-9">
									<ul>
										<li>${stdnt.userName}</li>
									</ul>
									<br>
								</div>
								<div class="col-xs12 col-md-3">
									<spring:url var='url' value='/assessment'>
										<spring:param name='owner_id' value='${stdnt.id}' />
										<spring:param name='group_id' value='${group.id}' />
										<spring:param name='author_id' value='${student.id}' />
									</spring:url>

									<a href="${url}" class="btn btn-success">Toon assessment</a>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<v:footer />
</body>
</html>