import jdk.jshell.EvalException;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SearchDriver
{
    public static void main(String[] args) throws IOException
    {
        String g = new String("files\\ssfssite.txt");
        File fP = new File(g);
        Search a = new Search(fP);
        try {
            int b = a.buildIndex(g);
            System.out.println(b+" web pages were processed and " + a.numWords() + " distinct words were found." );
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a query: ");
        String c = scan.nextLine();
        while (c != "")
        {
            Set<String> e = a.findQueryMatches(c);
            Iterator value = e.iterator();
            System.out.println("Here are your matches: ");
            while(value.hasNext())
            {
                System.out.println(value.next());
            }
            System.out.println("Please enter a query: ");
            c = scan.nextLine();
        }
        System.out.println("Goodbye!");
        return;
    }

}

