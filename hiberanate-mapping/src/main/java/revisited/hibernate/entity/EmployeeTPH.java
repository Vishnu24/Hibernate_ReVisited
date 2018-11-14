/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate.entity;

import javax.persistence.*;

/**
 * @author Vishnu Garg
 * @created On Aug 20, 2018
 *
 */
@Entity
@Table(name = "employee_tph")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "employee")
public class EmployeeTPH {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "id")
	private int id;

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
	@Column(name = "name")
	private String name;
}
