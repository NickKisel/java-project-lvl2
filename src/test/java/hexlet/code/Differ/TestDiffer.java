package hexlet.code.Differ;

import hexlet.code.Parser.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestDiffer {
    private Parser parser;

    @BeforeEach
    private void prepare() {
        parser = new Parser();
    }

    @Test
    void testDiffJson() throws Exception {
        String filepath1 = "file1.json";
        String filepath2 = "file2.json";
        String actual1 = Differ.generate(parser.getData(filepath1), parser.getData(filepath2));
        String expected1 = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertThat(expected1).isEqualTo(actual1);
    }

    @Test
    void testDiffYaml() throws  Exception {
        String filepath1 = "file1.yml";
        String filepath2 = "file2.yml";
        String expected1 = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        String actual1 = Differ.generate(parser.getData(filepath1), parser.getData(filepath2));
        assertThat(expected1).isEqualTo(actual1);
    }
}
