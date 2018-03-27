<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='s' uri='http://www.springframework.org/security/tags'%>
<header>
	<div class="container">
		<div class="logo">
			<a href="<c:url value='/'/>"><img src="images/logo-MMD.png"
				alt="logo Give a Day"></a>
		</div>
		<div class="glyphicon glyphicon-menu-hamburger"></div>
		<div class="navigation-wrapper">
			<nav>
				<ul class="navigation-items">
				<li><a href="<c:url value='/patient'/>">mijn overzicht</a></li>
					<s:authorize access='isAuthenticated ()'>
						<li >
							<form method='post' action='<c:url value="/logout"/>'id='logoutform'>
								
								<input type='submit' value='Uitloggen' class="btn btn-block btn-primary btn-default">
								<s:csrfInput />
							</form>
						</li>

					</s:authorize>
					<s:authorize access='isAnonymous()'>
						<li><span class="btn btn-block btn-primary btn-default"><a href="<c:url value='/login'/>">Inloggen</a></span></li>
					</s:authorize>
					
				</ul>
			</nav>
		</div>
	</div>
</header>