package com.appskimo.app.support.handler;

import com.appskimo.app.common.exception.OrderValidationException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new Response(e.getBindingResult().getFieldErrors());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object nullPointerException(SQLIntegrityConstraintViolationException e) {
        return new Response(String.format("뭐시 널이여? :: %s", e.getLocalizedMessage()));
    }

    @ExceptionHandler(OrderValidationException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public Object orderValidationException(OrderValidationException e) {
        return new Response(e.getMessage());
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class Response implements Serializable {
        private static final long serialVersionUID = -4957830252024818470L;
        private Map<String, Object> result = new HashMap<>();

        Response(String value) {
            result.put("msg", value);
        }

        Response(List<FieldError> errors) {
            for (FieldError error : errors ) {
                result.put(error.getField(), error.getDefaultMessage());
            }
        }
    }

}
