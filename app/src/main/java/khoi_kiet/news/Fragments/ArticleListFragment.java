package khoi_kiet.news.Fragments;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import khoi_kiet.news.Adapters.ArticleListAdapter;
import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.NewsUtilities.Item;
import khoi_kiet.news.NewsUtilities.RssAdapter;
import khoi_kiet.news.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleListFragment extends Fragment {

    private int newspaperId;
    private int tabId;
    private ProgressDialog dialog;
    private ListView list;

    public ArticleListFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_article_list, container, false);
        list = (ListView) v.findViewById(R.id.lv_article_list);

        new BackgroundRetreiver().execute(newspaperId, tabId);

        return v;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }

    public void setNewspaperId(int newspaperId) {
        this.newspaperId = newspaperId;
    }

    private class BackgroundRetreiver extends AsyncTask<Integer, Void, ArrayList<Item>> {

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
            list.setAdapter(new ArticleListAdapter(getActivity(), items));
            dialog.dismiss();
        }

        @Override
        protected ArrayList<Item> doInBackground(Integer... params) {
            ArrayList<Item> toReturn = null;
            RssAdapter adapter = null;
            adapter = Constants.getAdapterList().get(params[0]);
            try {
                toReturn = adapter.get(Constants.getLinkMap().get(params[1]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return toReturn;
        }
    }
}
