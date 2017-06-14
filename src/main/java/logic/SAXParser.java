package logic;

import java.io.IOException;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import model.Gift;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class SAXParser implements Parser {

	public Gift parse(String fileName) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			SimpleHandler contentHandler = new SimpleHandler();
			reader.setContentHandler(contentHandler);
			reader.parse(fileName);
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