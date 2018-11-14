/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import revisited.hibernate.dao.EmployeeDAO;
import revisited.hibernate.entity.Employee;

/**
 * @author Vishnu Garg
 * @created On Aug 21, 2018
 *
 */
@Service

public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeDAO empDAO;

	@Override
	@Transactional
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		empDAO.insertEmployee(employee);
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return empDAO.getEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public Employee getEmployee(String employeename) {

		return empDAO.getEmployee(employeename);
	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {

		return empDAO.getEmployees();
	}

}
