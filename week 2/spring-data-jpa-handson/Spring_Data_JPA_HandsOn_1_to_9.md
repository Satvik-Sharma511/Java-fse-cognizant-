# Spring Data JPA - Hands-on Exercises 1 to 9

## Hands on 1: Spring Data JPA - Quick Example

### Software Pre-requisites
*   MySQL Server 8.0
*   MySQL Workbench 8
*   Eclipse IDE for Enterprise Java Developers 2019-03 R
*   Maven 3.6.2

### Create a Eclipse Project using Spring Initializr
*   Go to [https://start.spring.io/](https://start.spring.io/)
*   Change Group as `com.cognizant`
*   Change Artifact Id as `orm-learn`
*   In Options > Description enter "Demo project for Spring Data JPA and Hibernate"
*   Click on menu and select "Spring Boot DevTools", "Spring Data JPA" and "MySQL Driver"
*   Click Generate and download the project as zip
*   Extract the zip in root folder to Eclipse Workspace
*   Import the project in Eclipse: `File > Import > Maven > Existing Maven Projects > Click Browse and select extracted folder > Finish`
*   Create a new schema `ormlearn` in MySQL database. Execute the following commands to open MySQL client and create schema.
    ```sql
    > mysql -u root -p
    mysql> create schema ormlearn;
    ```
*   In `orm-learn` Eclipse project, open `src/main/resources/application.properties` and include the below database and log configuration.
    ```properties
    # Spring Framework and application log
    logging.level.org.springframework=info
    logging.level.com.cognizant=debug
    
    # Hibernate logs for displaying executed SQL, input and output
    logging.level.org.hibernate.SQL=trace
    logging.level.org.hibernate.type.descriptor.sql=trace
    
    # Log pattern
    logging.pattern.console=%d{dd-MM-yy} %d{HH:mm:ss.SSS} %-20.20thread %5p %-25.25logger{25} %25M %4L %m%n
    
    # Database configuration
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
    spring.datasource.username=root
    spring.datasource.password=root
    
    # Hibernate configuration
    spring.jpa.hibernate.ddl-auto=validate
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    ```
*   Build the project using `mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050 -Dhttp.proxyUser=123456` command in command line
*   Include logs for verifying if `main()` method is called:
    ```java
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }
    ```
*   Execute the `OrmLearnApplication` and check in log if main method is called.

### SME Walkthrough Topics
1.  `src/main/java` - Folder with application code
2.  `src/main/resources` - Folder for application configuration
3.  `src/test/java` - Folder with code for testing the application
4.  `OrmLearnApplication.java` - Walkthrough the `main()` method.
5.  Purpose of `@SpringBootApplication` annotation
6.  `pom.xml`: Walkthrough all the configuration defined in XML file and open 'Dependency Hierarchy' to show the dependency tree.

### Country table creation
*   Create a new table country with columns for code and name:
    ```sql
    create table country(co_code varchar(2) primary key, co_name varchar(50));
    ```
*   Insert couple of records into the table:
    ```sql
    insert into country values ('IN', 'India');
    insert into country values ('US', 'United States of America');
    ```

### Persistence Class - `com.cognizant.ormlearn.model.Country`
*   Create new package `com.cognizant.ormlearn.model`
*   Create `Country.java`, then generate getters, setters and `toString()` methods.
*   Include `@Entity` and `@Table` at class level
*   Include `@Column` annotations in each getter method specifying the column name.
    ```java
    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.Id;
    import javax.persistence.Table;
    
    @Entity
    @Table(name="country")
    public class Country {
    
        @Id
        @Column(name="code")
        private String code;
    
        @Column(name="name")
        private String name;
    
        // getters and setters
        // toString()
    }
    ```
*   **Notes:**
    *   `@Entity` is an indicator to Spring Data JPA that it is an entity class for the application
    *   `@Table` helps in defining the mapping database table
    *   `@Id` helps is defining the primary key
    *   `@Column` helps in defining the mapping table column

### Repository Class - `com.cognizant.ormlearn.repository.CountryRepository`
*   Create new package `com.cognizant.ormlearn.repository`
*   Create new interface named `CountryRepository` that extends `JpaRepository<Country, String>`
*   Define `@Repository` annotation at class level
    ```java
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    import com.cognizant.ormlearn.model.Country;
    
    @Repository
    public interface CountryRepository extends JpaRepository<Country, String> {
    }
    ```

### Service Class - `com.cognizant.ormlearn.service.CountryService`
*   Create new package `com.cognizant.ormlearn.service`
*   Create new class `CountryService`
*   Include `@Service` annotation at class level
*   Autowire `CountryRepository` in `CountryService`
*   Include new method `getAllCountries()` method that returns a list of countries.
*   Include `@Transactional` annotation for this method
    ```java
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import javax.transaction.Transactional;
    import java.util.List;
    
    @Service
    public class CountryService {
        @Autowired
        private CountryRepository countryRepository;
        
        @Transactional
        public List<Country> getAllCountries() {
            return countryRepository.findAll();
        }
    }
    ```

### Testing in OrmLearnApplication.java
*   Include a static reference to `CountryService` in `OrmLearnApplication` class:
    ```java
    private static CountryService countryService;
    ```
*   Define a test method to get all countries from service:
    ```java
    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }
    ```
*   Modify `SpringApplication.run()` invocation to set the application context and the `CountryService` reference:
    ```java
    ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
    countryService = context.getBean(CountryService.class);
    testGetAllCountries();
    ```

---

## Hands on 2: Hibernate XML Config implementation walk through
SME to provide explanation on the sample Hibernate implementation available in the link below:
[TutorialsPoint Hibernate Examples](https://www.tutorialspoint.com/hibernate/hibernate_examples.htm)

**Explanation Topics:**
*   Explain how object to relational database mapping done in hibernate xml configuration file
*   Explain about following aspects of implementing the end to end operations in Hibernate:
    *   `SessionFactory`, `Session`, `Transaction`
    *   `beginTransaction()`, `commit()`, `rollback()`
    *   `session.save()`, `session.createQuery().list()`, `session.get()`, `session.delete()`

---

## Hands on 3: Hibernate Annotation Config implementation walk through
SME to provide explanation on the sample Hibernate implementation available in the link below:
[TutorialsPoint Hibernate Annotations](https://www.tutorialspoint.com/hibernate/hibernate_annotations.htm)

**Explanation Topics:**
*   Explain how object to relational database mapping done in persistence class file Employee
*   Explain about following aspects of implementing the end to end operations in Hibernate:
    *   `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`
    *   Hibernate Configuration (`hibernate.cfg.xml`): Dialect, Driver, Connection URL, Username, Password

---

## Hands on 4: Difference between JPA, Hibernate and Spring Data JPA

### Java Persistence API (JPA)
*   JSR 338 Specification for persisting, reading and managing data from Java objects
*   Does not contain concrete implementation of the specification
*   Hibernate is one of the implementation of JPA

### Hibernate
*   ORM Tool that implements JPA

### Spring Data JPA
*   Does not have JPA implementation, but reduces boiler plate code
*   This is another level of abstraction over JPA implementation provider like Hibernate
*   Manages transactions

**Hibernate Code Snippet:**
```java
/* Method to CREATE an employee in the database */
public Integer addEmployee(Employee employee){
   Session session = factory.openSession();
   Transaction tx = null;
   Integer employeeID = null;
   try {
      tx = session.beginTransaction();
      employeeID = (Integer) session.save(employee); 
      tx.commit();
   } catch (HibernateException e) {
      if (tx != null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
   return employeeID;
}
```

**Spring Data JPA Code Snippet:**
```java
// EmployeeRepository.java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}

// EmployeeService.java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```

---

## Hands on 5: Implement services for managing Country

### Explanation for Hibernate table creation configuration (`ddl-auto`)
*   `create` - drops existing tables data and structure, then creates new tables
*   `validate` - check if the table and columns exist or not, throws an exception if a matching table or column is not found
*   `update` - if a table does not exists, it creates a new table; if a column does not exists, it creates a new column
*   `create-drop` - creates the table, once all operations are completed, the table is dropped

```properties
# Hibernate ddl auto (create, create-drop, update, validate)
spring.jpa.hibernate.ddl-auto=validate
```

### Populate country table
Delete all the records in Country table and then use the below script to create the actual list of all countries in our world:
```sql
insert into country (co_code, co_name) values ("AF", "Afghanistan");
insert into country (co_code, co_name) values ("AL", "Albania");
insert into country (co_code, co_name) values ("DZ", "Algeria");
-- ... (Additional countries removed for brevity in this manual, run full script provided in prompt)
insert into country (co_code, co_name) values ("AX", "Åland Islands");
```

---

## Hands on 6: Find a country based on country code
*   Create new exception class `CountryNotFoundException` in `com.cognizant.ormlearn.service.exception`.
*   Create new method `findCountryByCode()` in `CountryService` with `@Transactional` annotation.
    ```java
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException();
        }
        return result.get();
    }
    ```
*   Include new test method in `OrmLearnApplication`:
    ```java
    private static void getAllCountriesTest() {
        LOGGER.info("Start");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country:{}", country);
        LOGGER.info("End");
    }
    ```
*   **NOTE:** SME to explain the importance of `@Transactional` annotation. Spring takes care of creating the Hibernate session and manages the transactionality when executing the service method.

---

## Hands on 7: Add a new country
*   Create new method in `CountryService`:
    ```java
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    ```
*   Include new `testAddCountry()` method in `OrmLearnApplication`:
    *   Create new instance of country with a new code and name.
    *   Call `countryService.addCountry()` passing the country created in the previous step.
    *   Invoke `countryService.findCountryByCode()` passing the same code used when adding a new country.
    *   Check in the database if the country is added.

---

## Hands on 8: Update a country based on code
*   Create a new method `updateCountry()` in `CountryService` with parameters `code` and `name`. Annotate this method with `@Transactional`.
    ```java
    @Transactional
    public void updateCountry(String code, String name) {
        Optional<Country> result = countryRepository.findById(code);
        if(result.isPresent()) {
            Country country = result.get();
            country.setName(name); // Update name using setter
            countryRepository.save(country); // Save updates
        }
    }
    ```
*   Include new test method in `OrmLearnApplication`, which invokes `updateCountry()` method passing a country's code and different name. Check database table if name is modified.

---

## Hands on 9: Delete a country based on code
*   Create new method `deleteCountry()` in `CountryService` with `@Transactional`:
    ```java
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }
    ```
*   Include new test method in `OrmLearnApplication` with following steps:
    *   Call the delete method based on the country code during the add country hands on.
    *   Check in database if the country is deleted.
