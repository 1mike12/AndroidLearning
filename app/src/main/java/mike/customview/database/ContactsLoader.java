package mike.customview.database;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by mike on 1/15/16.
 */
public class ContactsLoader extends AsyncTaskLoader<List<Contact>> {

    String query_;

    public ContactsLoader(Context context, String query) {
        super(context);
        query_ = query;

        // super needed===========
        onContentChanged();
    }

    @Override
    public List<Contact> loadInBackground() {
        //find all users

        DBHandler db = new DBHandler(getContext());
        List<Contact> output;

        if (query_.equals("")) {
            output = db.getAllUsers();
        } else {
            output = db.getUsersWithNameLike(query_);
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return output;
    }

    //Optional methods, but totally need to call them for shit to work
    //==================================================================
    @Override
    protected void onStartLoading() {
        if (takeContentChanged()) {
            forceLoad();
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
}
