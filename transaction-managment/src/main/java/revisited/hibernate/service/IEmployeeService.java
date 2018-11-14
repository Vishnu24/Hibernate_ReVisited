/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.service;

import java.util.List;

import revisited.hibernate.entity.Employee;

/**
 * @author Vishnu Garg
 * @created On Aug 21, 2018
 *
 */
public interface IEmployeeService {
	void insertEmployee(Employee employee);
	
	Employee getEmployeeById(int employeeId);
	
	Employee getEmployee(String employeename);
	
	List<Employee> getEmployees();
}

