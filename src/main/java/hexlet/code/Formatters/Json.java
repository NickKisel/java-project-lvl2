package hexlet.code.Formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import hexlet.code.Formatters.CustomSerializer.NodeSerializer;
import hexlet.code.Node;

import java.util.List;

public class Json {
    public static String getJsonFormat(List<Node> commonData) {
        ObjectMapper writer = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Node.class, new NodeSerializer());
        writer.registerModule(module);
        String printJson = null;
        try {
            printJson = writer.writerWithDefaultPrettyPrinter().writeValueAsString(commonData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return printJson;
    }
}
