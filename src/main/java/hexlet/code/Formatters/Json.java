package hexlet.code.Formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Node;

import java.util.List;

public final class Json {
    public String getJsonFormat(List<Node> commonData) {
        ObjectMapper writer = new ObjectMapper();
        String printJson = null;
        try {
            printJson = writer.writerWithDefaultPrettyPrinter().writeValueAsString(commonData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return printJson;
    }
}
