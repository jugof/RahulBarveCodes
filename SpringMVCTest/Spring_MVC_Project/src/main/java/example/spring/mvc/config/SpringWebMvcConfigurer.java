package example.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc//Enabling the CALLBACK mechanism support
public class SpringWebMvcConfigurer implements WebMvcConfigurer {
	//Declaring a bean of type: InternalResourceViewResolver
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolverRef = 
				new InternalResourceViewResolver();
		String prefix = "/WEB-INF/pages/";
		String suffix = ".jsp";
		viewResolverRef.setPrefix(prefix);
		viewResolverRef.setSuffix(suffix);
		return viewResolverRef;
	}
}
