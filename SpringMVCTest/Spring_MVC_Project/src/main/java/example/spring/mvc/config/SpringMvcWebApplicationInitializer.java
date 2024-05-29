package example.spring.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class SpringMvcWebApplicationInitializer implements WebApplicationInitializer {

	private WebApplicationContext getWebApplicationContext() {
		AnnotationConfigWebApplicationContext webContextRef =
				new AnnotationConfigWebApplicationContext();
		webContextRef.setConfigLocation("example");
		//This is equivalent to @ComponentScan(basePackages = {"example"})
		return webContextRef;
	}
	@Override
	public void onStartup(ServletContext servletContextRef) throws ServletException {
		// This method gets invoked as soon as the application is loaded.
		WebApplicationContext webContext = getWebApplicationContext();//Invoking the 'private' method
		//Creating an object of Front Controller: DispatcherServlet based upon this webContext
		DispatcherServlet frontControllerServlet = 
				new DispatcherServlet(webContext);
		//Registering DispatcherServlet in such a way that
		//it accepts all incoming requests.
		ServletRegistration.Dynamic registration = 
		servletContextRef.addServlet("myFrontController", frontControllerServlet);
		registration.addMapping("/");
	}

}
