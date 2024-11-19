package com.codingshuttle.sankalpProject.tutorial.configurations;


import com.codingshuttle.sankalpProject.tutorial.DB;
import com.codingshuttle.sankalpProject.tutorial.DevDB;
import com.codingshuttle.sankalpProject.tutorial.ProdDB;
import com.codingshuttle.sankalpProject.tutorial.entities.EmployeeEntity;
import com.codingshuttle.sankalpProject.tutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode" , havingValue = "development")
    public DB getDevDBBean(){
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode" , havingValue = "production")
    public DB getProdDBData(){
        return new ProdDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();

    }


}
