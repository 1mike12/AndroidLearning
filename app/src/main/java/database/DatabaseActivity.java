package database;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import main.BaseAppCompatActivity;
import mike.customview.R;

import java.util.List;

/**
 * Created by mike on 12/21/15.
 */
public class DatabaseActivity extends BaseAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_activity);

        DBHandler db = new DBHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.insertUser(new Contact("joe", "1@2.com"));
        db.insertUser(new Contact("blow", "1@2.com"));
        db.insertUser(new Contact("bob", "1@2.com"));
        db.insertUser(new Contact("doe", "1@2.com"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllUsers();

        String output = "";
        for (Contact contact : contacts) {
            output += "Id: " + contact._id + " ,Name: " + contact._name + " ,Phone: " + contact._email + "\n";
            // Writing Contacts to log
            Log.d("Name: ", output);
        }

        TextView text = (TextView) findViewById(R.id.loader_activity_output);
        text.setText(output);
    }
}