package com.example.homeworkrestapi.utils.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundExeption extends RuntimeException {

    public TaskNotFoundExeption(String message) {
        super(message);
    }

}
