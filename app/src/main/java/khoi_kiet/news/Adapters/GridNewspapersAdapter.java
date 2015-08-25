package khoi_kiet.news.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

import java.util.ArrayList;

import khoi_kiet.news.Activities.NewspaperActivity;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 17/08/2015.
 */
public class GridNewspapersAdapter extends BaseAdapter {

    private  Context context;
    private ArrayList<Integer> list;

    public GridNewspapersAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.layout_newspaper_thumbnail, parent, false);
            FrameLayout frame = (FrameLayout) convertView.findViewById(R.id.fl_newspaper_thumbnail);
            frame.setBackgroundResource(list.get(position));
            frame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, NewspaperActivity.class);
                    intent.putExtra(Constants.NEWSPAPER_ID, position);
                    context.startActivity(intent);
                }
            });
        }
        return convertView;
    }
}
