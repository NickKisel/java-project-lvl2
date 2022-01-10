package hexlet.code.Formatter;

import hexlet.code.Node;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Plain {

    public String getPlainFormat(List<Node> commonData) {
        List<String> result = new LinkedList<>();
        for (Node node : commonData) {
            if (node.getDescription().get("operation").equals("changed")) {
                result.add("Property '" + node.getKey() + "' was updated. From "
                        + getStringValuePlain(node.getDescription().get("value")) + " to "
                        + getStringValuePlain(node.getDescription().get("newValue")));
            } else if (node.getDescription().get("operation").equals("deleted")) {
                result.add("Property '" + node.getKey() + "' was removed");
            } else if (node.getDescription().get("operation").equals("added")) {
                result.add("Property '" + node.getKey() + "' was added with value: "
                        + getStringValuePlain(node.getDescription().get("value")));
            }
        }
        return result.stream()
                .map(x -> {
                    if (result.indexOf(x) == result.size() - 1) {
                        return x;
                    } else {
                        return x + "\n";
                    }
                })
                .collect(Collectors.joining());
    }

    private Object getStringValuePlain(Object value) {
        if (value instanceof Collection || value instanceof Map || value instanceof Array) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value;
    }
}
