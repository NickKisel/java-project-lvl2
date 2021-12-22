package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {
    @Parameters(index = "filepath1", description = "path to first file")
    private Path filepath1;

    @Parameters(index = "filepath2", description = "path to second file")
    private Path filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Override
    public String call() throws Exception { // your business logic goes here...
        String fileContent1 = Files.readString(filepath1);
        String fileContent2 = Files.readString(filepath2);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> mapOfFile1 = mapper.readValue(fileContent1, HashMap.class);
        Map<String, String> mapOfFile2 = mapper.readValue(fileContent2, HashMap.class);
//        byte[] fileContents = Files.readAllBytes(file.toPath());
//        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
//        System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
        return fileContent1 + fileContent2;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}