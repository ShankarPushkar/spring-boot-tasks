# spring-boot-tasks
1. Complete all the endpoints for CRUD operations on track-service
   Use h2-console to view in-memory data
2. Add an endpoint to search trackByName. Understand @Query and parameter passing to
    @Query
3. Generate API documentation using Swagger 2
4. Create custom exceptions TrackNotFoundException, TrackAlreadyExistsException in a
   com.stack....exceptions package. Perform appropriate exception handling and propagation
   back.
5. Running Logic on Startup in Spring. Create seed data to pre-fill the database with movie
   information whenever the application starts. Use both approaches:
   Approach 1: ApplicationListener<ContextRefreshedEvent>
   Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)

6.Global exception using Controller advice
7. Remove all hardcoded data from the application code to application.properties
   a) by using @Value.
   b) by using @PropertySource
   c) by using Environment
   d) by using @ConfigurationProperties
8. Add @Lombok
9. Create another service implementation TrackDummyServiceImpl. Use @Primary and
   @Qualifier annotations to specify which implementation to use.
10.Use @Profile to run the application with the existing service implementation, and the new
   TrackDummyServiceImpl implementation.
11.Swap in-memory H2 database with MySQL.
12.Create two additional properties file application-dev.properties that contains configuration for
   H2 and application-prod.properties that contains configurations for MySQL.
13.Use DevTools
14.Accutuator
