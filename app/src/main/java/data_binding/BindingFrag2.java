package data_binding;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mike.customview.R;
import pager.MyFragmentForPager;

/**
 * Created by mike on 3/4/16.
 */
public class BindingFrag2 extends MyFragmentForPager {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view_ = inflater.inflate(R.layout.shared_binding_frag, container, false);
        return view_;
    }

    @Override
    public String getTitle(Context context) {
        return "Frag 2";
    }
}