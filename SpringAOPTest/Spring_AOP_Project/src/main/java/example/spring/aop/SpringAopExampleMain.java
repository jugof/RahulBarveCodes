package example.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopExampleMain {

	public static void main(String[] args) {
		Class<SpringAopConfig> configClass = 
				SpringAopConfig.class;
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(configClass);
		
		Class<Musician> musicianType = 
				Musician.class;
		Musician musicianRef =  ctx.getBean(musicianType);
		musicianRef.perform();
		
		System.out.println("-----------------------");
		
		Class<Singer> singerType = Singer.class;
		Singer singerRef = ctx.getBean(singerType);
		singerRef.perform();
		
		System.out.println("Printing class names of the object for which the reference is obtained:");
		System.out.println(musicianRef.getClass().getName());
		System.out.println(singerRef.getClass().getName());

	}

}
