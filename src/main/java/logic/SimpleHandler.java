package logic;

import beans.*;
import model.Gift;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;

/**
 * Created by Maksim_Karatkevich on 6/13/2017.
 */
public class SimpleHandler implements ContentHandler {

    private Candy currentCandy;
    private Gift gift;
    private boolean isPrice = false;
    private boolean isWeight = false;
    private boolean isChocolateType = false;
    private boolean isLollipopTaste = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws org.xml.sax.SAXException {
        String s = qName;
        if (s.equals("gift")) {
            this.gift = new Gift();
        }
        for (int i = 0; i < attributes.getLength(); i++) {
            if (s.equals("candy")) {
                try {
                    this.currentCandy = CandyFactory.getCandy(attributes.getValue("type"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (s.equals("price")) {
            isPrice = true;
        }
        if (s.equals("weight")) {
            isWeight = true;
        }
        if (s.equals("chocolateType")) {
            isChocolateType = true;
        }
        if (s.equals("lollipopTaste")) {
            isLollipopTaste = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("candy")) {
            gift.addCandy(currentCandy);
            currentCandy = null;
        }
        if (qName.equals("price")) {
            isPrice = false;
        }
        if (qName.equals("weight")) {
            isWeight = false;
        }
        if (qName.equals("chocolateType")) {
            isChocolateType = false;
        }
        if (qName.equals("lollipopTaste")) {
            isLollipopTaste = false;
        }
    }


    public void setDocumentLocator(org.xml.sax.Locator locator) {

    }

    public void startDocument() throws org.xml.sax.SAXException {
    }

    public void endDocument() throws org.xml.sax.SAXException {
        for (Candy c : gift.getCandies()) {
            System.out.println(c.toString());
        }
    }

    public void startPrefixMapping(String prefix, String uri) throws org.xml.sax.SAXException {
    }

    public void endPrefixMapping(String prefix) throws org.xml.sax.SAXException {
    }

    public void characters(char[] ch, int start, int length) {
        if (isWeight) {
            currentCandy.setWeight(Double.parseDouble(new String(ch, start, length)));
            isWeight = false;
        } else if (isPrice) {
            currentCandy.setPrice(Double.parseDouble(new String(ch, start, length)));
            isPrice = false;
        } else if (isLollipopTaste) {
            LollipopCandy l = (LollipopCandy) currentCandy;
            l.setLollipopTaste(LollipopTaste.valueOf(new String(ch, start, length)));
        } else if (isChocolateType) {
            ChocolateCandy c = (ChocolateCandy) currentCandy;
            c.setChocolateType(ChocolateType.valueOf(new String(ch, start, length)));

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
