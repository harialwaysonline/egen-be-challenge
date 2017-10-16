package com.egen.weightanalyzer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.Serializable;

@ControllerAdvice
public class WAExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(AlertNotFoundException.class)
    public final ResponseEntity<WAError>  alertNotFoundException(AlertNotFoundException alertNotFoundException){

        WAError response = new WAError();
        response.setErrorCode("1001");
        response.setErrorDesc(alertNotFoundException.getMessage());

        return new ResponseEntity<WAError>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MetricsNotFoundException.class)
    public final ResponseEntity<WAError>  metricsNotFoundException(MetricsNotFoundException metricsNotFoundException){

        WAError response = new WAError();
        response.setErrorCode("1002");
        response.setErrorDesc(metricsNotFoundException.getMessage());
        return new ResponseEntity<WAError>(response, HttpStatus.NOT_FOUND);
    }

}
class WAError implements Serializable{

    private static final long serialVersionUID = -7263065099069485031L;
    private String errorCode;
    private String errorDesc;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }
}