#resource-server

This is a spring-boot micro service created to demo the use of spring security to secure API endpoints.
Bearer tokens are used to allow access to the endpoints.  
These tokens are checked using a remote authorization server, configured using spring RemoteTokenServices

The project uses MongoDB (which it expects to be available on `localhost:27017`)

To run the project:  
`./mvnw spring-boot:run`