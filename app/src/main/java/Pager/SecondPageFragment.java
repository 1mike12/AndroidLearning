package pager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mike.customview.R;

/**
 * Created by mike on 3/3/16.
 */
public class SecondPageFragment extends MyFragmentForPager {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view_ = inflater.inflate(R.layout.fragment2, container, false);
        return view_;
    }

    @Override
    public String getTitle(Context context) {
        return "Second";
    }
}
