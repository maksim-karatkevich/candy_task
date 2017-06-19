package parser;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import beans.Candy;
import beans.ChocolateCandy;
import beans.ChocolateType;
import beans.Gift;
import beans.LollipopCandy;
import beans.LollipopTaste;
import factory.CandyFactory;

public class SimpleHandler implements ContentHandler {

	private Candy currentCandy;
	private Gift gift;
	private String currentTag;

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentTag = qName;
		if (qName.equals("gift")) {
			this.gift = new Gift();
		} else if (qName.equals("candy")) {
			try {
				this.currentCandy = CandyFactory.getCandy(attributes.getValue("type"));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("candy")) {
			gift.addCandy(currentCandy);
		}
	}

	public void setDocumentLocator(org.xml.sax.Locator locator) {

	}

	public void startDocument() throws org.xml.sax.SAXException {
	}

	public void endDocument() throws org.xml.sax.SAXException {
//		getGift().candies.forEach(System.out::println);
	}

	public void startPrefixMapping(String prefix, String uri) throws org.xml.sax.SAXException {
	}

	public void endPrefixMapping(String prefix) throws org.xml.sax.SAXException {
	}

	public void characters(char[] ch, int start, int length) {
		String element = new String(ch, start, length).trim();
		if (element.length() != 0 && currentTag != null)
			switch (currentTag) {
				case "price":
					currentCandy.setPrice(Double.parseDouble(element));
					break;
				case "weight":
					currentCandy.setWeight(Double.parseDouble(element));
					break;
				case "chocolateType":
					((ChocolateCandy) currentCandy).setChocolateType(ChocolateType.valueOf(element.toUpperCase()));
					break;
				case "lollipopTaste":
					((LollipopCandy) currentCandy).setLollipopTaste(LollipopTaste.valueOf(element.toUpperCase()));
					break;
			}
	}

	public void ignorableWhitespace(char[] chars, int i, int i1) {
	}

	public void processingInstruction(String s, String s1) {
	}

	public void skippedEntity(String s) {
	}

	public Gift getGift() {
		return this.gift;
	}
}
