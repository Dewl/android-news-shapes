package khoi_kiet.news.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import khoi_kiet.news.Adapters.TabAdapter;
import khoi_kiet.news.Fragments.ArticleListFragment;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.R;

@SuppressWarnings("deprecation")

public class NewspaperActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ViewPager viewPager;
    private int newspaperId;
    private ArrayList<Fragment> fragments;
    private String[] categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newspaper);

        newspaperId = getIntent().getIntExtra(Constants.NEWSPAPER_ID, 0);
        categories = getResources().getStringArray(Constants.getCategoryMap().get(newspaperId));

        viewPager = (ViewPager) findViewById(R.id.vp_newspaper);
        refresh();


        actionBar = getSupportActionBar();
        String[] names = getResources().getStringArray(R.array.newspaper_names);
        actionBar.setTitle(names[newspaperId]);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i = 0; i < categories.length; ++i) {
            actionBar.addTab(actionBar.newTab().setText(categories[i]).setTabListener(new ActionBar.TabListener() {
                @Override
                public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

                }

                @Override
                public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

                }
            }));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void refresh() {
        fragments = new ArrayList<>();
        for (int i = 0; i < categories.length; ++i) {
            ArticleListFragment fragment = new ArticleListFragment();
//            fragment.setCategoryTabId(newspaperId * 100 + i);
            fragment.setNewspaperId(newspaperId);
            fragment.setTabId(newspaperId * 100 + i);                   // Set tabId here!
            fragments.add(fragment);
        }
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), fragments));
    }

    /**************************************************************************************
     * BEGIN: Actionbar Menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_newspaper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_refresh:
                refresh();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    /**************************************************************************************
     * END: Actionbar Menu
     */
}
