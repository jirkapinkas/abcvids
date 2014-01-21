<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.title}</title>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-theme.min.css" />">

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

	<div class="container" style="width: 1000px;">

		<!-- Static navbar -->
		<div class="navbar navbar-default" role="navigation">
		<a style="padding:0;margin:0;position: absolute;left:-3px" class="navbar-brand" href="<c:url value="/" />"><img src="<c:url value="/resources/images/logo.png" />" alt="logo" title="logo" /></a>
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
					<li class="${param.currpage eq 'group-list' ? 'active' : '' }"><a href="<c:url value="/" />">Home</a></li>
					<c:if test="${param.groupShortName != null}">
						<li class="${param.currpage eq 'item-list' ? 'active' : '' }"><a href="<c:url value="/tutorial/${param.groupShortName}.html" />">${param.groupName}</a></li>
					</c:if>
					<c:if test="${param.itemShortName != null}">
						<li class="${param.currpage eq 'item' ? 'active' : '' }"><a href="<c:url value="/video/${param.itemShortName}.html" />">${param.itemName}</a></li>
					</c:if>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		
		<div style="padding-bottom: 60px;"></div>

		<div style="float: left;padding-right: 20px;width:180px;">
			<h3>Latest videos:</h3>
			<c:forEach items="${latestVideos}" var="item">
				<a href="<c:url value="/video/${item.shortName}.html" />">
					<table>
						<tr>
							<td style="padding-right: 5px">
								<img src="<c:url value="/resources/images/play.png" />" alt="play" title="play" />
							</td>
							<td>
								<strong style="color: black"><fmt:formatDate value="${item.createdDate}" pattern="M/d/yyyy"/>:</strong><br />
								${item.name}
							</td>
						</tr>
					</table>
				</a>
				<br />
			</c:forEach>
				<a href="<c:url value="/latest.html" />">All latest videos</a>
			<br /><br />
			${AdsenseBannerLeft}
		</div>

		<div style="float:right;width:790px;">