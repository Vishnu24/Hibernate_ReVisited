/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package revisited.hibernate;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.CreateKeySecondPass;
import org.hibernate.stat.Statistics;

import revisited.hibernate.entity.Address;
import revisited.hibernate.entity.Employee;
import revisited.hibernate.util.HibernateUtil;

/**
 * @author Vishnu Garg
 * @created On Aug 20, 2018
 *
 */
public class HibernateCachingExample {

	private static SessionFactory sessionFactory;
	public static void main(String[] args) {
		
		System.out.println("Temp Dir:"+System.getProperty("java.io.tmpdir"));
		
		//Initialize Sessions
		 sessionFactory = HibernateUtil.getSessionFactory();
		
		Statistics stats = sessionFactory.getStatistics();
		
		System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		
		stats.setStatisticsEnabled(true);
		
		System.out.println("Stats enabled="+stats.isStatisticsEnabled());
		//createEmployee(sessionFactory);
		
		
		Session session = sessionFactory.openSession();
		Session otherSession = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		Transaction otherTransaction = otherSession.beginTransaction();
		
		printStats(stats, 0);
		
		Employee emp = (Employee) session.load(Employee.class, 1L);
		printData(emp, stats, 1);
		
		emp = (Employee) session.load(Employee.class, 1L);
		printData(emp, stats, 2);
		
		//clear first level cache, so that second level cache is used
		session.evict(emp);
		emp = (Employee) session.load(Employee.class, 1L);
		printData(emp, stats, 3);
		
		emp = (Employee) session.load(Employee.class, 2L);
		printData(emp, stats, 4);
		
		emp = (Employee) otherSession.load(Employee.class, 1L);
		printData(emp, stats, 5);
		
		//Release resources
		transaction.commit();
		otherTransaction.commit();
		sessionFactory.close();
	}
	
	private static void createEmployee(SessionFactory sessionFactory){
		
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp1=new Employee();
		emp1.setName("Rachi");
		emp1.setSalary(2332.2323);
		session.save(emp1);
		transaction.commit();
		Address address=addAddress("sdasda", "delhi", "sd",emp1);
	}
	private static Address addAddress(String street, String city,  String zipcode,Employee employee) {
	      Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      Integer addressID = null;
	      Address address = null;
	      try {
	         tx = session.beginTransaction();
	         address = new Address();
	         address.setAddressLine1(street);
	         address.setCity(city);
	         address.setZipcode(zipcode);
	         address.setEmployee(employee);
	         session.save(address); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return address;
	   }

	  
	private static void printStats(Statistics stats, int i) {
		System.out.println("***** " + i + " *****");
		System.out.println("Fetch Count="
				+ stats.getEntityFetchCount());
		System.out.println("Second Level Hit Count="
				+ stats.getSecondLevelCacheHitCount());
		System.out
				.println("Second Level Miss Count="
						+ stats
								.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count="
				+ stats.getSecondLevelCachePutCount());
	}

	private static void printData(Employee emp, Statistics stats, int count) {
		System.out.println(count+":: Name="+emp.getName()+", Zipcode="+emp.getAddress().getZipcode());
		printStats(stats, count);
	}

}

