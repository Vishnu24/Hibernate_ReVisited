/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import revisited.hibernate.entity.Address;

/**
 * @author Vishnu Garg
 * @created On Aug 21, 2018
 *
 */
@Service
@ComponentScan
public class AdressDAO implements IAdreessDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertUser(Address address) {
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public Address getAddressById(int employeeId) {
		return (Address) sessionFactory.getCurrentSession().get(Address.class, employeeId);

	}

	@Override
	public List<Address> getAddresss() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Address.class);
		return criteria.list();
	}


}

