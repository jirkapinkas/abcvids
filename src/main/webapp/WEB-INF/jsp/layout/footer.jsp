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

	<style type="text/css">
		/* adBlockMessage */
		.adBlockMessage {position: fixed; bottom: 0; left: 0; right: 0; background: #fffd59; color: #222; font-size: 16px; padding: 2em 1em; z-index: 2010; box-shadow: 0 -1px 29px rgba(9,0,0,.78); font-weight: bold; text-align: center; }
		.adBlockMessage a {color: #222; text-decoration: none; padding: 0.6em 1em; margin-left: 1em; border: 2px solid #dad91a; background-color: #fff; }
		.adBlockMessage a:hover {border-color: #222; }
	</style>

	<script type="text/javascript" src="/resources/js/ads.js"></script>

	<div id="footer"></div>
	<script type="text/javascript">
		if( window.canRunAds === undefined ){
			// adblocker detected, show fallback
			document.write("<div class='adBlockMessage'><p>Please don't block advertisement. It's the only revenue we have and it keeps this website up and running (and free). Thank you.</p></div>");
			document.write("<style type='text/css'>#footer { margin-bottom: 80px !important}</style>");
		}
	</script>
	<noscript>
		<div class="adBlockMessage">
			<p>
				Please don't block advertisement. It's the only revenue we have and it keeps this website up and running (and free). Thank you.
			</p>
		</div>
		<style type="text/css">
			#footer {
				margin-bottom: 80px !important
			}
		</style>
	</noscript>


</div>
<!-- /container -->

</body>
</html>