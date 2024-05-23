package example.hibernate.hql.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.hibernate.bean.MovieInfo;
import example.hibernate.entity.Movie;
import example.hibernate.utils.HibernateUtils2;

public class SELECT_Clause_With_ConstructorExpression_ExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = 
				HibernateUtils2.getSessionFactory();
				Session sessionRef = 
						factory.openSession()
				){
			String hqlQuery = 
			"select new example.hibernate.bean.MovieInfo(m.title, m.year) from Movie m";
			Query<MovieInfo> queryRef = 
			sessionRef.createQuery(hqlQuery, MovieInfo.class);
			List<MovieInfo> dataList = queryRef.list();
			for(MovieInfo info : dataList) {
				String title = info.getMovieTitle();
				int year = info.getMovieYear();
				System.out.println("Movie: " + title + " was released in " + year);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
