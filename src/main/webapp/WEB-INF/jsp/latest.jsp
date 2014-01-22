<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="${LatestHeader}" name="title" />
	<jsp:param value="item-list" name="currpage" />
	<jsp:param value="${group.keywords}" name="seoKeywords"/>
	<jsp:param value="${group.seoDescription}" name="seoDescription"/>
</jsp:include>

<h1>${LatestHeader}:</h1>

<p>${AdsenseBannerTop}</p>

<table class="table">
	<c:forEach items="${items}" var="item">
		<tr>
			<td>
				<a href="<c:url value="/${ItemUrlPart}/${item.shortName}.html" />"> 
					<img src="<c:url value="/resources/images/${item.image}" />" alt="video" title="video" style="float:left;padding-right: 10px;" />
					${item.name} 
				</a>
				<br />
				${item.seoDescription}
			</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="layout/footer.jsp" />
