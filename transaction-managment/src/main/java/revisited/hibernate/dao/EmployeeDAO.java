/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import revisited.hibernate.entity.Employee;

/**
 * @author Vishnu Garg
 * @created On Aug 21, 2018
 *
 */
@Service
@ComponentScan(value="revisited.hibernate.dao")
public class EmployeeDAO implements IEmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(employee);
	}
	@Override
	public Employee getEmployeeById(int employeeId) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, employeeId);
	}
	@Override
	public Employee getEmployee(String employeename) {
		Query query = sessionFactory.getCurrentSession().createQuery("from employee where emp_name = :emp_name");
		query.setParameter("emp_name", employeename);
		
		return (Employee) query.list().get(0);
	}
	@Override
	public List<Employee> getEmployees() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		return criteria.list();
	}

}
