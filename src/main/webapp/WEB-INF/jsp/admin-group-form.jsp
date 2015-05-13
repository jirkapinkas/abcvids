<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="false" buffer="512kb" %>
<%-- Do not remove autoFlush="false" buffer="512kb" !!!!!!!! --%>
<%-- It's because of Ziplet - gzip compression --%>
<%-- JSP's out of the box perform auto-flush and it breaks Ziplet --%>

<%@ include file="layout/taglib.jsp"%>

<jsp:include page="layout/header.jsp">
	<jsp:param value="group-list" name="currpage" />
</jsp:include>

<h3>Group form:</h3>

<br />

<form:form commandName="group" cssClass="form-horizontal">
	<div class="form-group">
		<label class="col-md-2 control-label">Name:</label>
		<div class="col-md-5">
			<form:input path="name" cssClass="form-control" />
		</div>
	</div>

<c:if test="${group.shortName != ''}">
	<div class="form-group">
		<label class="col-md-2 control-label">Short name:</label>
		<div class="col-md-5">
			<form:input path="shortName" cssClass="form-control" />
		</div>
	</div>
</c:if>

	<div class="form-group">
		<label class="col-md-2 control-label">Keywords:</label>
		<div class="col-md-5">
			<form:input path="keywords" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-md-2 control-label">Short description:</label>
		<div class="col-md-5">
			<form:textarea path="seoDescription" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-md-2 control-label">Description:</label>
		<div class="col-md-5">
			<form:textarea path="description" cssClass="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-md-2 control-label">Icon:</label>
		<div class="col-md-5">
			<select class="image-picker show-html" name="image">
				<c:forEach items="${images}" var="image">
					<option data-img-src="/resources/images/${image}.png" value="${image}">Image ${image}</option>
				</c:forEach>
			</select>
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-5 col-md-offset-2">
			<input type="submit" class="btn btn-primary" value="save" />
		</div>
	</div>

</form:form>

<script>
$(document).ready(function () {
	$("select").imagepicker();
});
CKEDITOR.replace( 'description' );
</script>

<jsp:include page="layout/footer.jsp" />
