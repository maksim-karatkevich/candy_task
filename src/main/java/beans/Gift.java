package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class Gift {

	public List<Candy> candies;

	public Gift()
	{
		this.candies = new ArrayList<Candy>();
	}

	public void addCandy(Candy candy) {
		this.candies.add(candy);
	}
}
