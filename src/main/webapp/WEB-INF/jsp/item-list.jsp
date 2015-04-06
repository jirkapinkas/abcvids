<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="false" buffer="512kb" session="false" %>
<%-- Do not remove autoFlush="false" buffer="512kb" !!!!!!!! --%>
<%-- It's because of Ziplet - gzip compression --%>
<%-- JSP's out of the box perform auto-flush and it breaks Ziplet --%>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="${group.name}" name="title" />
	<jsp:param value="${group.shortName}" name="groupShortName"/>
	<jsp:param value="${group.name}" name="groupName"/>
	<jsp:param value="item-list" name="currpage" />
	<jsp:param value="${group.keywords}" name="seoKeywords"/>
	<jsp:param value="${group.seoDescription}" name="seoDescription"/>
</jsp:include>

<h1><img src="<c:url value="/resources/images/${group.image}" />" alt="icon" /> ${group.name}</h1>

<p>${AdsenseBannerTop}</p>

<table class="table">
	<c:forEach items="${group.items}" var="item">
		<tr>
			<td>
				<a href="<c:url value="/${ItemUrlPart}/${item.shortName}.html" />"> 
					<img src="<c:url value="/resources/images/${item.image}" />" style="float:left;padding-right: 10px;" />
					${item.name} 
				</a>
				<br />
				${item.seoDescription}
			</td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="layout/footer.jsp" />
