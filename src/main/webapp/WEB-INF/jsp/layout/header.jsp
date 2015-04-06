<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="false" buffer="10240kb"%>
<%-- Do not remove autoFlush="false" buffer="10240kb" !!!!!!!! --%>
<%-- It's because of Ziplet - gzip compression --%>
<%-- JSP's out of the box perform auto-flush and it breaks Ziplet --%>
<%@ include file="taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>${param.title}</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.min.css" />">
<script type="text/javascript" src="https://apis.google.com/js/plusone.js"></script>

<meta name="title" content="${param.title}">
<meta name="description" content="${param.seoDescription}">
<meta name="keywords" content="${param.seoKeywords}">
<meta name="robots" content="index, follow" />


<script src="<c:url value="/resources/js/jquery-2.0.3.min.js" />"></script>

<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

${GoogleSiteVerification}

</head>
<body>

${GoogleAnalytics}

	<div class="container">

		<!-- Static navbar -->
		<div class="navbar navbar-default" role="navigation">
		<a style="padding:0;margin:0;position: absolute;left:-3px" class="navbar-brand" href="<c:url value="/" />"><img src="<c:url value="/resources/images/${ImageSiteLogo}" />" alt="${SiteName}" title="${SiteName}" /></a>
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav" style="padding-left:114px">
					<li class="${param.currpage eq 'group-list' ? 'active' : '' }"><a href="<c:url value="/" />">${HomeButton}</a></li>
					<c:if test="${param.groupShortName != null}">
						<li class="${param.currpage eq 'item-list' ? 'active' : '' }"><a href="<c:url value="/${GroupUrlPart}/${param.groupShortName}.html" />">${param.groupName}</a></li>
					</c:if>
					<c:if test="${param.itemShortName != null}">
						<li class="${param.currpage eq 'item' ? 'active' : '' }"><a href="<c:url value="/${ItemUrlPart}/${param.itemShortName}.html" />">${param.itemName}</a></li>
					</c:if>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		
		<div style="padding-bottom: 60px;"></div>		
		

<div class="row"> <!--  start row -->

<div class="col-md-10 col-md-push-2 col-sm-8 col-sm-push-4">
<div style="margin-left:10px">