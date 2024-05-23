package example.hibernate.many_to_many_bidirectional.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.many_to_many_bidirectional.entiry.Actor;
import example.hibernate.many_to_many_bidirectional.entiry.Movie;

public class HibernateUtils {
	public static SessionFactory getSessionFactory() {
		Configuration hibernateConfig = 
				new Configuration();
		
		Properties hibernateProperties = 
				new Properties();
		
		hibernateProperties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/cdac");
		hibernateProperties.put("hibernate.connection.username", "root");
		hibernateProperties.put("hibernate.connection.password", "root");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		
		hibernateConfig.setProperties(hibernateProperties);
		//Registering the Entity class with Configuration
		Class<Movie> movieClass = Movie.class;
		Class<Actor> actorClass = Actor.class;
		hibernateConfig.addAnnotatedClass(movieClass);
		hibernateConfig.addAnnotatedClass(actorClass);
		SessionFactory factory = hibernateConfig.buildSessionFactory();
		return factory;
		
	}
}
