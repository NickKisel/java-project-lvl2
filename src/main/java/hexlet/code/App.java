package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ.Differ;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    @Parameters(index = "0", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Override
    public final Integer call() throws Exception {
        String fileContent1 = Files.readString(Paths.get(filepath1));
        String fileContent2 = Files.readString(Paths.get(filepath2));
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapOfFile1 = mapper.readValue(fileContent1, Map.class);
        Map<String, Object> mapOfFile2 = mapper.readValue(fileContent2, Map.class);
        String differ = Differ.generate(mapOfFile1, mapOfFile2);
        System.out.println(differ);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
