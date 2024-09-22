package org.springboot.jpa.santiago.backendchronoturner.dto.authenticationDTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AuthenticationExceptionResponse {
        //Atributos de AuthenticationExceptionResponse
    private Integer businessErrorCode;
    private String businessErrorDescription;
    private String error;
    private Set<String> validationErrors;
    private Map<String, String> errors;

    //Constructores de AuthenticationExceptionResponse
    //Asignadores de atributos de AuthenticationExceptionResponse (setters)
    //Lectores de atributos de AuthenticationExceptionResponse (getters)
    //Métodos de AuthenticationExceptionResponse
}
