package example.spring.pure.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import food_item.Fruit;
import food_item.dessert.IceCream;
import food_item.dessert.TrippleSundae;
import food_item.dessert.brownie.WalnutBrownie;

public class PureAnnotationBasedExampleMain {

	public static void main(String[] args) {
		// Obtaining a bean of type: MySpringComponent
		Class<SpringConfig> configClass = 
				SpringConfig.class;
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(configClass);
		
		Class<MySpringComponent> compClass = 
				MySpringComponent.class;
		MySpringComponent myComp = ctx.getBean(compClass);
		myComp.doWork();
		
		Class<Fruit> fruitComp = Fruit.class;
		Fruit fr = ctx.getBean(fruitComp);
		fr.tasteFruit();
		
		Class<IceCream> iceCreamComp = IceCream.class;
		IceCream iceCreamRef = ctx.getBean(iceCreamComp);
		iceCreamRef.tasteIceCream();
		
		Class<WalnutBrownie> brownieComp = WalnutBrownie.class;
		WalnutBrownie walnutBrownieRef = 
		ctx.getBean(brownieComp);
		walnutBrownieRef.tasteBrownie();
		
		Object obj = ctx.getBean("sundae");
		TrippleSundae trSundae = (TrippleSundae)obj;
		trSundae.tasteSundae();
	}

}
