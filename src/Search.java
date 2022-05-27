import java.io.*;
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

    public String cleanToken(String token) throws Exception
    {
        int ii;
        int jj;
        int aa;
        for (aa=0; aa<token.length();aa++)
        {
            char a;
            a = token.charAt(aa);
            if (isAlpha(Character.toString(a)))
            {
                break;
            }
        }
        if (aa == token.length())
        {
            return "";
        }
        for (ii = 0; ii<token.length();ii++)
        {
            char a;
            a = token.charAt(ii);
            if (!isPunct(Character.toString(a)))
            {
                break;
            }
        }
        for (jj = token.length()-1; jj>=0;jj--)
        {
            char a;
            a = token.charAt(jj);
            if (!isPunct(Character.toString(a)))
            {
                break;
            }
        }
        String s = token.substring(ii,jj+1);
       return s.toLowerCase();
    }

    public Map<String, Set<String>> getIndex() {
        return index;
    }

    public Set<String> gatherTokens(String bodyText) throws Exception
    {
        Set<String> words = new HashSet<>();
        String[] s = bodyText.split(" ");
        for (int ii = 0; ii<s.length;ii++)
        {
            String a = cleanToken(s[ii]);
            if (a != "")
            {
                words.add(a);
            }
        }
        return words;
    }

    public int buildIndex(String filename) throws Exception
    {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(filename));
        String url = reader.readLine();
        String lru;
        int numPages = 0;
        while (url != null) {
            numPages++;
            System.out.println(url);
             lru = reader.readLine();
             Set<String> rlu = gatherTokens(lru);
             String[] a = rlu.toArray(new String[0]);
             for (int ii = 0; ii<a.length; ii++)
             {
                 if (index.containsKey(a[ii]))
                 {
                     Set<String> b = index.get(a[ii]);
                     b.add(url);
                 }
                 else
                 {
                     Set<String> c = new HashSet<>();
                     c.add(url);
                     index.put(a[ii],c);
                 }
             }
            url = reader.readLine();
        }
        reader.close();

        return numPages;
    }

    public Set<String> findQueryMatches(String query)
    {
        Set<String> sites = new HashSet<>();
        if (index.containsKey(query))
        {
            sites = index.get(query);
        }
        return sites;
    }
    public int numWords()
    {
        return index.size();
    }


}
