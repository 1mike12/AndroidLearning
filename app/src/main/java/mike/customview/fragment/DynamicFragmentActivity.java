package mike.customview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import mike.customview.main.BaseAppCompatActivity;
import mike.customview.R;

public class DynamicFragmentActivity extends BaseAppCompatActivity implements Fragment1.Callback {

    public int count = 0;
    static String ACTIVITY_NAME = "Dynamic Frag activity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dynamic);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            Fragment1 firstFragment = new Fragment1();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, firstFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lovely, menu);
        setTitle(ACTIVITY_NAME);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void toggleFragment(View view) {
        count++;
        Fragment myFragment;
        if (count % 2 == 0) {
            myFragment = new Fragment1();
        } else {
            myFragment = new Fragment2();
        }
        // Create fragment and give it an argument specifying the article it should show
        Bundle args = new Bundle();
        myFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, myFragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void sendText(String text) {

    }

    public void onArticleSelected(String string) {
        Fragment2 articleFrag = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        articleFrag.setString(string);
    }
}
