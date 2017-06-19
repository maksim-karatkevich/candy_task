package factory;

import parser.Parser;
import parser.ParserType;
import parser.SAXParser;
import parser.STAXParser;

/**
 * Created by Maksim_Karatkevich on 6/16/2017.
 */
public class ParserFactory {

	public static Parser getParser(String parser) throws Exception {
		ParserType type = ParserType.valueOf(parser);
		switch (type) {
			case SAX:
				return new SAXParser();
			case STAX:
				return new STAXParser();
			default:
				throw new Exception(parser + "not exists");
		}
	}
}
