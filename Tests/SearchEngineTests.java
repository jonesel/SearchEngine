import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchEngineTests {
    private static Search s;

    @BeforeAll
    static void setup() throws IOException {
        s = new Search(new File("files/tiny.txt"));
    }


    @Test
    public void cleanTokenTests() throws Exception {
        assertEquals("pizza", s.cleanToken("!pizza @ "));
        assertEquals("section", s.cleanToken("<<section>>"));
        assertEquals("section-10", s.cleanToken("section-10"));
    }

    @Test
    public void gatherTokensTest() throws Exception {
        Set<String> expected = new HashSet<>();
        String listOfWords = "pizza with cheese is !!delicious!. pizza with anchovies is -gross()";
        expected.add("pizza");
        expected.add("with");
        expected.add("cheese");
        expected.add("is");
        expected.add("delicious");
        expected.add("anchovies");
        expected.add("gross");
        assertEquals(expected, s.gatherTokens(listOfWords));
    }

    @Test
    public void buildIndexTest() throws Exception {
        assertEquals(4, s.buildIndex("files/tiny.txt"));
    }

    @Test
    public void findQueryMatchesTest() throws Exception {
        s.buildIndex("files/website.txt");
        Set<String> expected = new HashSet<>();
        expected.add("http://cs106b.stanford.edu/assignments/assign2/searchengine.html");
        assertEquals(expected, s.findQueryMatches("llama"));
    }

}
