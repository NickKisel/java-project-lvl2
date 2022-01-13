package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;

public class StructureTree {
    public static List<Node> getStructure(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        List<Node> structureList = new LinkedList<>();
        for (String key : keys) {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (!isChanged(data1.get(key), data2.get(key))) {
                    structureList.add(new Node(key, "unchanged", data1.get(key)));
                } else if (isChanged(data1.get(key), data2.get(key))) {
                    structureList.add(new Node(key, "changed", data1.get(key), data2.get(key)));
                }
            } else if (!data2.containsKey(key) && data1.containsKey(key)) {
                structureList.add(new Node(key, "deleted", data1.get(key)));
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                structureList.add(new Node(key, "added", data2.get(key)));
            }
        }
        return structureList;
    }

    private static boolean isChanged(Object value1, Object value2) {
        return (value1 == null || !value1.equals(value2)) && value1 != value2;
    }
}
