package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestDiffer {
    private final String filepath0 = "build/resources/test/fixtures/";

    @Test
    void testDiffJsonDefault() throws Exception {
        String filepath1 = filepath0 + "file1.json";
        String filepath2 = filepath0 + "file2.json";
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
        assertThat(Differ.generate(filepath1, filepath2)).isEqualTo(expected1);
    }

    @Test
    void testDiffYamlDefault() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
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
        assertThat(Differ.generate(filepath1, filepath2)).isEqualTo(expected1);
    }

    @Test
    void testDiffJsonStylish() throws Exception {
        String filepath1 = filepath0 + "file1.json";
        String filepath2 = filepath0 + "file2.json";
        String formatName = "stylish";
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
        assertThat(Differ.generate(filepath1, filepath2, formatName)).isEqualTo(expected1);
    }

    @Test
    void testDiffYamlStylish() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
        String formatName = "stylish";
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
        assertThat(Differ.generate(filepath1, filepath2, formatName)).isEqualTo(expected1);
    }

    @Test
    void testDiffJsonPlain() throws Exception {
        String filepath1 = filepath0 + "file1.json";
        String filepath2 = filepath0 + "file2.json";
        String formatName = "plain";
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
                Property 'setting3' was updated. From true to 'none'""";
        assertThat(Differ.generate(filepath1, filepath2, formatName)).isEqualTo(expected1);
    }

    @Test
    void testDiffYamlPlain() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
        String formatName = "plain";
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
                Property 'setting3' was updated. From true to 'none'""";
        assertThat(Differ.generate(filepath1, filepath2, formatName)).isEqualTo(expected1);
    }

    @Test
    void testDiffJsonJson() throws Exception {
        String filepath1 = filepath0 + "file1.json";
        String filepath2 = filepath0 + "file2.json";
        String formatName = "json";
        String expected1 = """
                {
                  "changed" : {
                    "chars2" : [ [ "d", "e", "f" ], false ],
                    "checked" : [ false, true ],
                    "default" : [ null, [ "value1", "value2" ] ],
                    "id" : [ 45, null ],
                    "numbers2" : [ [ 2, 3, 4, 5 ], [ 22, 33, 44, 55 ] ],
                    "setting1" : [ "Some value", "Another value" ],
                    "setting2" : [ 200, 300 ],
                    "setting3" : [ true, "none" ]
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

        assertThat(Differ.generate(filepath1, filepath2, formatName)).isEqualTo(expected1);
    }

    @Test
    void testDiffYamlJson() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
        String formatName = "json";
        String expected1 = """
                {
                  "changed" : {
                    "chars2" : [ [ "d", "e", "f" ], false ],
                    "checked" : [ false, true ],
                    "default" : [ null, [ "value1", "value2" ] ],
                    "id" : [ 45, null ],
                    "numbers2" : [ [ 2, 3, 4, 5 ], [ 22, 33, 44, 55 ] ],
                    "setting1" : [ "Some value", "Another value" ],
                    "setting2" : [ 200, 300 ],
                    "setting3" : [ true, "none" ]
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

        assertThat(Differ.generate(filepath1, filepath2, formatName)).isEqualTo(expected1);
    }
}
