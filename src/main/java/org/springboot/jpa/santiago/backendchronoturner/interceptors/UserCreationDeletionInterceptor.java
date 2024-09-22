package org.springboot.jpa.santiago.backendchronoturner.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component  //Por defecto, se llama userCreationDeletionInterceptor, aunque se le puede cambiar el nombre
public class UserCreationDeletionInterceptor implements HandlerInterceptor {
        //Atributos de UserCreationDeletionInterceptor
    private static final Logger logger = LoggerFactory.getLogger(UserCreationDeletionInterceptor.class); //Para inyectar el Logger de esta clase

    //Constructores de UserCreationDeletionInterceptor
    //Asignadores de atributos de UserCreationDeletionInterceptor (setters)
    //Lectores de atributos de UserCreationDeletionInterceptor (getters)
        //Métodos de UserCreationDeletionInterceptor
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod controller = (HandlerMethod) handler;

        String methodName = controller.getClass().getSimpleName();
        switch (methodName){
            case "saveNewUser" -> this.logger.info("Getting out from method " + controller.getMethod().getName() + " which means that someone has signed up");
            case "deleteUser" -> this.logger.info("Getting out from method " + controller.getMethod().getName() + " after someone deleted their account");
        }
    }
}
