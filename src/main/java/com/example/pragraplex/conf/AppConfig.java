package com.example.pragraplex.conf;

import com.example.pragraplex.entity.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    public Car car(@Value("${car.name}") String name){
        return Car.builder().carName(name).build();
    }
}
