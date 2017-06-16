package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class Gift {

	public List<Candy> candies = new ArrayList<>();

	public void addCandy(Candy candy) {
		this.candies.add(candy);
	}

	@Override
	public String toString() {
		return "Gift{" +
				"candies=" + candies +
				'}';
	}

	public List<Candy> getCandies() {
		return candies;
	}
}
