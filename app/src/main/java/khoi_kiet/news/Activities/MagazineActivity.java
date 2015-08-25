package khoi_kiet.news.Activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import khoi_kiet.news.Adapters.MagazineAdapter;
import khoi_kiet.news.Fragments.MagazinePageFragment;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.NewsUtilities.Item;
import khoi_kiet.news.R;

public class MagazineActivity extends AppCompatActivity {

    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);

        pager = (ViewPager) findViewById(R.id.vp_magazine);
        Intent intent = getIntent();
        ArrayList<Item> items = (ArrayList<Item>) intent
                .getSerializableExtra(Constants.ITEM_LIST);
        int position = intent.getIntExtra(Constants.HOT_SQUARE_POS, 0);

        ArrayList<MagazinePageFragment> pages = new ArrayList<>();
        for (Item item : items) {
            MagazinePageFragment cur = new MagazinePageFragment();
            cur.setItem(item);
            pages.add(cur);
        }

        pager.setAdapter(new MagazineAdapter(getSupportFragmentManager(), pages));
        pager.setCurrentItem(position);
        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_magazine, menu);
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
