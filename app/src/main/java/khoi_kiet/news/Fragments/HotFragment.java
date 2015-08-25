package khoi_kiet.news.Fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;

import khoi_kiet.news.Adapters.GridHotAdapter;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.NewsUtilities.Item;
import khoi_kiet.news.NewsUtilities.RssAdapter;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 17/08/2015.
 */
public class HotFragment extends Fragment {

    private GridView grid;
    private ProgressDialog dialog;

    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hot, container, false);
        grid = (GridView) v.findViewById(R.id.gv_fragment_hot);

        new BackgroundRetreiver().execute();

        return v;
    }

    private class BackgroundRetreiver extends AsyncTask<Void, Void, ArrayList<ArrayList<Item>>> {

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
        protected void onPostExecute(ArrayList<ArrayList<Item>> arrayLists) {
            super.onPostExecute(arrayLists);
            grid.setAdapter(new GridHotAdapter(getActivity(), arrayLists, getResources().getStringArray(R.array.newspaper_names)));
            dialog.dismiss();
        }

        @Override
        protected ArrayList<ArrayList<Item>> doInBackground(Void... params) {
            ArrayList<ArrayList<Item>> toReturn = new ArrayList<>();

            int newspapers = Constants.getThumbnailIds().size();
            RssAdapter adapter = null;
            for (int i = 0; i < newspapers; ++i) {
                adapter = Constants.getAdapterList().get(i);
                ArrayList<Item> items = new ArrayList<>(20);
                try {
                    items = adapter.get(Constants.getLinkMap().get(i * 100 + 1));
                    toReturn.add(items);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return toReturn;
        }
    }
}
