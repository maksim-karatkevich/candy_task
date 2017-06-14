import logic.SAXParser;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class Runner {

	public static void main(String[] args) {
		SAXParser saxParser = new SAXParser();
		saxParser.parse("order.xml");
	}
}
