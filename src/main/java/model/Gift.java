package model;

import beans.Candy;

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

	public List<Candy> getCandies() {
		return candies;
	}
}
