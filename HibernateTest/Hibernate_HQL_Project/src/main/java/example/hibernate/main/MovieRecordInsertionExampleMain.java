package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Movie;
import example.hibernate.utils.HibernateUtils2;

public class MovieRecordInsertionExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = 
				HibernateUtils2.getSessionFactory();
				Session sessionRef = 
						factory.openSession()
				){
			Movie movieRef = 
					new Movie(104, "Evil Dead", "Horror", 1988);
			Transaction tx = sessionRef.beginTransaction();
				sessionRef.persist(movieRef);
			tx.commit();
			System.out.println("Record added successfully.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
