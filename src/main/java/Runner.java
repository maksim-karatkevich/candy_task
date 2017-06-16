import beans.Gift;
import parser.Parser;
import parser.ParserFactory;
import utils.TxtFileReader;
import utils.View;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class Runner {

	public static void main(String[] args) {
		String parserName = null;
		try {
			parserName = TxtFileReader.getParserName();
			Parser parser = ParserFactory.getParser(parserName);
			Gift gift = parser.parse("order.xml");
			View.show(gift);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
