package org.springboot.jpa.santiago.backendchronoturner.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder*/
public class Error {    //Esta es una Error DTO con el mensaje personalizado de error
        //Atributos de Error
    private String errorName;
    private String message;
    private int status;
    private LocalDateTime date; //Este es el que genera el timestamp

    //Constructores de Error
        //Asignadores de atributos de Error (setters)
    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
        public void setMessage(String message) {
            this.message = message;
        }
            public void setStatus(int status) {
                this.status = status;
            }
                public void setDate(LocalDateTime date) {
                    this.date = date;
                }

        //Lectores de atributos de Error (getters)
    public String getErrorName() {
        return this.errorName;
    }
        public String getMessage() {
            return this.message;
        }
            public int getStatus() {
                return this.status;
            }
                public LocalDateTime getDate() {
                    return this.date;
                }

    //Métodos de Error
}
