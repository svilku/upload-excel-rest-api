package org.design.service;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.design.entity.EmployeeDetailEntity;
import org.design.model.MultiPartBody;
import org.design.model.UploadResponse;
import org.design.repo.EmployeeRepository;

import java.util.List;

@ApplicationScoped
@Slf4j
public class UploadService {

    @Inject
    EmployeeRepository employeeRepository;

    public UploadResponse uploadExcelFile(MultiPartBody multiPartBody) {
        List<EmployeeDetailEntity> employeeDetailEntities =
                Poiji.fromExcel(multiPartBody.inputStream, PoijiExcelType.XLSX, EmployeeDetailEntity.class);

        log.info("Employee data : " + employeeDetailEntities);

        employeeRepository.saveEmployeeData(employeeDetailEntities);

        return UploadResponse.builder()
                .response("The file has been uploaded successfully").build();
    }
}
