<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="false" buffer="512kb" %>
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

<security:authorize access="hasRole('ROLE_ADMIN')">

	<a href="/admin/item-form.html?groupId=${group.id}" class="btn btn-primary">add</a>
	
	<br /><br />

<script>
	function del(button) {
		BootstrapDialog.confirm({closable : "true", message : "Really delete?", callback : function(result){
			if(result) {
				$(button).parent().submit();
			}
		}});
	}
</script>

</security:authorize>

<table class="table">
	<c:forEach items="${group.items}" var="item">
		<tr>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<td style="width:150px">
					<form action="/admin/item/delete.html" method="post" style="float:left;padding-right:5px;margin-top:7px">
						<input type="hidden" name="id" value="${item.id}" />
						<input type="hidden" name="groupId" value="${group.id}" />
						<button class="btn btn-danger" onclick="del(this);return false;">delete</button>
					</form>
					
					<a href="/admin/item/edit.html?id=${item.id}&groupId=${group.id}" class="btn btn-primary" style="float:left;margin-top:7px">edit</a>
				</td>
			</security:authorize>
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
