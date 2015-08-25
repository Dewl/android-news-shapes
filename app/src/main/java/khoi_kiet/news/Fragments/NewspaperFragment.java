package khoi_kiet.news.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import khoi_kiet.news.Adapters.GridNewspapersAdapter;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 17/08/2015.
 */
public class NewspaperFragment extends Fragment {

    private GridView grid;

    public NewspaperFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_news_papers, container, false);
        grid = (GridView) view.findViewById(R.id.gv_newspapers);
        grid.setAdapter(new GridNewspapersAdapter(getActivity(), Constants.getThumbnailIds()));
        return view;
    }
}
