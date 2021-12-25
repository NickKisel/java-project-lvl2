package hexlet.code.Parser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public final class Parser {
    public Map<String, Object> getData(String filepath) throws Exception {
        String fileContent = Files.readString(Paths.get(filepath));
        ObjectMapper mapper;
        Map<String, Object> parseContent = null;
        if (filepath.contains(".json")) {
            mapper = new ObjectMapper(new JsonFactory());
            parseContent = mapper.readValue(fileContent, Map.class);
        } else if (filepath.contains(".yml") || filepath.contains(".yaml")) {
            mapper = new ObjectMapper(new YAMLFactory());
            parseContent = mapper.readValue(fileContent, Map.class);
        }
        return parseContent;
    }
}
