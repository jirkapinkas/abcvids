<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="Group list" name="title" />
</jsp:include>

<h1>${item.name}</h1>

<p>${item.description}</p>


<jsp:include page="layout/footer.jsp" />
