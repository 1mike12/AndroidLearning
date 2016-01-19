package fragment;

import android.os.Bundle;
import android.view.Menu;
import main.BaseAppCompatActivity;
import mike.customview.R;

public class StaticFragmentActivity extends BaseAppCompatActivity implements Fragment1.Callback {

    static String ACTIVITY_NAME = "Static Fragment activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_static);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lovely, menu);
        setTitle(ACTIVITY_NAME);
        return true;
    }

    @Override
    public void sendText(String string) {
        Fragment2 articleFrag = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        articleFrag.setString(string);
    }
}
