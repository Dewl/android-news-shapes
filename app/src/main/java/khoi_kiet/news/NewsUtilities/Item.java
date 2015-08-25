package khoi_kiet.news.NewsUtilities;

import java.io.Serializable;

/**
 * Created by hkhoi on 17/08/2015.
 */
public class Item implements Serializable {

    public static String ITEM = "item";
    public static String TITLE = "title";
    public static String LINK = "link";
    public static String DATE = "pubDate";
    private final String title;
    private final String img;
    private final String description;
    private final String date;
    private final String link;
    private final boolean favorite;

    /**
     *
     * @param title
     * @param img
     * @param description
     * @param date
     * @param link
     */
    public Item(String title, String img, String description, String date, String link) {
        this.title = title;
        this.img = img;
        this.description = description;
        this.date = date;
        this.link = link;
        favorite = false;
    }

    /**
     *
     * @return Title of the article
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return link to thumbnail photo
     */
    public String getImg() {
        return img;
    }

    /**
     *
     * @return article description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return publish date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @return link to article
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @return if the article is a favorite one
     */
    public boolean isFavorite() {
        return favorite;
    }
}
