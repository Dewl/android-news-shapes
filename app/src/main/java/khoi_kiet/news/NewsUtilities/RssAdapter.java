package khoi_kiet.news.NewsUtilities;

/**
 * Created by hkhoi on 17/08/2015.
 */
import java.io.IOException;
import java.util.ArrayList;

public interface RssAdapter {

    static final String ITEM = "item";
    static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String DATE = "pubDate";
    static final String LINK = "link";
    static final String A = "a";
    static final String IMG = "img";
    static final String SRC = "src";

    /**
     *
     * @param url
     * @return An ArrayList of Item from VnExpress
     * @throws java.io.IOException
     */
    public ArrayList<Item> get(String url) throws IOException;
}
