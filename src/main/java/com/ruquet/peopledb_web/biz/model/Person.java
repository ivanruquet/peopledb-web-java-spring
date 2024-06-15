package com.ruquet.peopledb_web.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Last Name can not be Empty")
    private String lastName;

    @NotBlank(message = "First Name can not be Empty")
    private String firstName;

    @Past(message = "The Date of your Birthday must be in the past")
    @NotNull(message = "Please enter a valid Date")
    private LocalDate dob;

    @DecimalMin(message = "Salary must be more than 1000", value = "1000")
    @NotNull
    private BigDecimal salary;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Please enter a valid email")
    private String email;


}
