package com.dailycodework.dsbrroom2.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;


public class StudentAlreadyExistException extends RuntimeException{
    public StudentAlreadyExistException(String message) {
        super(message);
    }



}
