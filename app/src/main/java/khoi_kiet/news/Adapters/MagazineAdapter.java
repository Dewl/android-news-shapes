package khoi_kiet.news.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import khoi_kiet.news.Fragments.MagazinePageFragment;

/**
 * Created by hkhoi on 20/08/2015.
 */
public class MagazineAdapter extends FragmentPagerAdapter {

    ArrayList<MagazinePageFragment> pages;

    public MagazineAdapter(FragmentManager fm, ArrayList<MagazinePageFragment> pages) {
        super(fm);
        this.pages = pages;
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
}
