package org.springboot.jpa.santiago.backendchronoturner.controllers.exceptionControllers;

import org.springboot.jpa.santiago.backendchronoturner.dto.Error;
import org.springboot.jpa.santiago.backendchronoturner.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HandlerExceptionController {
    //Atributos de HandlerExceptionController
    //Constructores de HandlerExceptionController
    //Asignadores de atributos de HandlerExceptionController (setters)
    //Lectores de atributos de HandlerExceptionController (getters)
        //Métodos de HandlerExceptionController
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(NoHandlerFoundException e){
        Error error = new Error();  //Así como se envía un DTO, se puede enviar otro objeto serializable, como un Map
            error.setErrorName("Error: API rest not found");
            error.setMessage(e.getMessage());
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setDate(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({NullPointerException.class,
                       HttpMessageNotWritableException.class,
                       EntityNotFoundException.class})
    public Map<String, Object> userNotFoundException (Exception e) {   //Como devuelve un Map, y no un ResponseEntity, anotar con el tipo de error que devuelve
        Map<String, Object> error = new HashMap<>();  //Así como se envía un DTO, se puede enviar otro objeto serializable, como un Map
            error.put("errorName", "Entity instance not found");
            error.put("message", e.getMessage());
            error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            error.put("date", LocalDate.now());

        return error;
    }
}
