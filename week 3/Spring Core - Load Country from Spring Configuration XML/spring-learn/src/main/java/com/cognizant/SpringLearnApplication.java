package com.cognizant;

import com.cognizant.springlearn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void displayCountry() {
        // Load the Spring Application Context from the XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Retrieve the Country bean defined in the XML
        Country country = context.getBean("country", Country.class);
        
        // Display country details
        LOGGER.debug("Country : {}", country.toString());
    }

    public static void main(String[] args) {
        displayCountry();
    }
}
