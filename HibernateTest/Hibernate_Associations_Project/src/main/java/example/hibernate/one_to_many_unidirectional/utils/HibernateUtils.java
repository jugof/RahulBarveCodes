package example.hibernate.one_to_many_unidirectional.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.one_to_many_unidirectional.entity.CricketPlayer;
import example.hibernate.one_to_many_unidirectional.entity.CricketTeam;




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
		Class<CricketTeam> teamClass = CricketTeam.class;
		Class<CricketPlayer> playerClass = CricketPlayer.class;
		hibernateConfig.addAnnotatedClass(teamClass);
		hibernateConfig.addAnnotatedClass(playerClass);
		SessionFactory factory = hibernateConfig.buildSessionFactory();
		return factory;
		
	}
}
