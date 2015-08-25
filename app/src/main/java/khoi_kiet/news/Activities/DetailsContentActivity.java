package khoi_kiet.news.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import khoi_kiet.news.Misc.Constants;
import khoi_kiet.news.R;

import static android.webkit.WebSettings.*;

@SuppressWarnings("deprecation")
public class DetailsContentActivity extends AppCompatActivity {

    private WebView webView;
    private String url;
    private String description;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_content);

        Intent intent = getIntent();

        url = intent.getStringExtra(Constants.URL);
        description = intent.getStringExtra(Constants.DESCRIPTION);
        title = intent.getStringExtra(Constants.TITLE);

        webView = (WebView) findViewById(R.id.wv_details_content);
        webView.getSettings().setUserAgentString(Constants.USER_AGENT);
        webView.getSettings().setRenderPriority(RenderPriority.HIGH);
        webView.getSettings().setCacheMode(LOAD_NO_CACHE);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(new WebViewClient());
        webView.clearCache(true);
        webView.getSettings().setAppCacheEnabled(false);
        webView.clearHistory();

        getSupportActionBar().setTitle(title);

        webView.loadUrl(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_share:
                share();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        StringBuilder sb = new StringBuilder();

        sb.append(title);
        sb.append("\n");
        sb.append(description);
        sb.append("\n");
        sb.append(url);

        intent.putExtra(Intent.EXTRA_TEXT, sb.toString());
        startActivity(intent);
    }
}
