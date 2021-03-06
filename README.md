<h1>ABCVids is the system which powers SQLVids</h1>

<p>My project <a href="http://www.sqlvids.com" target="_blank">SQLVids</a> uses this system to manage video tutorials.</p>

<h2>To run in development mode (using embedded HSQL database):</h2>

<p>
First create a WAR file (also recompiles GWT widgetset): <code>mvn package</code><br />
Run this application using embedded Jetty server: <code>mvn -P dev jetty:run -Dspring.profiles.active="dev"</code>
</p>

<p>This will start embedded Jetty server on port 8080 and you can access your application here: <code>http://localhost:8080</code></p>

<p>Administration is here: <code>http://localhost:8080/admin</code></p>

<h2>To deploy on Heroku:</h2>
<p>
first run: <code>mvn package</code><br />
next goto target directory and run: <code>heroku deploy:war --war abcvids.war --app YOUR_APP</code><br />
To deploy WAR to Heroku see this article: <a href="https://devcenter.heroku.com/articles/war-deployment" target="_blank">https://devcenter.heroku.com/articles/war-deployment</a><br />

You can use this user to login (name / password): <code>admin / admin</code>
</p>

<h2>My other projects:</h2>
<ul>
	<li>
		<a href="http://www.javavids.com" target="_blank" title="Java video tutorials">Java video tutorials</a> (free online tutorials)
	</li>
    <li>
		<a href="http://sitemonitoring.sourceforge.net/" target="_blank" title="Website monitoring software">Website monitoring software</a> (free OSS software)
	</li>
    <li>
		<a href="http://www.java-skoleni.cz" target="_blank" title="Java školené">Java školení</a> (in Czech)
	</li>
    <li>
		<a href="http://www.sql-skoleni.cz" target="_blank" title="Java školení">SQL školení</a> (in Czech)
	</li>
</ul>	