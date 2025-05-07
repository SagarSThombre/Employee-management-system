package net.demo.springboot;

import net.demo.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeerepository;
	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Sagar");
//		employee.setLastName("Thombare");
//		employee.setEmailId("sagar@gmail.com");
//		employeerepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Kartik");
//		employee1.setLastName("Bhagwat");
//		employee1.setEmailId("kartik@gmail.com");
//		employeerepository.save(employee1);

	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

}
