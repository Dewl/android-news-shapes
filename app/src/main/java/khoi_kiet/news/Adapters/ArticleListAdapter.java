package khoi_kiet.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * Created by hkhoi on 19/08/2015.
 */
public class ArticleListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> items;

    public ArticleListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return 10;
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
        convertView = LayoutInflater.from(context)
                .inflate(R.layout.layout_article_list_thumbnail, parent, false);
        final Item cur = items.get(position);
        ImageView photo = (ImageView) convertView.findViewById(R.id.iv_article_list_photo);
        TextView title = (TextView) convertView.findViewById(R.id.tv_article_thumbail_title);
        TextView des = (TextView) convertView.findViewById(R.id.tv_article_thumbanil_des);

        title.setText(cur.getTitle());
        des.setText(cur.getDescription());

        Picasso.with(context)
                .load(cur.getImg())
                .placeholder(R.drawable.thumbnail_wait)
                .error(R.drawable.thumnail_failed)
                .fit()
                .centerCrop()
                .into(photo);
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
