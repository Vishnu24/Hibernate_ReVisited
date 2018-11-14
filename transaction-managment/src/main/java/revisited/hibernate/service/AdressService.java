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

import revisited.hibernate.dao.AdressDAO;
import revisited.hibernate.dao.EmployeeDAO;
import revisited.hibernate.entity.Address;

/**
 * @author Vishnu Garg
 * @created On Aug 21, 2018
 *
 */
@Service

public class AdressService implements IAddressService{
	@Autowired
	private AdressDAO addressDAO;
	
	@Override
	@Transactional
	public void insertUser(Address Address) {
		addressDAO.insertUser(Address);
	}

	@Override
	@Transactional
	public Address getAddressById(int employeeId) {
		
		return addressDAO.getAddressById(employeeId);
	}

	@Override
	@Transactional
	public List<Address> getAddresss() {
		// TODO Auto-generated method stub
		return addressDAO.getAddresss();
	}

	

}

