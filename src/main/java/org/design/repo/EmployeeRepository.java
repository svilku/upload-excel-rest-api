package org.design.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.design.entity.EmployeeDetailEntity;

import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepositoryBase<EmployeeDetailEntity, Long> {

    @Transactional
    public void saveEmployeeData(List<EmployeeDetailEntity> employeeDetailEntities) {
        persist(employeeDetailEntities);
    }

}
