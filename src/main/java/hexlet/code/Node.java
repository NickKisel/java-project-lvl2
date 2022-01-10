package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Node {
    private final String key;
    private final Map<String, Object> description;

    public String getKey() {
        return key;
    }

    public Map<String, Object> getDescription() {
        return description;
    }

    public Node(String setKey, String setOperation, Object setValue) {
        this.key = setKey;
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("operation", setOperation);
        map.put("value", setValue);
        this.description = map;
    }

    public Node(String setKey, String setOperation, Object setValue, Object setValue2) {
        this.key = setKey;
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("operation", setOperation);
        map.put("value", setValue);
        map.put("newValue", setValue2);
        this.description = map;
    }
}
