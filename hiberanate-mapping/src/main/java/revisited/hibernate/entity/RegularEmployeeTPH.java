/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Vishnu Garg
 * @created On Aug 20, 2018
 *
 */
@Entity  
@DiscriminatorValue("regularemployee")  
public class RegularEmployeeTPH extends EmployeeTPH {
	@Column(name="salary")    
	private float salary;  
	@Column(name="bonus")     
	private int bonus;  
	  
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	
}

