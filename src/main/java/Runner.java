import beans.Gift;
import parser.Parser;
import factory.ParserFactory;
import utils.TxtFileReader;
import utils.View;
import utils.ViewFactory;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class Runner {

    public static void main(String[] args) {
        String parserName;
        String viewType;
        try {
            parserName = TxtFileReader.getKey("parser");
            viewType = TxtFileReader.getKey("view");

            Parser parser = ParserFactory.getParser(parserName);
            Gift gift = parser.parse("order.xml");

            View view = ViewFactory.getView(viewType);
            view.printGift(gift);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
