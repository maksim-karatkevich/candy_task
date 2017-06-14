package logic;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;

import beans.Candy;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class SimpleHandler implements ContentHandler {

	Candy candy;
	List<Candy> candies = new ArrayList<Candy>();
	private boolean isPrice = false;
	private boolean isWeight = false;

	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws org.xml.sax.SAXException {

		String s = qName;
		for (int i = 0; i < attributes.getLength(); i++) {
			if (s.equals("candy")) {
				try {
					this.candy = CandyFactory.getCandy(attributes.getValue("type"));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (s.equals("price")) {
			isPrice = true;
		} if (s.equals("weight")) {
			isWeight = true;
		}
	}

	public void endElement(String uri, String localName, String qName) {
		this.candies.add(candy);
	}

	public void setDocumentLocator(org.xml.sax.Locator locator) {

	}

	public void startDocument() throws org.xml.sax.SAXException {
		System.out.println("START DOC");
	}

	public void endDocument() throws org.xml.sax.SAXException {
		System.out.println("END DOCUMENT");
	}

	public void startPrefixMapping(String prefix, String uri) throws org.xml.sax.SAXException {
		System.out.println(uri);
	}

	public void endPrefixMapping(String prefix) throws org.xml.sax.SAXException {
		System.out.println(prefix);
	}

	public void characters(char[] ch, int start, int length) {
		if (isWeight) {
			candy.setWeight(Double.parseDouble(new String(ch, start, length)));
			isWeight = false;
		} else if(isPrice) {
			candy.setPrice(Double.parseDouble(new String(ch, start, length)));
			isPrice = false;
		}
	}

	public void ignorableWhitespace(char[] chars, int i, int i1) {
		System.out.println(chars);
	}

	public void processingInstruction(String s, String s1) {
		System.out.println(s);
	}

	public void skippedEntity(String s) {
		System.out.println(s);
	}
}
