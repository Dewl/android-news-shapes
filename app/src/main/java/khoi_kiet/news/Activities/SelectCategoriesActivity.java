package khoi_kiet.news.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;

import khoi_kiet.news.Adapters.GridCategoryAdapter;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.Misc.FavoriteUtilities;
import khoi_kiet.news.R;

public class SelectCategoriesActivity extends AppCompatActivity {

    private GridView grid;
    private boolean[] selected;
    private String[] categories;
    private ArrayList<Integer> photoIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_categories);

        grid = (GridView) findViewById(R.id.gv_categories);
        categories = getResources().getStringArray(R.array.categories);
        photoIds = Constants.getCategoryPhotoIds();
        grid.setAdapter(new GridCategoryAdapter(this, categories, photoIds));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            FavoriteUtilities.commitSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_categories, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
