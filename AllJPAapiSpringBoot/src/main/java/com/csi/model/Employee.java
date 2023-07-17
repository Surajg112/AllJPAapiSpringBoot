package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @NotNull
    private int empId;

    @Size(min = 2,message = "minimum 2 character required")
    private String empName;

    private double empSalary;

    @Column(unique = true)
    @Range(min = 1000000000L, max = 9999999999L, message = "should be 10 digit")
    private long empContactNumber;

    private String empAddress;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDOB;

    @Column(unique = true)
    @Email(message = "Enter proper email id")
    @NotBlank(message = "Email is mandatory")
    private String empEmailId;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]+$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, and one digit")
    private String empPassword;
}
