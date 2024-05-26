package food_item.dessert;

import org.springframework.stereotype.Component;

@Component("sundae")//Assigning an ID to this bean
public class TrippleSundae {
	public void tasteSundae() {
		System.out.println("Tasting tripple sundae");
	}
}
