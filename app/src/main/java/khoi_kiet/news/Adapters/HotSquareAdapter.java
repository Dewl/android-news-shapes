package khoi_kiet.news.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import khoi_kiet.news.NewsUtilities.Item;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 20/08/2015.
 */
public class HotSquareAdapter extends PagerAdapter {
    Context context;
    ArrayList<Item> items;
    String name;

    public HotSquareAdapter(Context context, ArrayList<Item> items, String name) {
        this.context = context;
        this.items = items;
        this.name = name;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.layout_hot_square_title, container, false);

        ImageView photo = (ImageView) v.findViewById(R.id.iv_hot_square);
        TextView title = (TextView) v.findViewById(R.id.tv_hot_square_name);

        Picasso.with(context)
                .load(items.get(position).getImg())
                .placeholder(R.drawable.thumbnail_wait)
                .error(R.drawable.thumnail_failed)
                .into(photo);
        title.setText(name);
        v.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in));
        container.addView(v, 0);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }
}
// Todo: Edit HotSquareAdapter