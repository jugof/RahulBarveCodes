package example.hibernate.hql.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.hibernate.entity.Movie;
import example.hibernate.utils.HibernateUtils2;

public class SELECT_Clause_ExampleMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = 
				HibernateUtils2.getSessionFactory();
				Session sessionRef = 
						factory.openSession()
				){
			String hqlQuery = 
			"select m.title, m.year from Movie m";
			Query<Object[]> queryRef = 
			sessionRef.createQuery(hqlQuery, Object[].class);
			List<Object[]> dataList = queryRef.list();
			for(Object[] objArr : dataList) {
				Object title = objArr[0];
				Object year = objArr[1];
				System.out.println("Movie: " + title + " was released in " + year);
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
