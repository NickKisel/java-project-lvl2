package hexlet.code;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedList;

public class InternalState {
    public static List<Node> getInternalState(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        List<Node> internalStateList = new LinkedList<>();
        for (String key : keys) {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key) != null && data2.get(key) != null && data1.get(key).equals(data2.get(key))
                        || data1.get(key) == data2.get(key)) {
                    internalStateList.add(new Node(key, "unchanged", data1.get(key)));
                } else if (data1.get(key) != null && data2.get(key) != null && !data1.get(key).equals(data2.get(key))
                        || data1.get(key) != data2.get(key)) {
                    internalStateList.add(new Node(key, "changed", data1.get(key), data2.get(key)));
                }
            } else if (!data2.containsKey(key) && data1.containsKey(key)) {
                internalStateList.add(new Node(key, "deleted", data1.get(key)));
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                internalStateList.add(new Node(key, "added", data2.get(key)));
            }
        }
        return internalStateList;
    }
}
