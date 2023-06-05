package org.design;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class UploadResourceTest {

    @ConfigProperty(name = "quarkus.resteasy.path")
    String apiContext;

    @Test
    public void should_accept_uploaded_excel() throws IOException {
        Path tempFilePath = getFilePath("/data/EmployeeData.xlsx");

        given()
                .multiPart("file", tempFilePath.toFile())
                .when()
                .get(pathBuilder(apiContext, "upload", "excel-file"))
                .then()
                .statusCode(200)
                .assertThat()
                .body(is("The file has been uploaded successfully"));
    }

    private Path getFilePath(String file) throws IOException {
        Path tempFilePath = Files.createTempFile("test", ".xlsx");
        FileInputStream fileInputStream = new FileInputStream(getClass().getResource(file).getFile());
        Files.copy(fileInputStream, tempFilePath, StandardCopyOption.REPLACE_EXISTING);
        return tempFilePath;
    }

    private String pathBuilder(String... path) {
        return String.join("/", path);
    }

}