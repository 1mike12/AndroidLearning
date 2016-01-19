package database;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by mike on 1/15/16.
 */
public class ContactsLoader extends AsyncTaskLoader<List<Contact>> {

    public ContactsLoader(Context context) {
        super(context);
    }
    @Override
    public List<Contact> loadInBackground() {
        //find all users

        DBHandler db = new DBHandler(getContext());
        return db.getAllUsers();
    }
}
