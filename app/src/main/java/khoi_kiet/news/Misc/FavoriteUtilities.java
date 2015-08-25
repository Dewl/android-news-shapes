package khoi_kiet.news.Misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hkhoi on 22/08/2015.
 */
public abstract class FavoriteUtilities {

    private static final String FAV_PATH = "/data/data/khoi_kiet.news/files/favorite";
    private static final int NUM = Constants.getCategory().size();
    private static boolean[] selected;

    public static void toggle(int a) throws IOException {
        if (selected == null) {
            loadSaved();
        }
        selected[a] = !selected[a];
    }

    public static boolean isSelected(int a) throws IOException {
        if (selected == null) {
            loadSaved();
        }
        return selected[a];
    }

    public static void commitSave() throws IOException {
        File saved = new File(FAV_PATH);
        saved.getParentFile().mkdirs();

        PrintWriter out = new PrintWriter(saved);

        for (int i = 0; i < NUM; ++i) {
            if (isSelected(i)) {
                out.println(i);
            }
        }
        out.close();
    }

    public static void loadSaved() throws IOException {
        if (selected == null) {
            selected = new boolean[NUM];
            File saved = new File(FAV_PATH);
            BufferedReader in =
                    new BufferedReader(new FileReader(saved));
            String curLine;
            while ((curLine = in.readLine()) != null) {
                int num = Integer.parseInt(curLine);
                selected[num] = true;
            }
        }
    }

    public static int getCount() {
        return NUM;
    }
}
