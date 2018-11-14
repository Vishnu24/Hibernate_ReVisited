/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.service;

import java.util.List;

import revisited.hibernate.entity.Address;

/**
 * @author Vishnu Garg
 * @created On Aug 21, 2018
 *
 */
public interface IAddressService {
    void insertUser(Address Address);
	
	Address getAddressById(int employeeId);
	
	List<Address> getAddresss();
}

