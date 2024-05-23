package example.hibernate.one_to_one_unidirectional.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.one_to_one_unidirectional.entity.Employee;
import example.hibernate.one_to_one_unidirectional.entity.Passport;


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
		Class<Employee> empClass = Employee.class;
		Class<Passport> pptClass = Passport.class;
		hibernateConfig.addAnnotatedClass(empClass);
		hibernateConfig.addAnnotatedClass(pptClass);
		SessionFactory factory = hibernateConfig.buildSessionFactory();
		return factory;
		
	}
}
