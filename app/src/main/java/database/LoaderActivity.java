package database;

import android.content.Loader;
import android.os.Bundle;
import android.widget.TextView;
import main.BaseAppCompatActivity;
import mike.customview.R;

/**
 * Created by mike on 1/15/16.
 */
public class LoaderActivity extends BaseAppCompatActivity implements android.app.LoaderManager.LoaderCallbacks{

    TextView text_ = (TextView) findViewById(R.id.database_activity_output);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_activity);

        DBHandler db = new DBHandler(this);
        db.insertUser(new Contact("joe", "1@2.com"));
        db.insertUser(new Contact("blow", "1@2.com"));
        db.insertUser(new Contact("bob", "1@2.com"));
        db.insertUser(new Contact("doe", "1@2.com"));

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new ContactsLoader(this);
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }

    @Override
    public void onLoaderReset(Loader loader) {

    }
}
