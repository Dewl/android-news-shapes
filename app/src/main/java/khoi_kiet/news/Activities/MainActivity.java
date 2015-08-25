package khoi_kiet.news.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;

import khoi_kiet.news.Adapters.TabAdapter;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.R;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ViewPager viewPager;
    private ProgressDialog dialog;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new BackgroundInitializer().execute();

        context = this;
        String[] tabNames = getResources().getStringArray(R.array.tab_names);

        viewPager = (ViewPager) findViewById(R.id.vp_main);
        refresh();
        viewPager.setPageTransformer(true, new CubeOutTransformer());

        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (String tabName : tabNames) {
            actionBar.addTab(actionBar.newTab()
                    .setText(tabName)
                    .setTabListener(new ActionBar.TabListener() {
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
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), Constants.getFragments()));
    }

    /**********************************************************************************************
     * BEGIN: ACTIONBAR MENU
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_favorite:
                Intent intent = new Intent(this, SelectCategoriesActivity.class);
                startActivity(intent);
                break;
            case R.id.action_refresh:
                refresh();
                break;
            case R.id.action_exit:
                finish();
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**********************************************************************************************
     * END: ACTIONBAR MENU
     */

    private class BackgroundInitializer extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            Constants.initialize();
            return null;
        }
    }
}
