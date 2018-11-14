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
@DiscriminatorValue("contractemployee")
public class ContractEmployeeTPH extends EmployeeTPH{
	@Column(name = "pay_per_hour")
	private float pay_per_hour;
	@Column(name = "contract_duration")
	private String contract_duration;

	public float getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public String getContract_duration() {
		return contract_duration;
	}

	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}

}
