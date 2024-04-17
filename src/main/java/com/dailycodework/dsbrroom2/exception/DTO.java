package com.dailycodework.dsbrroom2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
}
