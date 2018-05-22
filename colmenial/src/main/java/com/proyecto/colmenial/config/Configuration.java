package com.proyecto.colmenial.config;

import com.proyecto.colmenial.services.ApuntesServices;
import com.proyecto.colmenial.services.AsignaturasServices;
import com.proyecto.colmenial.services.GradosServices;
import com.proyecto.colmenial.services.impl.ApuntesServicesImpl;
import com.proyecto.colmenial.services.impl.AsignaturasServicesImpl;
import com.proyecto.colmenial.services.impl.GradosServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
            }
        };
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public GradosServices getGradosService(){return new GradosServiceImpl();}

    @Bean
    public AsignaturasServices getAsignaturasService(){
        return new AsignaturasServicesImpl();
    }

    @Bean
    public ApuntesServices getApuntesService(){return  new ApuntesServicesImpl(); }
}
