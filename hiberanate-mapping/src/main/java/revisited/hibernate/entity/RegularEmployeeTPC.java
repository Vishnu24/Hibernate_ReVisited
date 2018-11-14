/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Vishnu Garg
 * @created On Aug 20, 2018
 *
 */
@Entity
@Table(name = "regularemployee_tpc")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id")),
		@AttributeOverride(name = "name", column = @Column(name = "name")) })
public class RegularEmployeeTPC extends EmployeeTPC {
	@Column(name = "salary")
	private float salary;
	@Column(name = "bonus")
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
