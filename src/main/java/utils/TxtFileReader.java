package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Maksim_Karatkevich on 6/16/2017.
 */
public class TxtFileReader {

	private static final String PATH = "D:\\candyTask\\src\\main\\resources\\config.txt";
	private static final String FILE_KEY = "parser";

	public static String getParserName() throws Exception {
		try {
			FileReader fileReader = new FileReader(PATH);
			BufferedReader textReader = new BufferedReader(fileReader);
			String currentLine;
			do {
				currentLine = textReader.readLine();
			} while (!currentLine.contains(FILE_KEY));

			return readKey(currentLine);
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		throw new Exception(PATH + " not contain the parser argument");
	}

	private static String readKey(String currentLine) {
		return currentLine.split("=")[1];
	}
}
