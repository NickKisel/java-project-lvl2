package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class TestDiffer {

    private final String filepath0 = "build/resources/test/fixtures/";

    private String getContent(String filepath) throws IOException {
        return Files.readString(Paths.get(filepath0 + filepath));
    }

    @Test
    void testDiffJsonDefault() throws Exception {
        String filepath1 = filepath0 + "file1.json";
        String filepath2 = filepath0 + "file2.json";
        assertThat(Differ.generate(filepath1, filepath2))
                .isEqualTo(getContent("StylishExpected.txt"));
    }

    @Test
    void testDiffYamlDefault() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
        assertThat(Differ.generate(filepath1, filepath2))
                .isEqualTo(getContent("StylishExpected.txt"));
    }

    @Test
    void testDiffJsonStylish() throws Exception {
        String filepath1 = filepath0 + "file1.json";
        String filepath2 = filepath0 + "file2.json";
        String formatName = "stylish";
        assertThat(Differ.generate(filepath1, filepath2, formatName))
                .isEqualTo(getContent("StylishExpected.txt"));
    }

    @Test
    void testDiffYamlStylish() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
        String formatName = "stylish";
        assertThat(Differ.generate(filepath1, filepath2, formatName))
                .isEqualTo(getContent("StylishExpected.txt"));
    }

    @Test
    void testDiffJsonPlain() throws Exception {
        String filepath1 = filepath0 + "file1.json";
        String filepath2 = filepath0 + "file2.json";
        String formatName = "plain";
        assertThat(Differ.generate(filepath1, filepath2, formatName))
                .isEqualTo(getContent("PlainExpected.txt"));
    }

    @Test
    void testDiffYamlPlain() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
        String formatName = "plain";
        assertThat(Differ.generate(filepath1, filepath2, formatName))
                .isEqualTo(getContent("PlainExpected.txt"));
    }

    @Test
    void testDiffJsonJson() throws Exception {
        String filepath1 = filepath0 + "file1.json";
        String filepath2 = filepath0 + "file2.json";
        String formatName = "json";
        assertThat(Differ.generate(filepath1, filepath2, formatName))
                .isEqualTo(getContent("JsonExpected.txt"));
    }

    @Test
    void testDiffYamlJson() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
        String formatName = "json";
        assertThat(Differ.generate(filepath1, filepath2, formatName))
                .isEqualTo(getContent("JsonExpected.txt"));
    }
}
