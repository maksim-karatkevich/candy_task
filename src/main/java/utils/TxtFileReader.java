package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maksim_Karatkevich on 6/16/2017.
 */
public class TxtFileReader {

    private static final String PATH = "E:\\ideaProject\\taf_Framework_wiki\\candy_task\\src\\main\\resources\\config.txt";
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    public static String getKey(String key) throws Exception {
        init();
        String currentLine;
        do {
            currentLine = bufferedReader.readLine();
        } while (!currentLine.contains(key));
        destroy();
        Pattern pattern = Pattern.compile("=(.*?);");
        Matcher matcher = pattern.matcher(currentLine);
        if (!matcher.find()) {
            throw new Exception(key + " value not found");
        }
        return matcher.group(1).replace(" ", "");
    }

    private static void init() throws FileNotFoundException {
        fileReader = new FileReader(PATH);
        bufferedReader = new BufferedReader(fileReader);
    }

    private static void destroy() throws IOException {
        fileReader.close();
        bufferedReader.close();
    }
}
