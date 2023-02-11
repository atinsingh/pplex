package com.example.pragraplex;

import com.example.pragraplex.entity.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PragraPlexApplication {

    public static void main(String[] args) {
       ApplicationContext context=  SpringApplication.run(PragraPlexApplication.class, args);
        System.out.println("context.getBean(Car.class) = " + context.getBean(Car.class));
    }



}
