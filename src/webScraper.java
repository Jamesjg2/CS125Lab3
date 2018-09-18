import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class webScraper {

    public static void main(String[] args) {
        System.out.println("First Web Page Word Count: " + webScraper.wordCount("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println("Second Web Page Word Count: " + webScraper.wordCount("https://www.bls.gov/tus/charts/chart9.txt"));
        System.out.println("Third Web Page Word Count: " + webScraper.wordCount("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"));
        System.out.println("Number of times Prince is said in Hamlet: " + webScraper.specificWord("http://erdani.com/tdpl/hamlet.txt","prince"));
    }

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

    public static int wordCount(final String url) {
        String[] contents = webScraper.urlToString(url).split("\\s+");
        return contents.length;
    }
    public static int specificWord(final String url, final String search) {
        int count = 0;
        String[] contents = webScraper.urlToString(url).split("\\s+");
        for(int i = 0; i < contents.length; i++) {
            if (contents[i].equalsIgnoreCase(search)) {
                count++;
            }
        }
        return count;
    }
}
