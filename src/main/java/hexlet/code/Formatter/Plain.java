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
            if (node.getOperation().equals("changed")) {
                result.add("Property '" + node.getKey() + "' was updated. From " + getStringValuePlain(node.getValue())
                        + " to " + getStringValuePlain(node.getValue2()));
            } else if (node.getOperation().equals("deleted")) {
                result.add("Property '" + node.getKey() + "' was removed");
            } else if (node.getOperation().equals("added")) {
                result.add("Property '" + node.getKey() + "' was added with value: "
                        + getStringValuePlain(node.getValue()));
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
