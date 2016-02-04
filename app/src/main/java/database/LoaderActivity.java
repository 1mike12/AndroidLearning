package database;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.TextView;
import main.BaseAppCompatActivity;
import mike.customview.R;

import java.util.List;

/**
 * Created by mike on 1/15/16.
 */
public class LoaderActivity extends BaseAppCompatActivity implements LoaderManager.LoaderCallbacks<List<Contact>>{


    TextView text_;
    Loader<List<Contact>> loader_;
    private static int LOADER_ID = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_activity);

        text_ = (TextView) findViewById(R.id.database_activity_output);
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    private void requery(){
        getSupportLoaderManager().restartLoader(LOADER_ID, null, this);
    }

    @Override
    public Loader<List<Contact>> onCreateLoader(int id, Bundle args) {
        return new ContactsLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Contact>> loader, List<Contact> contacts) {
        String contactsString = "";

        for (Contact contact : contacts){
            contactsString += "\n "+ contact.toString();
        }
        text_.setText(contactsString);
    }

    @Override
    public void onLoaderReset(Loader<List<Contact>> loader) {

    }
}
