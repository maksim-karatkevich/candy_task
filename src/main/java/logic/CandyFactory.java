package logic;

import beans.Candy;
import beans.CandyType;
import beans.ChocolateCandy;
import beans.LollipopCandy;

/**
 * Created by Maksim_Karatkevich on 6/14/2017.
 */
public class CandyFactory {

	public static Candy getCandy(String candyType) throws Exception {
		CandyType candy = CandyType.valueOf(candyType.toUpperCase());
		switch (candy) {
			case CHOCOLATE_CANDY:
				return new ChocolateCandy();
			case LOLLIPOP_CANDY:
				return new LollipopCandy();
		}
		throw new Exception("Invalid Candy Parameter");
	}
}
