package utils;

/**
 * Created by Maksim on 6/19/2017.
 */
public class ViewFactory {

    public static View getView(String viewType) throws Exception {
        switch (viewType.toUpperCase()) {
            case "CONSOLE":
                return new ConsoleView();
            case "FILE":
                return new FileView();
            default:
                throw new Exception(viewType + ": view model not exists");
        }
    }
}
