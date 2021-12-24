package hexlet.code.Differ;

import hexlet.code.App;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestDiffer {

    @Test
    void testDiff1() throws Exception {
        String content1 = """
                {
                  "host": "hexlet.io",
                  "timeout": 50,
                  "proxy": "123.234.53.22",
                  "follow": false
                }""";
        String content2 = """
                {
                  "timeout": 20,
                  "verbose": true,
                  "host": "hexlet.io"
                }""";
        String actual = Differ.generate(App.getData(content1), App.getData(content2));
        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertThat(expected).isEqualTo(actual);
    }
}
