package hexlet.code;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public final class Parser {
    public Map<String, Object> getData(String fileContent, String fileExtension) throws Exception {
        ObjectMapper mapper;
        Map<String, Object> parseContent = null;
        if (fileExtension.equals(".json")) {
            mapper = new ObjectMapper(new JsonFactory());
            parseContent = mapper.readValue(fileContent, Map.class);
        } else if (fileExtension.equals(".yml") || fileExtension.equals(".yaml")) {
            mapper = new ObjectMapper(new YAMLFactory());
            parseContent = mapper.readValue(fileContent, Map.class);
        }
        return parseContent;
    }
}
