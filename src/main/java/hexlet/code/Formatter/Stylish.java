package hexlet.code.Formatter;

import hexlet.code.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class Stylish {

    public String getStylishFormat(List<Node> commonData) {
        List<String> result = new LinkedList<>();
        for (Node node : commonData) {
            if (node.getOperation().equals("unchanged")) {
                result.add(node.getKey() + ": " + node.getValue());
            } else if (node.getOperation().equals("changed")) {
                result.add("- " + node.getKey() + ": " + node.getValue());
                result.add("+ " + node.getKey() + ": " + node.getValue2());
            } else if (node.getOperation().equals("deleted")) {
                result.add("- " + node.getKey() + ": " + node.getValue());
            } else if (node.getOperation().equals("added")) {
                result.add("+ " + node.getKey() + ": " + node.getValue());
            }
        }
        result.add(0, "{");
        result.add(result.size(), "}");
        return stylishToString(result);
    }

    private String stylishToString(List<String> list) {
        String whitespace = " ";
        final int countWhitespace = 4;
        return list.stream()
                .map(x -> {
                    if (x.startsWith("+") || x.startsWith("-")) {
                        return whitespace.repeat(2) + x + "\n";
                    } else if (x.startsWith("{")) {
                        return x + "\n";
                    } else if (x.startsWith("}")) {
                        return x;
                    } else {
                        return whitespace.repeat(countWhitespace) + x + "\n";
                    }
                })
                .collect(Collectors.joining());
    }
}
