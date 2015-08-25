package khoi_kiet.news.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import khoi_kiet.news.Activities.DetailsContentActivity;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.NewsUtilities.Item;
import khoi_kiet.news.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MagazinePageFragment extends Fragment {

    private Item item;

    public MagazinePageFragment() {
        // Required empty public constructor
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_magazine_page, container, false);

        ImageView cover = (ImageView) v.findViewById(R.id.iv_magazine_cover);
        TextView title = (TextView) v.findViewById(R.id.tv_magazine_title);
        TextView description = (TextView) v.findViewById(R.id.tv_magazine_description);

        Picasso.with(getActivity())
                .load(item.getImg())
                .fit()
                .centerCrop()
                .placeholder(R.drawable.thumbnail_wait2)
                .error(R.drawable.thumnail_failed)
                .into(cover);
        title.setText(item.getTitle());
        description.setText(item.getDescription());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsContentActivity.class);
                intent.putExtra(Constants.URL, item.getLink());
                intent.putExtra(Constants.TITLE, item.getTitle());
                intent.putExtra(Constants.DESCRIPTION, item.getDescription());
                getActivity().startActivity(intent);
            }
        });

        return v;
    }
}
