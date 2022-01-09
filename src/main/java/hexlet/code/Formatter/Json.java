package hexlet.code.Formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Node;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Json {
    public String getJsonFormat(List<Node> commonData) {
        Map<String, Object> changed = new LinkedHashMap<>();
        Map<String, Object> deleted = new LinkedHashMap<>();
        Map<String, Object> added = new LinkedHashMap<>();
        Map<String, Map<String, Object>> resultMap = new LinkedHashMap<>();
        ObjectMapper writer = new ObjectMapper();
        for (Node node : commonData) {
            if (node.getOperation().equals("changed")) {
                changed.put(node.getKey(), Arrays.asList(node.getValue(), node.getValue2()));
            } else if (node.getOperation().equals("deleted")) {
                deleted.put(node.getKey(), node.getValue());
            } else if (node.getOperation().equals("added")) {
                added.put(node.getKey(), node.getValue());
            }
        }
        resultMap.put("changed", changed);
        resultMap.put("deleted", deleted);
        resultMap.put("added", added);
        String json = null;
        try {
            json = writer.writeValueAsString(resultMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String printJson = null;
        try {
            printJson = writer.writerWithDefaultPrettyPrinter().writeValueAsString(writer.readTree(json));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return printJson;
    }
}
