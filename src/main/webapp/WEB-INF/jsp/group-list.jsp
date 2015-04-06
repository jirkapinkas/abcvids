<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="false" buffer="512kb" session="false" %>
<%-- Do not remove autoFlush="false" buffer="512kb" !!!!!!!! --%>
<%-- It's because of Ziplet - gzip compression --%>
<%-- JSP's out of the box perform auto-flush and it breaks Ziplet --%>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="${HomepageWelcomeHeader}" name="title" />
	<jsp:param value="group-list" name="currpage" />
	<jsp:param value="${HomepageSeoKeywords}" name="seoKeywords"/>
	<jsp:param value="${HomepageSeoDescription}" name="seoDescription"/>
</jsp:include>


<h1>${HomepageWelcomeHeader}:</h1>

<p>${HomepageWelcomeParagraph}</p>

<p>${AdsenseBannerTop}</p>

<table class="table">
	<c:forEach items="${list}" var="group">
		<tr>
			<td><a href="${GroupUrlPart}/${group.shortName}.html"> <img
					alt="icon"
					src="<c:url value="/resources/images/${group.image}" />" />
					${group.name}
			</a></td>
		</tr>
	</c:forEach>
</table>


<jsp:include page="layout/footer.jsp" />
