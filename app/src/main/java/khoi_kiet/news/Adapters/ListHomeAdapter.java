package khoi_kiet.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import khoi_kiet.news.Activities.DetailsContentActivity;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.NewsUtilities.Item;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 21/08/2015.
 */
public class ListHomeAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> items;

    public ListHomeAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater
                .from(context).inflate(R.layout.layout_homepage_title, parent, false);

        ImageView cover = (ImageView) convertView.findViewById(R.id.iv_home_cover);
        TextView title = (TextView) convertView.findViewById(R.id.tv_home_title);

        final Item cur = items.get(position);
        title.setText(cur.getTitle());

        convertView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.left2right));

        Picasso.with(context)
                .load(cur.getImg())
                .placeholder(R.drawable.thumbnail_wait2)
                .error(R.drawable.thumnail_failed)
                .fit()
                .centerCrop()
                .into(cover);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsContentActivity.class);
                intent.putExtra(Constants.URL, cur.getLink());
                intent.putExtra(Constants.TITLE, cur.getTitle());
                intent.putExtra(Constants.DESCRIPTION, cur.getDescription());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
