package example.hibernate.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Movie;
import example.hibernate.utils.HibernateUtils2;

public class MovieRecordDeleteExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = 
				HibernateUtils2.getSessionFactory();
				Session sessionRef = 
						factory.openSession()
				){
			Class<Movie> entityType = Movie.class;
			Serializable id = 103;
			
			Movie foundMovie = 
					sessionRef.find(entityType, id);
			Transaction tx = sessionRef.beginTransaction();
				//Removing this movie
				sessionRef.remove(foundMovie);
			tx.commit();
			System.out.println("Record deleted successfully");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
