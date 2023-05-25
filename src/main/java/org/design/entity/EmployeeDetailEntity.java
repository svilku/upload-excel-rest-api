package org.design.entity;

import com.poiji.annotation.ExcelCellName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Entity
public class EmployeeDetailEntity {

    @Id
    @Column(name = "employee_id", nullable = false)
    @ExcelCellName("EMPLOYEE ID")
    private long employeeId;

    @ExcelCellName("EMPLOYEE NAME")
    @Column(name = "employee_name")
    private String employeeName;

    @ExcelCellName("EMPLOYEEAGE")
    @Column(name = "employee_age")
    private long employeeAge;

    @ExcelCellName("COUNTRY_OF_BIRTH")
    @Column(name = "country_of_birth")
    private LocalDate countryOfBirth;

    @Column(name = "date_time")
    private Instant dateTime;
}
