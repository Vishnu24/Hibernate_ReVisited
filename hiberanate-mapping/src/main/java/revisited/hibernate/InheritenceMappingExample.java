package revisited.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import revisited.hibernate.entity.ContractEmployeeTPC;
import revisited.hibernate.entity.ContractEmployeeTPH;
import revisited.hibernate.entity.ContractEmployeeTPS;
import revisited.hibernate.entity.EmployeeTPC;
import revisited.hibernate.entity.EmployeeTPH;
import revisited.hibernate.entity.EmployeeTPS;
import revisited.hibernate.entity.RegularEmployeeTPC;
import revisited.hibernate.entity.RegularEmployeeTPH;
import revisited.hibernate.entity.RegularEmployeeTPS;
import revisited.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class InheritenceMappingExample {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		System.out.println("InheritenceMappingExample");
		sessionFactory = HibernateUtil.getSessionFactory();
		//For Table per Hierchy mapping
		//proceedForTPHMapping();
		
		//Table Per Class Mappings
		//proceedForTPCMapping();
		
		//Table per subclass Mappin
		proceedForTPSMapping();
	}

	private static void proceedForTPHMapping() {
		Session session = sessionFactory.openSession();

		Transaction t = session.beginTransaction();

		EmployeeTPH e1 = new EmployeeTPH();
		e1.setName("Gaurav Chawla");

		RegularEmployeeTPH e2 = new RegularEmployeeTPH();
		e2.setName("Vivek Kumar");
		e2.setSalary(50000);
		e2.setBonus(5);

		ContractEmployeeTPH e3 = new ContractEmployeeTPH();
		e3.setName("Arjun Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);

		t.commit();
		session.close();
		System.out.println("success");
	}
	
	private static void proceedForTPCMapping() {
		Session session = sessionFactory.openSession();

		Transaction t = session.beginTransaction();

		EmployeeTPC e1 = new EmployeeTPC();
		e1.setName("Gaurav Chawla");

		RegularEmployeeTPC e2 = new RegularEmployeeTPC();
		e2.setName("Vivek Kumar");
		e2.setSalary(50000);
		e2.setBonus(5);

		ContractEmployeeTPC e3 = new ContractEmployeeTPC();
		e3.setName("Arjun Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);

		t.commit();
		session.close();
		System.out.println("success");
	}
	
	private static void proceedForTPSMapping() {
		Session session = sessionFactory.openSession();

		Transaction t = session.beginTransaction();

		EmployeeTPS e1 = new EmployeeTPS();
		e1.setName("Gaurav Chawla");

		RegularEmployeeTPS e2 = new RegularEmployeeTPS();
		e2.setName("Vivek Kumar");
		e2.setSalary(50000);
		e2.setBonus(5);

		ContractEmployeeTPS e3 = new ContractEmployeeTPS();
		e3.setName("Arjun Kumar");
		e3.setPay_per_hour(1000);
		e3.setContract_duration("15 hours");

		session.persist(e1);
		session.persist(e2);
		session.persist(e3);

		t.commit();
		session.close();
		System.out.println("success");
	}
}
