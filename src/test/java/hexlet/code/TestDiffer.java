package hexlet.code;

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
        final String filepath1 = "file1.json";
        final String filepath2 = "file2.json";
        final String format = "stylish";
        final String actual1 = Differ.generate(format, filepath1, filepath2);
        String expected1 = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void testDiffYaml() throws Exception {
        String filepath1 = "file1.yml";
        String filepath2 = "file2.yml";
        String format = "stylish";
        String expected1 = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        String actual1 = Differ.generate(format, filepath1, filepath2);
        assertThat(expected1).isEqualTo(actual1);
    }

    @Test
    void testDiffJsonPlain() throws Exception {
        String filepath1 = "file1.json";
        String filepath2 = "file2.json";
        String format = "plain";
        String actual1 = Differ.generate(format, filepath1, filepath2);
        String expected1 = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'
                """;
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void testDiffYamlPlain() throws Exception {
        String filepath1 = "file1.yml";
        String filepath2 = "file2.yml";
        String format = "plain";
        String expected1 = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'
                """;
        String actual1 = Differ.generate(format, filepath1, filepath2);
        assertThat(expected1).isEqualTo(actual1);
    }

    @Test
    void testDiffJsonJson() throws Exception {
        String filepath1 = "file1.json";
        String filepath2 = "file2.json";
        String format = "json";
        String expected1 = """
                {
                  "changed" : {
                    "chars2" : false,
                    "checked" : true,
                    "default" : [ "value1", "value2" ],
                    "id" : null,
                    "numbers2" : [ 22, 33, 44, 55 ],
                    "setting1" : "Another value",
                    "setting2" : 300,
                    "setting3" : "none"
                  },
                  "deleted" : {
                    "key1" : "value1",
                    "numbers3" : [ 3, 4, 5 ]
                  },
                  "added" : {
                    "key2" : "value2",
                    "numbers4" : [ 4, 5, 6 ],
                    "obj1" : {
                      "nestedKey" : "value",
                      "isNested" : true
                    }
                  }
                }""";
        String actual1 = Differ.generate(format, filepath1, filepath2);
        assertThat(expected1).isEqualTo(actual1);
    }
}
