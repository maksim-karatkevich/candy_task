package utils;

import beans.Candy;
import beans.Gift;


public class GiftCalculate {

	public static double getPrice(Gift gift) {
		return gift.getCandies().stream().mapToDouble(Candy::getPrice).sum();
	}

	public static double getWeight(Gift gift) {
		return gift.getCandies().stream().mapToDouble(Candy::getWeight).sum();
	}
}
