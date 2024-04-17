package com.dailycodework.dsbrroom2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DsbrRoom2Application {

    public static void main(String[] args) {
        SpringApplication.run(DsbrRoom2Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }


}
