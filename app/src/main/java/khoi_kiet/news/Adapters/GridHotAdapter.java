package khoi_kiet.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;

import java.util.ArrayList;

import khoi_kiet.news.Activities.MagazineActivity;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.NewsUtilities.Item;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 20/08/2015.
 */
public class GridHotAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ArrayList<Item>> listItems;
    private String[] names;

    private int newspaperId;
    private int currentPage;


    public GridHotAdapter(Context context, ArrayList<ArrayList<Item>> listItems, String[] names) {
        this.context = context;
        this.listItems = listItems;
        this.names = names;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater
                .from(context)
                .inflate(R.layout.layout_hot_square, parent, false);

        final ViewPager pager = (ViewPager) convertView.findViewById(R.id.vp_hot_square);
        pager.setPageTransformer(true, new FlipHorizontalTransformer());
        pager.setAdapter(new HotSquareAdapter(context, listItems.get(position), names[position]));

        // Todo: Implement onClickListener here

        final GestureDetectorCompat tabDetector =
                new GestureDetectorCompat(context, new TapGestureListener());
        pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tabDetector.onTouchEvent(event);
                currentPage = pager.getCurrentItem();
                newspaperId = position;
                return false;
            }
        });

        return convertView;
    }

    private class TapGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Intent intent = new Intent(context, MagazineActivity.class);
            intent.putExtra(Constants.HOT_SQUARE_POS, currentPage);
            intent.putExtra(Constants.ITEM_LIST, listItems.get(newspaperId));
            context.startActivity(intent);
            return true;
        }
    }
}