package utils;

import beans.Gift;


/**
 * Created by Maksim on 6/14/2017.
 */
public class View {

    public static void show(Gift gift) {
        System.out.println(GiftCalculate.getPrice(gift));
        System.out.println(GiftCalculate.getWeight(gift));
        System.out.println(gift.toString());
    }

}
