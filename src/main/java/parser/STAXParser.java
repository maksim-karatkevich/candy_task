package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import beans.Candy;
import beans.ChocolateCandy;
import beans.ChocolateType;
import beans.Gift;
import beans.LollipopCandy;
import beans.LollipopTaste;
import logic.CandyFactory;

/**
 * Created by Maksim_Karatkevich on 6/16/2017.
 */
public class STAXParser implements Parser {
	private Candy currentCandy;
	private Gift gift;
	private static final String CANDY_TAG = "candy";
	private static final String PRICE_TAG = "price";
	private static final String CHOCOLATE_TYPE_TAG = "chocolateType";
	private static final String LOLLIPOP_TASTE_TAG = "lollipopTaste";
	private static final String GIFT_TAG = "gift";
	private static final String WEIGHT_TAG = "weight";
	private String currentTag;

	public Gift parse(String fileName) {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new FileInputStream(fileName));
			proces(reader);
		}
		catch (XMLStreamException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return gift;
	}

	private void proces(XMLStreamReader reader) throws Exception {
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
				case XMLStreamConstants.START_ELEMENT:
					startElement(reader);
					break;
				case XMLStreamConstants.CHARACTERS:
					String values = reader.getText().trim();
					if (values.length() != 0 && currentTag != null) {
						characters(values);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					endElement();
					break;
			}
		}
	}

	private void startElement(XMLStreamReader reader) throws Exception {
		currentTag = reader.getLocalName();
		switch (currentTag) {
			case GIFT_TAG:
				this.gift = new Gift();
				break;
			case CANDY_TAG:
				this.currentCandy = CandyFactory.getCandy(reader.getAttributeValue("", "type"));
				break;
		}
	}

	private void endElement() {
		if (currentTag.equals("chocolateType")) {
			gift.addCandy(currentCandy);
		} else if (currentTag.equals("lollipopTaste")) {
			gift.addCandy(currentCandy);
		} else {

		}
	}

	private void characters(String values) {
		switch (currentTag) {
			case PRICE_TAG:
				currentCandy.setPrice(Double.parseDouble(values));
				break;
			case WEIGHT_TAG:
				currentCandy.setWeight(Double.parseDouble(values));
				break;
			case CHOCOLATE_TYPE_TAG:
				((ChocolateCandy) currentCandy).setChocolateType(ChocolateType.valueOf(values));
				break;
			case LOLLIPOP_TASTE_TAG:
				((LollipopCandy) currentCandy).setLollipopTaste(LollipopTaste.valueOf(values));
				break;
		}

	}

}
