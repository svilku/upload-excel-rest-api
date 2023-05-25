package org.design;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.design.model.MultiPartBody;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class UploadResourceTest {

    @ConfigProperty(name = "quarkus.resteasy.path")
    String apiContext;

//    @Test
    public void should_accept_uploaded_excel() {
        given()
                .when()
                .contentType("multipart/form-data")
                .accept("*/*")
//                .formParam("file", ClassLoader.getSystemResourceAsStream("data/Employee.xlsx"))
                .get(pathBuilder(apiContext, "upload", "excel-file"))
                .then()
//                .assertThat()
                .statusCode(200);
//                .body(containsString("Content-Disposition: form-data; name=\"file\""),
//                        containsString("Content-Disposition: form-data; name=\"fileName\""),
//                        containsString("EmployeeData.xlsx"));
    }

    private String pathBuilder(String... path) {
        return String.join("/", path);
    }

}