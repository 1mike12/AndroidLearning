package mike.customview.pager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import mike.customview.main.BaseAppCompatActivity;
import mike.customview.R;

/**
 * Created by mike on 3/3/16.
 */
public class PagerActivity extends BaseAppCompatActivity {

    FragAdapter adapter_;

    ViewPager pager_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter_ = new FragAdapter(this, getSupportFragmentManager());
        setContentView(R.layout.activity_pager);

        pager_ = (ViewPager) findViewById(R.id.activity_pager_view_pager);
        pager_.setAdapter(adapter_);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_pager_tabs);
        tabLayout.setupWithViewPager(pager_);
    }
}
