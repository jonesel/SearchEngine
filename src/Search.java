import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Search {

    private File site;
    private Map<String, Set<String>> index = new HashMap<>();

    public Search(File filename) throws IOException {
        site = filename;
    }

    /**
     * Provided helper method to be used in the solution of the cleanToken method.
     * @param s - a string of length 1.
     * @return true if the string is alphabetic, false if it is not.
     * @throws Exception - String must be of length 1
     */
    public boolean isAlpha(String s) throws Exception {
        if (s.length() > 1)
            throw new Exception("String must only be 1 character.");
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        return alpha.contains(s);
    }

    /**
     * Provided helper method to be used in the solution of the cleanToken method.
     * @param s a string of length 1.
     * @return true if the given character is a punctuation symbol, false if it is not.
     * @throws Exception String must be of length 1
     */
    public boolean isPunct(String s) throws Exception {
        if (s.length() > 1)
            throw new Exception("String must only be 1 character.");
        String punct = "!@#$%^&*()~`-_=+{}[]|\\\"';:,<.>/? ";
        return punct.contains(s);
    }

    public String cleanToken(String token) throws Exception {
       return "";
    }

    public Map<String, Set<String>> getIndex() {
        return index;
    }

    public Set<String> gatherTokens(String bodyText) throws Exception {
        Set<String> words = new HashSet<>();

        return words;
    }

    public int buildIndex(String filename) throws Exception {
        return 0;
    }

    public Set<String> findQueryMatches(String query) {
        Set<String> sites = new HashSet<>();


        return sites;
    }


}
