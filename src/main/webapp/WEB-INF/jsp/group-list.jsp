<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="false" buffer="512kb" %>
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

<security:authorize access="hasRole('ROLE_ADMIN')">

	<a href="/admin/group-form.html" class="btn btn-primary">add</a>
	
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
	<c:forEach items="${list}" var="group">
		<tr>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<td style="width:150px">
					<form action="/admin/group/delete.html" method="post" style="float:left;padding-right:5px;margin-top:7px">
						<input type="hidden" name="id" value="${group.id}" />
						<button class="btn btn-danger" onclick="del(this);return false;">delete</button>
					</form>
					
					<a href="/admin/group/edit.html?id=${group.id}" class="btn btn-primary" style="float:left;margin-top:7px">edit</a>
				</td>
			</security:authorize>
			<td><a href="${GroupUrlPart}/${group.shortName}.html"> <img
					alt="icon"
					src="<c:url value="/resources/images/${group.image}" />" />
					${group.name}
			</a></td>
		</tr>
	</c:forEach>
</table>


<jsp:include page="layout/footer.jsp" />
