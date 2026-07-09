package com.cognizant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpringLearnApplication {

    public static void displayDate() {
        // Load the Spring Application Context from the XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        
        // Retrieve the SimpleDateFormat bean defined in the XML
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        
        try {
            // Parse the string to Date
            Date date = format.parse("31/12/2018");
            System.out.println("----------------------------------------");
            System.out.println("Parsed Date: " + date);
            System.out.println("----------------------------------------");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        displayDate();
    }
}
