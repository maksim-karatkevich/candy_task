import beans.Gift;
import parser.SAXParser;
import utils.View;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class Runner {

	public static void main(String[] args) {
		SAXParser saxParser = new SAXParser();
		Gift gift = saxParser.parse("order.xml");
		View.getGiftPrice(gift);
	}
}
