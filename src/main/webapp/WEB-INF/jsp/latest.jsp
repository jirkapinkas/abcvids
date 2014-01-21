<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="Latest SQL video tutorials" name="title" />
	<jsp:param value="item-list" name="currpage" />
	<jsp:param value="${group.keywords}" name="seoKeywords"/>
	<jsp:param value="${group.seoDescription}" name="seoDescription"/>
</jsp:include>

<h1>Latest SQL video tutorials</h1>

<p>${AdsenseBannerTop}</p>

<table class="table">
	<c:forEach items="${items}" var="item">
		<tr>
			<td>
				<a href="<c:url value="/video/${item.shortName}.html" />"> 
					<img src="<c:url value="/resources/images/play.png" />" alt="video" title="video" style="float:left;padding-right: 10px;" />
					${item.name} 
				</a>
				<br />
				${item.seoDescription}
			</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="layout/footer.jsp" />
