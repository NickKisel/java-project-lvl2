package hexlet.code.Formatters.CustomSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import hexlet.code.Node;

import java.io.IOException;

public final class NodeSerializer extends StdSerializer<Node> {

    public NodeSerializer() {
        this(null);
    }

    public NodeSerializer(Class<Node> t) {
        super(t);
    }

    @Override
    public void serialize(Node value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("key", value.getKey());
        gen.writeStringField("operation", value.getOperation());
        gen.writeObjectField("value", value.getValue());
        if (value.getOperation().equals("changed")) {
            gen.writeObjectField("newValue", value.getNewValue());
        }
        gen.writeEndObject();
    }
}
