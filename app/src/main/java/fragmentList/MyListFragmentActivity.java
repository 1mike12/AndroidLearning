package fragmentList;

import android.os.Bundle;
import android.view.View;
import main.BaseAppCompatActivity;
import mike.customview.R;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by 1mike12 on 10/14/2015.
 */
public class MyListFragmentActivity extends BaseAppCompatActivity {
    public int count = 0;
    static String ACTIVITY_NAME = "List Fragment";

    MyListFragment frag_;
    private SecureRandom random = new SecureRandom();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_list_activity);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            frag_ = new MyListFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, frag_)
                    .commit();
        }
    }


    public void addToList(View v){
        frag_.addToList(new BigInteger(24, random).toString(32));
    }

    public void clear(View v){
        frag_.clear();
    }
}