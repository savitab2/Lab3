import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */

    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {
        String findingWord = ("prince");
        boolean found = false;
        int counter = 0;
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        String[] words = urlToString("http://erdani.com/tdpl/hamlet.txt").split("");
        System.out.println(words.length);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(findingWord)) {
                found = true;
            }
            if (found) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}