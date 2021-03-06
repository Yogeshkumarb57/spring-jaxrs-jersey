# REST APIs using JAX-RS, Spring Boot, Jersey + Swagger Documentation
JAX-RS REST APIs using spring boot, jersey as implementation, swagger for documentation

<h3>Required Dependencies :</h3>

	...
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.19.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	....
	<dependencies>
		<!-- provides all required dependencies for developing rest apis from JAX-RS -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jersey</artifactId>
		</dependency>

		<!-- for object to json conversion -->
		<dependency>
			<groupId>org.glassfish.jersey.media</groupId>
			<artifactId>jersey-media-json-jackson</artifactId>
			<version>2.25</version>
		</dependency>

		<!-- swagger annotations -->
		<dependency>
			<groupId>io.swagger</groupId>
			<artifactId>swagger-jersey2-jaxrs</artifactId>
			<version>1.5.20</version>
		</dependency>
	</dependencies>


<h3>Run Application :</h3>

--> Build applicaton from project root directory : <b>mvn clean install</b>

--> Start application from project root directory : 
<b>java -jar target/spring-jaxrs-0.0.1-SNAPSHOT.jar     OR     mvn spring-boot:run</b>


<h3>Test Application :</H3>

Hit the following urls

--> APIs available on http://localhost:8080/rest --- rest is a base path for apis

	Users API --> http://localhost:8080/rest/users

--> http://localhost:8080/rest/swagger.json --- for swagger json

--> http://localhost:8080 or http://localhost:8080/index.html --- for swagger ui 


<h3>Add Swagger UI</h3>

	Swagger ui files added separately from "https://github.com/swagger-api/swagger-ui/tree/master/dist" into directory "/src/main/resources/static"
	
<b>Update SwaggerUIBundle({url: ${swagge_json_url} ...}) to swagger json url</b>

SwaggerUIBundle({
        url: location.protocol + "//" + location.hostname + (location.port && ":" + location.port)+ "/rest/swagger.json",
       ...})
