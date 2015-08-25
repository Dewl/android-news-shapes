package khoi_kiet.news.NewsUtilities;

/**
 * Created by hkhoi on 19/08/2015.
 */
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import khoi_kiet.news.Misc.Constants;

public class Rss24hAdapter implements RssAdapter {

    private static RssAdapter instance = null;

    private Rss24hAdapter() {
        // Nothing new, use your getInstance motherf*cker!!
    }

    /**
     *
     * @return instance of the adapter
     */
    public static RssAdapter getInstance() {
        if (instance == null) {
            instance = new Rss24hAdapter();
        }
        return instance;
    }

    @Override
    public ArrayList<Item> get(String url) throws IOException {
        // Get Document from link
        ArrayList<Item> toReturn = new ArrayList<>();
        Document doc
                = Jsoup.connect(url).parser(Parser.xmlParser()).get();
        // Get all items
        Elements items = doc.select(ITEM);
        for (Element item : items) {	// For each item
            String title = item.select(TITLE).text();	// Get title
            title = title.replace("&#34;", "\"");

            if (title.isEmpty()) {
                continue;
            }

            String description = // Get description
                    item.select(DESCRIPTION).text();
            // 1 is padding constant

            String img = item.select(Constants.SUMMARY_IMAGES).text();
            // get thumbnail image
            String date = item.select(DATE).text();		// Get publish date
            String link = item.select(LINK).text();		// Get link
            toReturn.add(new Item(title, img, description, date, link));
        }
        return toReturn;
    }
}