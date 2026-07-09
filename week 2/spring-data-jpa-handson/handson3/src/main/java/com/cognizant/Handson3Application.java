package com.cognizant;

import com.cognizant.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Handson3Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Handson3Application.class);
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Handson3Application.class, args);
        employeeService = context.getBean(EmployeeService.class);
        
        System.out.println("Handson3 Application Started Successfully!");
        System.out.println("HQL and Native Queries have been successfully configured in EmployeeRepository.");
    }
}
