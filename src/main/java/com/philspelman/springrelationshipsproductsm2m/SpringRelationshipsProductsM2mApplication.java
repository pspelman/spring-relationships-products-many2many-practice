package com.philspelman.springrelationshipsproductsm2m;
//
//import com.philspelman.springrelationshipsproductsm2m.models.Employee;
//import com.philspelman.springrelationshipsproductsm2m.models.EmployeeIdentity;
//import com.philspelman.springrelationshipsproductsm2m.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import com.philspelman.springrelationshipsproductsm2m.repositories.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SpringRelationshipsProductsM2mApplication implements CommandLineRunner {
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringRelationshipsProductsM2mApplication.class, args);
//
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        employeeRepository.deleteAllInBatch();
//
//        Employee employee = new Employee(new EmployeeIdentity("E-123", "D-457"),
//                "Rajeev Badeev Threev",
//                "rajeev@badeev.com",
//                "+192-00999999");
//        employeeRepository.save(employee);
//    }
//}
@SpringBootApplication
public class SpringRelationshipsProductsM2mApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringRelationshipsProductsM2mApplication.class, args);

    }
}
