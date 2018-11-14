/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.dao;

import java.util.List;

import revisited.hibernate.entity.Address;

/**
 * @author Vishnu Garg
 * @created On Aug 21, 2018
 *
 */
public interface IAdreessDAO {
	 void insertUser(Address Address);
		
		Address getAddressById(int employeeId);
		
		List<Address> getAddresss();
}

