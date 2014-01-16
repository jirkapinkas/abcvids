<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="SQL video categories" name="title" />
	<jsp:param value="group-list" name="currpage" />
</jsp:include>

<h1>SQL video categories:</h1>

<table class="table">
	<c:forEach items="${list}" var="group">
		<tr>
			<td><a href="tutorial/${group.shortName}.html"> ${group.name} </a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="layout/footer.jsp" />