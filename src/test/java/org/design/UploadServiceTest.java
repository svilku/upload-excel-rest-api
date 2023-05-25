package org.design;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.design.entity.EmployeeDetailEntity;
import org.design.model.MultiPartBody;
import org.design.repo.EmployeeRepository;
import org.design.service.UploadService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class UploadServiceTest {

    @Inject
    UploadService uploadService;

    @Inject
    EmployeeRepository employeeRepository;

    @Test
    public void should_save_employee_data() {
        uploadService.uploadExcelFile(new MultiPartBody(
                ClassLoader.getSystemResourceAsStream("data/EmployeeData.xlsx"), "EmployeeData.xlsx"));

        Assertions.assertEquals(5, employeeRepository.count());
    }
}