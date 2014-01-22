<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" %>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="${item.name}" name="title" />
	<jsp:param value="${item.group.shortName}" name="groupShortName"/>
	<jsp:param value="${item.group.name}" name="groupName"/>
	<jsp:param value="${item.shortName}" name="itemShortName"/>
	<jsp:param value="${item.name}" name="itemName"/>
	<jsp:param value="item" name="currpage" />
	<jsp:param value="${item.keywords}" name="seoKeywords"/>
	<jsp:param value="${item.seoDescription}" name="seoDescription"/>
</jsp:include>

<h1><img src="<c:url value="/resources/images/${item.image}" />" alt="video" title="video" /> ${item.name}</h1>

<p>${AdsenseBannerTop}</p>

<c:if test="${item.url != null && item.url != ''}">
	<iframe width="750" height="411" src="//www.youtube.com/embed/${item.url}" frameborder="0" allowfullscreen></iframe>
	<h2>Annotation:</h2>
</c:if>

<p>${item.description}</p>

<p></p>

${Disqus}

<jsp:include page="layout/footer.jsp" />
