# Problem Statement
There was a need to expose a REST endpoint which accepts an excel file when we use Quarkus application.

1. Start quarkus application:```mvn compile quarkus:dev```
2. Path (GET request) : ```http://localhost:8888/upload-service/upload/excel-file```

# Steps
Refer the plant uml diagram

# Database
H2 database

# Core Libraries used
1. Poiji (created on top of Apache POI) i.e.
   
   ```<dependency>
   <groupId>com.github.ozlerhakan</groupId>
   <artifactId>poiji</artifactId>
   </dependency>
2. Quarkus Resteasy Multipart i.e.
   
   ```<dependency>
   <groupId>io.quarkus</groupId>
   <artifactId>quarkus-resteasy-multipart</artifactId>
   </dependency>
   
# Links
1. https://github.com/ozlerhakan/poiji
2. https://quarkus.io/guides/rest-client-multipart#:~:text=RESTEasy%20has%20rich%20support%20for,generally%20used%20to%20upload%20files.
