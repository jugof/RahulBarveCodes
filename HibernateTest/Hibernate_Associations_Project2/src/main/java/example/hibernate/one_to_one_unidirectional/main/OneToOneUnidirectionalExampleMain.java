package example.hibernate.one_to_one_unidirectional.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.one_to_one_unidirectional.entity.Employee;
import example.hibernate.one_to_one_unidirectional.entity.Passport;
import example.hibernate.one_to_one_unidirectional.utils.HibernateUtils;

public class OneToOneUnidirectionalExampleMain {
	private static void storeSomePassports() {
		// Store some passports
		Passport p1 = new Passport("ppt1", "Tejal Pandit", LocalDate.of(2029, 8, 23));
		Passport p2 = new Passport("ppt2", "Shailesh Kumar", LocalDate.of(2033, 12, 15));
		
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			Transaction tx = sessionRef.beginTransaction();
				sessionRef.persist(p1);
				sessionRef.persist(p2);
			tx.commit();
			System.out.println("Passports added.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void storeSomeEmployees() {
		//Store some employees (Initially these employees do not have passports)
		Employee e1 = new Employee(1234, "Tejal Pandit", 68974.56f, null);
		Employee e2 = new Employee(5678, "Shailesh Kumar", 78974.56f, null);
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			Transaction tx = sessionRef.beginTransaction();
				sessionRef.persist(e1);
				sessionRef.persist(e2);
			tx.commit();
			System.out.println("Employees added.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void linkPassportsToEmployees() {
		//Link passports to employees
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session sessionRef = factory.openSession();
				){
			//Find the passports which are to be linked
			Passport firstPassport = 
			sessionRef.find(Passport.class, "ppt1");
			Passport secondPassport = 
					sessionRef.find(Passport.class, "ppt2");
			//Find the employees to which passports are to be linked
			Employee firstEmployee = 
			sessionRef.find(Employee.class, 1234);
			Employee secondEmployee = 
					sessionRef.find(Employee.class, 5678);
			
			Transaction tx = sessionRef.beginTransaction();
				//Link them using setter method.
				firstEmployee.setPassportRef(firstPassport);
				secondEmployee.setPassportRef(secondPassport);
			tx.commit();
			System.out.println("Passports have been linked to Employees");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		
	}

	public static void main(String[] args) {
		//storeSomePassports();
		//storeSomeEmployees();
		linkPassportsToEmployees();
		

	}

}
