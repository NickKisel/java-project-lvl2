package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {
        String fileContent1 = Files.readString(Paths.get(filepath1));
        String fileContent2 = Files.readString(Paths.get(filepath2));

        Parser parser = new Parser();
        Map<String, Object> data1 = parser.getData(fileContent1, getExtension(filepath1));
        Map<String, Object> data2 = parser.getData(fileContent2, getExtension(filepath2));

        List<Node> commonData = StructureTree.getStructure(data1, data2);

        Formatter formatter = new Formatter();
        return formatter.choiceFormatter(formatName, commonData);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String getExtension(String filepath) {
        int i = filepath.lastIndexOf(".");
        return filepath.substring(i);
    }
}
