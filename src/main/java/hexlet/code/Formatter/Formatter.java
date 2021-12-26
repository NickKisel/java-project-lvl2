package hexlet.code.Formatter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Formatter {
    private final List<String> result = new LinkedList<>();
    private String sResult;

    public String choiceFormatter(String format, Set<String> keys, Map<String, String> commonData,
                                  Map<String, String> data1, Map<String, String> data2) {
        if (format.equals("stylish")) {
            sResult = whitespaceStylish(stylish(keys, commonData, data1, data2));
        }
        return sResult;
    }

    private List<String> stylish(Set<String> keys, Map<String, String> commonData, Map<String, String> data1,
                                 Map<String, String> data2) {

        for (String key : keys) {
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

    private String whitespaceStylish(List<String> list) {
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
}
