package hexlet.code;

public final class Node {
    private final String key;
    private final String operation;
    private final Object value;
    private final Object value2;

    public String getKey() {
        return this.key;
    }

    public String getOperation() {
        return this.operation;
    }

    public Object getValue() {
        return this.value;
    }

    public Object getValue2() {
        return this.value2;
    }

    public Node(String setKey, String setOperation, Object setValue) {
        this.key = setKey;
        this.operation = setOperation;
        this.value = setValue;
        value2 = null;
    }

    public Node(String setKey, String setOperation, Object setValue, Object setValue2) {
        this.key = setKey;
        this.operation = setOperation;
        this.value = setValue;
        this.value2 = setValue2;
    }
}
