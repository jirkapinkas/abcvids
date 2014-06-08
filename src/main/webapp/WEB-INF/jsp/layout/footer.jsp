<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="taglib.jsp"%>

<br><br>
<footer>
	<hr />
	<p>${Copyright}</p>
	<p>This project on <a href="https://github.com/jirkapinkas/abcvids" target="_blank">GitHub</a></p>
	<p>${OtherProjects}
	</p>
</footer>		

</div> <!-- end content -->

		<!-- start latest news etc. -->
		<div style="float: left;width:180px;margin-right: 20px;">
			<div style="background-color: #f9f9f9;margin-bottom: 10px;padding:10px;">
				<h3>${TopLatestHeader}:</h3>
				<c:forEach items="${latestVideos}" var="item">
					<a href="<c:url value="/${ItemUrlPart}/${item.shortName}.html" />">
						<table>
							<tr>
								<td style="padding-right: 5px">
									<img src="<c:url value="/resources/images/${item.image}" />" alt="post" title="post" />
								</td>
								<td>
									<strong style="color: black"><fmt:formatDate value="${item.createdDate}" pattern="${DateFormat}"/>:</strong><br />
									${item.name}
								</td>
							</tr>
						</table>
					</a>
					<br />
				</c:forEach>
					<a href="<c:url value="/latest.html" />">${AllLatestLink}</a>
			</div>
			
			<c:if test="${AdsenseBannerLeft != ''}">
				<div style="background-color: #f9f9f9;margin-bottom: 10px;padding:10px;">
					${AdsenseBannerLeft}
				</div>
			</c:if>
		</div> <!-- end latest news etc. -->

		</div> <!-- end group left two columns -->

		<!-- start share / subscribe etc. -->
		<div style="float:right;width:350px">
			<div style="background-color: #f9f9f9;padding: 10px;margin-bottom: 10px;"> 
				<h4>${ShareBoxTitle}:</h4>
				<!-- rss button -->
				<a href="${RssUrl}" style="padding-bottom: 20px"><img src="<c:url value="/resources/images/rss.png" />" border="0" alt="rss" title="rss"></a><br />
			
				${ShareSubscribeBox}
				
			</div>
			
			<c:if test="${AdsenseBannerRight != ''}">
				<div style="background-color: #f9f9f9;padding: 10px;margin-bottom: 10px;"> 
					${AdsenseBannerRight}
				</div>
			</c:if>

			<div style="background-color: #f9f9f9;padding: 10px;margin-bottom: 10px;">
				<h4>${SearchBoxTitle}:</h4>

				${GoogleSearchBox}

			</div>
		</div>
		<!-- end share / subscribe etc. -->


</div>
<!-- /container -->

</body>
</html>