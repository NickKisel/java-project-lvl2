package hexlet.code;

import hexlet.code.Formatters.Json;
import hexlet.code.Formatters.Plain;
import hexlet.code.Formatters.Stylish;

import java.util.List;

public class Formatter {

    public static String choiceFormatter(String formatName, List<Node> commonData) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.getStylishFormat(commonData);
            case "plain":
                return Plain.getPlainFormat(commonData);
            case "json":
                return Json.getJsonFormat(commonData);
            default:
                throw new Exception("Wrong format!");
        }
    }
}
