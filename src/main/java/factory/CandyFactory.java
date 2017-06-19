package factory;

import beans.*;

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
			case ALENKA:
				return new ChocolateCandy(ChocolateType.MILK, 1.1, 1.5);
			case CHUPACHUPS:
				return new LollipopCandy(LollipopTaste.CHERRY, 1.7, 2.3);
		}
		throw new Exception("Invalid Candy Parameter");
	}
}
