<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://goedBezig.be/tags'%>
<%@taglib prefix='s' uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html lang='nl'>
<head>
<v:head title='Assessments - Goed Bezig' />
<script type="text/javascript">
	function confSubmitSave(form) {
		if (confirm("Wil u de assessments bewaren, u kan deze later nog steeds herwerken.")) {
			form.submit();
		} else {
			alert("De assessments zijn niet bewaard!");
			window.history.back();
		}
	}
	function confSubmitClose(form) {
		if (confirm("Wil u de assessments bewaren en afsluiten, u zal deze later niet meer kunnen bewerken.")) {
			form.submit();
		} else {
			alert("De assessments zijn niet bewaard!");
			window.history.back();
		}
	}
</script>
</head>
<body>
	<v:menu />
	<div class="container">
		<h1>Dit zijn jouw assessments voor ${student.userName}</h1>
		<br>
		<form:form class="form-group" action="assessment/handleAssessments"
			method="POST" modelAttribute="assessment">
			<c:choose>
				<c:when test='${error != null}'>
					<div class="alert alert-danger">
						<p>${error}</p>
					</div>

				</c:when>

				<c:when test='${error == null}'>
					<br>
					<c:choose>
						<c:when test='${assessment.status != 2}'>
							<p>
								Hoe heeft <b>${student.userName}</b> het gedaan op de volgende
								vlakken? Geef een resultaat van 0 tot 10.
							</p>
						</c:when>
						<c:when test='${assessment.status == 2}'>
							<p>
								Zo heeft volgens jou <b>${student.userName}</b> het gedaan op de
								volgende vlakken? Je kan het resultaat niet meer wijzigen.
							</p>
						</c:when>
					</c:choose>
					<br>
					<table>

						<tr>
							<td><form:label path='score1'>enthousiasme en participatie: </form:label></td>
							<td><form:radiobuttons path='score1'
									items='${assessment.scores}' /></td>

						</tr>
						<tr>
							<td><form:label path='score2'>ideeën aanbrengen: </form:label></td>
							<td><form:radiobuttons path='score2'
									items='${assessment.scores}' /></td>
						</tr>
						<tr>
							<td><form:label path='score3'>Inhouden correct en duidelijk kunnen uitleggen: </form:label></td>
							<td><form:radiobuttons path='score3'
									items='${assessment.scores}' /></td>
						</tr>
						<tr>
							<td><form:label path='score4'>groep organiseren en sturen: </form:label></td>
							<td><form:radiobuttons path='score4'
									items='${assessment.scores}' /></td>
						</tr>
						<tr>
							<td><form:label path='score5'>precisie en nauwkeurigheid: </form:label></td>
							<td><form:radiobuttons path='score5'
									items='${assessment.scores}' /></td>
						</tr>
						<tr>
							<td><form:label path='score6'>afspraken respecteren: </form:label></td>
							<td><form:radiobuttons path='score6'
									items='${assessment.scores}' /></td>
						</tr>
						<tr class="row">
							<td><form:hidden path='id' /></td>
							<td><form:hidden path='studentId' /></td>
							<td><form:hidden path='authorId' /></td>
							<td><form:hidden path='groupId' /></td>
							<td><form:hidden path='status' /></td>
						</tr>
					</table>
					<c:choose>
						<c:when test='${assessment.status == 2}'>
							<input type='submit' value='bewaren' name='save'
								class='btn btn-success' disabled="disabled">
							<input type='submit' value='bewaren en sluiten' name='close'
								class='btn btn-success' disabled="disabled">
						</c:when>
						<c:when test='${assessment.status != 2}'>
							<input type='submit' value='bewaren' name='save'
								class='btn btn-success' onClick="confSubmitSave(this.form);">
							<input type='submit' value='bewaren en sluiten' name='close'
								class='btn btn-success' onClick="confSubmitClose(this.form);">
						</c:when>
					</c:choose>


				</c:when>
			</c:choose>
			<input type='submit' value='annuleren' name='cancel'
				class='btn btn-danger'>
		</form:form>
	</div>
	<v:footer />
</body>
</html>