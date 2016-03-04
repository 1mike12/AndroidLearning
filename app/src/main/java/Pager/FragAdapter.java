package pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mike on 3/3/16.
 */
public class FragAdapter extends FragmentPagerAdapter {

    ArrayList<MyFragmentForPager> fragments_;
    Context context_;
    public FragAdapter(Context context, FragmentManager fm) {
        super(fm);
        context_ = context;
        fragments_ = new ArrayList<>();
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

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return fragments_.get(position).getTitle(context_);
    }
}
