<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="${group.name}" name="title" />
</jsp:include>

<h1>${group.name}</h1>

<table class="table">
	<c:forEach items="${group.items}" var="item">
		<tr>
			<td>
				<img src="<c:url value="/resources/images/play.png" />" alt="video" title="video" style="float:left;padding-right: 10px;" />
				
				<a href="<c:url value="/video/${item.shortName}.html" />"> ${item.name} </a>
				<br />
				${item.seoDescription}
			</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="layout/footer.jsp" />
