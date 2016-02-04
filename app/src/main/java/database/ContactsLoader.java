package database;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by mike on 1/15/16.
 */
public class ContactsLoader extends AsyncTaskLoader<List<Contact>> {

    public ContactsLoader(Context context) {
        super(context);
        // super needed===========
        onContentChanged();
    }
    @Override
    public List<Contact> loadInBackground() {
        //find all users

        DBHandler db = new DBHandler(getContext());
        return db.getAllUsers();
    }

    //Optional methods, but totally need to call them for shit to work
    //==================================================================
    @Override
    protected void onStartLoading() {
        if (takeContentChanged()){
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
}
