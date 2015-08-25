package khoi_kiet.news.NewsUtilities;

/**
 * Created by hkhoi on 23/08/2015.
 */
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class RssDoiSongPhapLuatAdapter implements RssAdapter {

    private static final String DES_MAR = "></a></br>";		// Description mark
    private static RssAdapter instance = null;

    private RssDoiSongPhapLuatAdapter() {
        // Nothing new, use your getInstance motherf*cker!!
    }

    /**
     *
     * @return instance of the adapter
     */
    public static RssAdapter getInstance() {
        if (instance == null) {
            instance = new RssDoiSongPhapLuatAdapter();
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

            if (title.isEmpty()) {
                continue;
            }

            Element desRaw = item.select(DESCRIPTION).first();
            Element desRefined = Jsoup.parse(desRaw.text(), "", Parser.xmlParser());
            String desRefinedText = desRefined.text();
            String description = // Get description
                    desRefinedText.substring(desRefinedText.indexOf("(DSPL)") + 1);
            // 1 is padding constant
            Element thumb = desRefined.select(A).first().select(IMG).first();
            String img = thumb.attr(SRC);
            // get thumbnail image
            String date = item.select(DATE).text();		// Get publish date
            String link = item.select(LINK).text();		// Get link
            toReturn.add(new Item(title, img, description, date, link));
        }
        return toReturn;
    }
}
