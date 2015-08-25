package khoi_kiet.news.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import khoi_kiet.news.Misc.FavoriteUtilities;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 22/08/2015.
 */
public class GridCategoryAdapter extends BaseAdapter {

    private Context context;
    private String[] names;
    private ArrayList<Integer> photoIds;

    public GridCategoryAdapter(Context context, String[] names, ArrayList<Integer> photoIds) {
        this.context = context;
        this.names = names;
        this.photoIds = photoIds;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater
                .from(context)
                .inflate(R.layout.layout_category, parent, false);

        final ImageView photo = (ImageView) convertView.findViewById(R.id.iv_category_photo);
        final TextView name = (TextView) convertView.findViewById(R.id.tv_category_name);
        final ImageView tick = (ImageView) convertView.findViewById(R.id.iv_tick);

        photo.setImageResource(photoIds.get(position));
        name.setText(names[position]);

        try {
            if (FavoriteUtilities.isSelected(position)) {
                photo.setColorFilter(R.color.Red);
                tick.setVisibility(View.VISIBLE);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (FavoriteUtilities.isSelected(position)) {
                        photo.clearColorFilter();
                        tick.setVisibility(View.GONE);

                    } else {
                        photo.setColorFilter(R.color.Red);
                        tick.setVisibility(View.VISIBLE);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    FavoriteUtilities.toggle(position);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return convertView;
    }
}
