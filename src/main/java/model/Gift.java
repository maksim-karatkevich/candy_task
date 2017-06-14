package model;

import java.util.ArrayList;
import java.util.List;

import beans.Candy;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class Gift
{
	private List<Candy> candyList;

	public Gift() {
		this.candyList = new ArrayList<Candy>();
	}

	public List<Candy> getCandyList() {
		return candyList;
	}

	public void addCandy(Candy candy) {
		this.candyList.add(candy);
	}

}
