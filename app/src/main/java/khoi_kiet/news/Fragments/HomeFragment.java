package khoi_kiet.news.Fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import java.io.IOException;
import java.util.ArrayList;

import khoi_kiet.news.Adapters.ListHomeAdapter;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.Misc.FavoriteUtilities;
import khoi_kiet.news.NewsUtilities.Item;
import khoi_kiet.news.NewsUtilities.RssAdapter;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 17/08/2015.
 */
public class HomeFragment extends Fragment {

    private ListView listView;
    private ProgressDialog dialog;
    private RelativeLayout nothing;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) v.findViewById(R.id.lv_home);
        nothing = (RelativeLayout) v.findViewById(R.id.rl_nothing);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ArrayList<Integer> favIds = new ArrayList<>();

        for (int i = 0; i < FavoriteUtilities.getCount(); ++i) {
            try {
                if (FavoriteUtilities.isSelected(i)) {
                    favIds.addAll(Constants.getCategory().get(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        new BackgroundRetreiver().execute(favIds);
        if (favIds.isEmpty()) {
            nothing.setVisibility(View.VISIBLE);
        } else {
            nothing.setVisibility(View.GONE);
        }
    }

    private class BackgroundRetreiver extends AsyncTask<ArrayList<Integer>, Void, ArrayList<Item>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                if (dialog == null) {
                    dialog = new ProgressDialog(getActivity());
                    dialog.setMessage(getResources().getString(R.string.please_wait));
                }
                dialog.show();
            } catch (Exception e) {

            }
        }

        @Override
        protected void onPostExecute(ArrayList<Item> items) {
            super.onPostExecute(items);
            listView.setAdapter(new ListHomeAdapter(getActivity(), items));

            dialog.dismiss();
        }

        @Override
        protected ArrayList<Item> doInBackground(ArrayList<Integer>... params) {
            ArrayList<Item> items = new ArrayList<>();

            for (int id : params[0]) {
                RssAdapter adapter = Constants.getAdapterList().get(id / 100);
                String link = Constants.getLinkMap().get(id);
                try {
                    items.addAll(adapter.get(link));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return items;
        }
    }
}