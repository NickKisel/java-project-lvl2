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
                [ {
                  "key" : "chars1",
                  "description" : {
                    "operation" : "unchanged",
                    "value" : [ "a", "b", "c" ]
                  }
                }, {
                  "key" : "chars2",
                  "description" : {
                    "operation" : "changed",
                    "value" : [ "d", "e", "f" ],
                    "newValue" : false
                  }
                }, {
                  "key" : "checked",
                  "description" : {
                    "operation" : "changed",
                    "value" : false,
                    "newValue" : true
                  }
                }, {
                  "key" : "default",
                  "description" : {
                    "operation" : "changed",
                    "value" : null,
                    "newValue" : [ "value1", "value2" ]
                  }
                }, {
                  "key" : "id",
                  "description" : {
                    "operation" : "changed",
                    "value" : 45,
                    "newValue" : null
                  }
                }, {
                  "key" : "key1",
                  "description" : {
                    "operation" : "deleted",
                    "value" : "value1"
                  }
                }, {
                  "key" : "key2",
                  "description" : {
                    "operation" : "added",
                    "value" : "value2"
                  }
                }, {
                  "key" : "numbers1",
                  "description" : {
                    "operation" : "unchanged",
                    "value" : [ 1, 2, 3, 4 ]
                  }
                }, {
                  "key" : "numbers2",
                  "description" : {
                    "operation" : "changed",
                    "value" : [ 2, 3, 4, 5 ],
                    "newValue" : [ 22, 33, 44, 55 ]
                  }
                }, {
                  "key" : "numbers3",
                  "description" : {
                    "operation" : "deleted",
                    "value" : [ 3, 4, 5 ]
                  }
                }, {
                  "key" : "numbers4",
                  "description" : {
                    "operation" : "added",
                    "value" : [ 4, 5, 6 ]
                  }
                }, {
                  "key" : "obj1",
                  "description" : {
                    "operation" : "added",
                    "value" : {
                      "nestedKey" : "value",
                      "isNested" : true
                    }
                  }
                }, {
                  "key" : "setting1",
                  "description" : {
                    "operation" : "changed",
                    "value" : "Some value",
                    "newValue" : "Another value"
                  }
                }, {
                  "key" : "setting2",
                  "description" : {
                    "operation" : "changed",
                    "value" : 200,
                    "newValue" : 300
                  }
                }, {
                  "key" : "setting3",
                  "description" : {
                    "operation" : "changed",
                    "value" : true,
                    "newValue" : "none"
                  }
                } ]""";
        assertThat(Differ.generate(filepath1, filepath2, formatName)).isEqualTo(expected1);
    }

    @Test
    void testDiffYamlJson() throws Exception {
        String filepath1 = filepath0 + "file1.yml";
        String filepath2 = filepath0 + "file2.yml";
        String formatName = "json";
        String expected1 = """
                [ {
                  "key" : "chars1",
                  "description" : {
                    "operation" : "unchanged",
                    "value" : [ "a", "b", "c" ]
                  }
                }, {
                  "key" : "chars2",
                  "description" : {
                    "operation" : "changed",
                    "value" : [ "d", "e", "f" ],
                    "newValue" : false
                  }
                }, {
                  "key" : "checked",
                  "description" : {
                    "operation" : "changed",
                    "value" : false,
                    "newValue" : true
                  }
                }, {
                  "key" : "default",
                  "description" : {
                    "operation" : "changed",
                    "value" : null,
                    "newValue" : [ "value1", "value2" ]
                  }
                }, {
                  "key" : "id",
                  "description" : {
                    "operation" : "changed",
                    "value" : 45,
                    "newValue" : null
                  }
                }, {
                  "key" : "key1",
                  "description" : {
                    "operation" : "deleted",
                    "value" : "value1"
                  }
                }, {
                  "key" : "key2",
                  "description" : {
                    "operation" : "added",
                    "value" : "value2"
                  }
                }, {
                  "key" : "numbers1",
                  "description" : {
                    "operation" : "unchanged",
                    "value" : [ 1, 2, 3, 4 ]
                  }
                }, {
                  "key" : "numbers2",
                  "description" : {
                    "operation" : "changed",
                    "value" : [ 2, 3, 4, 5 ],
                    "newValue" : [ 22, 33, 44, 55 ]
                  }
                }, {
                  "key" : "numbers3",
                  "description" : {
                    "operation" : "deleted",
                    "value" : [ 3, 4, 5 ]
                  }
                }, {
                  "key" : "numbers4",
                  "description" : {
                    "operation" : "added",
                    "value" : [ 4, 5, 6 ]
                  }
                }, {
                  "key" : "obj1",
                  "description" : {
                    "operation" : "added",
                    "value" : {
                      "nestedKey" : "value",
                      "isNested" : true
                    }
                  }
                }, {
                  "key" : "setting1",
                  "description" : {
                    "operation" : "changed",
                    "value" : "Some value",
                    "newValue" : "Another value"
                  }
                }, {
                  "key" : "setting2",
                  "description" : {
                    "operation" : "changed",
                    "value" : 200,
                    "newValue" : 300
                  }
                }, {
                  "key" : "setting3",
                  "description" : {
                    "operation" : "changed",
                    "value" : true,
                    "newValue" : "none"
                  }
                } ]""";
        assertThat(Differ.generate(filepath1, filepath2, formatName)).isEqualTo(expected1);
    }
}
