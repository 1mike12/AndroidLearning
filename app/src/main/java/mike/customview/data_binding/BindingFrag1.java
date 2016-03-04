package mike.customview.data_binding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mike.customview.R;
import mike.customview.pager.MyFragmentForPager;

/**
 * Created by mike on 3/4/16.
 */
public class BindingFrag1 extends MyFragmentForPager {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view_ = inflater.inflate(R.layout.shared_binding_frag, container, false);

        return view_;
    }

    @Override
    public String getTitle(Context context) {
        return "Frag 1";
    }
}