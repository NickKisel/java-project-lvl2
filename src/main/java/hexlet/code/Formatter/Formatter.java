package hexlet.code.Formatter;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Formatter {
    private final List<String> result = new LinkedList<>();
    private String sResult;

    public String choiceFormatter(String format, Map<String, String> commonData,
                                  Map<String, Object> data1, Map<String, Object> data2) {
        if (format.equals("stylish")) {
            sResult = stylishToString(stylish(commonData, data1, data2));
        } else if (format.equals("plain")) {
            sResult = plain(commonData, data1, data2);
        }
        return sResult;
    }

    private List<String> stylish(Map<String, String> commonData, Map<String, Object> data1,
                                 Map<String, Object> data2) {
        for (String key : commonData.keySet()) {
            if (commonData.get(key).equals("unchanged")) {
                result.add(key + ": " + data1.get(key));
            } else if (commonData.get(key).equals("changed")) {
                result.add("- " + key + ": " + data1.get(key));
                result.add("+ " + key + ": " + data2.get(key));
            } else if (commonData.get(key).equals("deleted")) {
                result.add("- " + key + ": " + data1.get(key));
            } else if (commonData.get(key).equals("added")) {
                result.add("+ " + key + ": " + data2.get(key));
            }
        }
        result.add(0, "{");
        result.add(result.size(), "}");
        return result;
    }

    private String stylishToString(List<String> list) {
        String whitespace = " ";
        final int countWhitespace = 4;
        return list.stream()
                .map(x -> {
                    if (x.startsWith("+") || x.startsWith("-")) {
                        return whitespace.repeat(2) + x;
                    } else if (x.startsWith("{") || x.startsWith("}")) {
                        return x;
                    } else {
                        return whitespace.repeat(countWhitespace) + x;
                    }
                })
                .collect(Collectors.joining("\n"));
    }

    private String plain(Map<String, String> commonData, Map<String, Object> data1,
                         Map<String, Object> data2) {
        for (String key : commonData.keySet()) {
            if (commonData.get(key).equals("changed")) {
                result.add("Property '" + key + "' was updated. From " + getStringValuePlain(data1.get(key))
                        + " to " + getStringValuePlain(data2.get(key)));
            } else if (commonData.get(key).equals("deleted")) {
                result.add("Property '" + key + "' was removed");
            } else if (commonData.get(key).equals("added")) {
                result.add("Property '" + key + "' was added with value: " + getStringValuePlain(data2.get(key)));
            }
        }
        return result.stream()
                .map(x -> {
                    if (result.indexOf(x) == result.size()) {
                        return x;
                    } else {
                        return x + "\n";
                    }
                })
                .collect(Collectors.joining());
    }

    private String getStringValuePlain(Object value) {
        if (value instanceof Collection || value instanceof Map || value instanceof Array) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }
}
