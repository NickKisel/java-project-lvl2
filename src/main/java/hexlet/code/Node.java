package hexlet.code;

public final class Node {
    private String key;
    private String operation;
    private Object value;
    private Object newValue;

    public String getKey() {
        return key;
    }

    public String getOperation() {
        return operation;
    }

    public Object getValue() {
        return value;
    }

    public Object getNewValue() {
        return newValue;
    }

    public Node(String setKey, String setOperation, Object setValue, Object setNewValue) {
        this.key = setKey;
        this.operation = setOperation;
        this.value = setValue;
        this.newValue = setNewValue;
    }

    public Node(String setKey, String setOperation, Object setValue) {
        this.key = setKey;
        this.operation = setOperation;
        this.value = setValue;
    }
}
