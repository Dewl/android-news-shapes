package khoi_kiet.news.NewsUtilities;

/**
 * Created by hkhoi on 21/08/2015.
 */
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class RssVietNamNetAdapter implements RssAdapter {

    private static final String DES_MAR = "></a></br>";		// Description mark
    private static RssAdapter instance = null;

    private RssVietNamNetAdapter() {
        // Nothing new, use your getInstance motherf*cker!!
    }

    /**
     *
     * @return instance of the adapter
     */
    public static RssAdapter getInstance() {
        if (instance == null) {
            instance = new RssVietNamNetAdapter();
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
            String description1 = desRefined.text();
            String description2 = description1.replace("&nbsp;", "");
			/*String description = // Get description
					desRefined.*/

            Element thumb = desRefined.select(IMG).first();
//			String img = thumb.attr(SRC);
            StringBuilder builder = new StringBuilder(thumb.attr(SRC));
            builder.delete(builder.length() - 3, builder.length());
            builder.append("1000");
            String img = builder.toString();
// get thumbnail image
            String date = item.select(DATE).text();		// Get publish date
            String link = item.select(LINK).text();		// Get link
            toReturn.add(new Item(title, img, description2.replace("&amp;", "&"), date, link));
        }
        return toReturn;
    }
}

