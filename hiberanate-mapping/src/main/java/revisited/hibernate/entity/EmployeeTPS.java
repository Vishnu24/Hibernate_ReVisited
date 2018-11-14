/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Vishnu Garg
 * @created On Aug 20, 2018
 *
 */
@Entity  
@Table(name = "employee_tps")  
@Inheritance(strategy=InheritanceType.JOINED)  
public class EmployeeTPS {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

