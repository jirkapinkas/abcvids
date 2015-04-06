<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" autoFlush="false" buffer="10240kb"%>
<%-- Do not remove autoFlush="false" buffer="10240kb" !!!!!!!! --%>
<%-- It's because of Ziplet - gzip compression --%>
<%-- JSP's out of the box perform auto-flush and it breaks Ziplet --%>

<%@ include file="taglib.jsp"%>

</div>
</div>

<div class="col-md-2 col-md-pull-10 col-sm-4 col-sm-pull-8">

		<!-- start share / subscribe etc. -->
			<div style="background-color: #f9f9f9;padding: 10px;margin-bottom: 10px;"> 
				<h4>${ShareBoxTitle}:</h4>
				<!-- rss button -->
				<a href="${RssUrl}" style="padding-bottom: 20px"><img src="<c:url value="/resources/images/rss.png" />" border="0" alt="rss" title="rss"></a><br />
			
				${ShareSubscribeBox}
				
			</div>
			
<%-- 			<div style="background-color: #f9f9f9;padding: 10px;margin-bottom: 10px;"> --%>
<%-- 				<h4>${SearchBoxTitle}:</h4> --%>
<%-- 				${GoogleSearchBox} --%>
<%-- 			</div> --%>
		<!-- end share / subscribe etc. -->

		<!-- start latest news etc. -->
		<div style="">

			<c:if test="${AdsenseBannerLeft != ''}">
				<div style="background-color: #f9f9f9;margin-bottom: 10px;padding:10px;">
					${AdsenseBannerLeft}
				</div>
			</c:if>
		</div> <!-- end latest news etc. -->

</div> <!-- end column -->

</div> <!-- end row -->


	<!-- footer -->

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

	<div class="row">
		<div class="col-md-12">
			<br><br>
			<footer>
				<hr />
				<p>${Copyright}</p>
				<p>This project on <a href="https://github.com/jirkapinkas/abcvids" target="_blank">GitHub</a></p>
				<p>${OtherProjects}
				</p>
			</footer>		
		</div>
	</div>

</div>
<!-- /container -->

</body>
</html>