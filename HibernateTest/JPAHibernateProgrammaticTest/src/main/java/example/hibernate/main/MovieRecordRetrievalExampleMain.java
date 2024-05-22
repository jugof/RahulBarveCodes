package example.hibernate.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Movie;
import example.hibernate.utils.HibernateUtils2;

public class MovieRecordRetrievalExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = 
				HibernateUtils2.getSessionFactory();
				Session sessionRef = 
						factory.openSession()
				){
			Class<Movie> entityType = Movie.class;
			Serializable id = 102;//new Integer(102)
			//select * from movie_master where movie_id = 102
			Movie foundMovie = 
					sessionRef.find(entityType, id);
			if(foundMovie != null)
				System.out.println(foundMovie);
			else
				System.out.println("Movie with given ID does not exist.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
