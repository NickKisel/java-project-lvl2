package hexlet.code.Formatter;

import hexlet.code.Node;

import java.util.List;

public final class Formatter {
    private String sResult;

    public String choiceFormatter(String formatName, List<Node> commonData) {
        if (formatName.equals("stylish")) {
            sResult = new Stylish().getStylishFormat(commonData);
        } else if (formatName.equals("plain")) {
            sResult = new Plain().getPlainFormat(commonData);
        } else if (formatName.equals("json")) {
            sResult = new Json().getJsonFormat(commonData);
        }
        return sResult;
    }
}
