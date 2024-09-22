package org.springboot.jpa.santiago.backendchronoturner;

import org.springboot.jpa.santiago.backendchronoturner.interceptors.UserCreationDeletionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
        //Atributos de InterceptorConfig
    @Autowired  //No es necesario usar @Qualifier, dado que es la única implementación
    private UserCreationDeletionInterceptor userInterceptor;

    //Constructores de InterceptorConfig
    //Asignadores de atributos de InterceptorConfig (setters)
    //Lectores de atributos de InterceptorConfig (getters)
        //Métodos de InterceptorConfig
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/api/user", "/api/user/delete/**") ;
    }
}
