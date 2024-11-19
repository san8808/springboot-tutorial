package com.codingshuttle.sankalpProject.tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private long id;
    private String name;
    private LocalDate dateOfJoining;
    private Boolean isActive;


}
