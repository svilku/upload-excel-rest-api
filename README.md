# Upload an Excel file in Rest API
We will use Quarkus application to create a Rest API.

1. This API accepts an Excel file
2. Then file will be mapped to an Entity
3. The Entity will be persisted in database

# Database
H2 database

#Core Libraries used
1. Poiji (created on top of Apache POI)
2. Quarkus Resteasy Multipart