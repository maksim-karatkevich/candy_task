package utils;

import beans.Candy;
import beans.Gift;
import utils.View;


/**
 * Created by Maksim on 6/14/2017.
 */
public class ConsoleView implements View {

    @Override
    public void printGift(Gift gift) {
        int totalPrice = 0;
        int totalWeight = 0;
        for (Candy c : gift.getCandies()) {
            System.out.println(c.toString());
            totalPrice += c.getPrice();
            totalWeight += c.getWeight();
        }
        System.out.println("Total price = " + totalPrice);
        System.out.println("Total weight = " + totalWeight);
        System.out.println("Total candies = " + gift.getCandies().size());
    }

}
