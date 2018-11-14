package revisited.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import revisited.hibernate.entity.Employee;
import revisited.hibernate.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeService empService = (EmployeeService) ctx.getBean("employeeService");

		Employee emp1 = new Employee();
		emp1.setName("Rahul");
		emp1.setSalary(10.2323);
		empService.insertEmployee(emp1);

		System.out.println("Employee inserted!");

		emp1 = empService.getEmployee("Rahul");

		System.out.println("\nEmployee fetched by Employeename!" + "\nId: " + emp1.getId() + "\nEmployeename: " + emp1.getName()
				+ "\n Salary: " + emp1.getSalary());

		emp1 = empService.getEmployeeById((int) emp1.getId());

		System.out.println("\nEmployee fetched by Employeename!" + "\nId: " + emp1.getId() + "\nEmployeename: " + emp1.getName()
		+ "\n Salary: " + emp1.getSalary());

		List<Employee> Employees = empService.getEmployees();

		System.out.println("\nEmployee list fetched!" + " employee count: " + Employees.size());
	}
}
