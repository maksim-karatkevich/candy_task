package parser;

import java.io.IOException;

import beans.Gift;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class SAXParser implements Parser {

	public Gift parse(String fileName) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			SimpleHandler giftHandler = new SimpleHandler();
			reader.setContentHandler(giftHandler);
			reader.parse(fileName);
            return giftHandler.getGift();
		}
		catch (org.xml.sax.SAXException ex) {
			ex.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}