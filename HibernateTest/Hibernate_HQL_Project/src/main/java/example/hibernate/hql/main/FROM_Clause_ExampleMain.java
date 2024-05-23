package example.hibernate.hql.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.hibernate.entity.Movie;
import example.hibernate.utils.HibernateUtils2;

public class FROM_Clause_ExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = 
				HibernateUtils2.getSessionFactory();
				Session sessionRef = 
						factory.openSession()
				){
			String hqlQuery = "from Movie m";
			//Obtaining Query reference
			Class<Movie> movieClass = Movie.class;
			Query<Movie> queryRef = 
			sessionRef.createQuery(hqlQuery, movieClass);
			List<Movie> movieList =  queryRef.list();
			//movieList.forEach(System.out::println);
			
			for(Movie currentMovie : movieList) 
				System.out.println(currentMovie.getTitle());
			 
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
