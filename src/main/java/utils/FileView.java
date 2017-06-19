package utils;

import beans.Candy;
import beans.Gift;
import utils.View;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Maksim on 6/19/2017.
 */
public class FileView implements View {

    private String filePath = "E:\\ideaProject\\taf_Framework_wiki\\candy_task\\src\\main\\resources\\fileView.txt";

    @Override
    public void printGift(Gift gift) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            int totalPrice = 0;
            int totalWeight = 0;
            for (Candy c : gift.getCandies()) {
                writer.write(c.toString() + "\n");
                totalPrice += c.getPrice();
                totalWeight += c.getWeight();
            }
            writer.write("Gift price: " + totalPrice + " Gift weight: " + totalWeight);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
