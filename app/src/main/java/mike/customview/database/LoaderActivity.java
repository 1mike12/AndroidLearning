package mike.customview.database;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import mike.customview.main.BaseAppCompatActivity;
import mike.customview.R;

import java.util.List;

/**
 * Created by mike on 1/15/16.
 */
public class LoaderActivity extends BaseAppCompatActivity implements LoaderManager.LoaderCallbacks<List<Contact>>{


    TextView text_;
    TextView query_;
    Button requery_;

    Loader<List<Contact>> loader_;
    ProgressBar progressCircle_;

    private static int LOADER_ID = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loader_activity);

        text_ = (TextView) findViewById(R.id.loader_activity_output);
        query_ = (EditText) findViewById(R.id.loader_activity_query);
        requery_ = (Button) findViewById(R.id.loader_activity_requery);
        requery_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reQuery();
            }
        });

        progressCircle_ = (ProgressBar) findViewById(R.id.database_activity_loader);

        getSupportLoaderManager().initLoader(LOADER_ID, null, this);
    }

    private void reQuery(){
        progressCircle_.setVisibility(View.VISIBLE);
        text_.setText("");
        getSupportLoaderManager().restartLoader(LOADER_ID, null, this);
    }

    @Override
    public Loader<List<Contact>> onCreateLoader(int id, Bundle args) {
        return new ContactsLoader(this, query_.getText().toString());
    }

    @Override
    public void onLoadFinished(Loader<List<Contact>> loader, List<Contact> contacts) {
        String contactsString = "";

        for (Contact contact : contacts){
            contactsString += "\n "+ contact.toStringContact();
        }
        text_.setText(contactsString);
        progressCircle_.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<List<Contact>> loader) {

    }
}
