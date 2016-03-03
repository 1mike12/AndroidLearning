package pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mike on 3/3/16.
 */
public class MyAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments_;

    public MyAdapter(FragmentManager fm) {
        super(fm);
        fragments_.add(new FirstPageFragment());
        fragments_.add(new SecondPageFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments_.get(position);
    }

    @Override
    public int getCount() {
        return fragments_.size();
    }
}
