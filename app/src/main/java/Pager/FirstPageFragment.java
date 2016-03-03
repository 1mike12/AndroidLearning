package pager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import mike.customview.R;

/**
 * Created by mike on 3/3/16.
 */
public class FirstPageFragment extends MyFragmentForPager {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view_ = inflater.inflate(R.layout.fragment1, container, false);
        return view_;
    }

    @Override
    public String getTitle(Context context) {
        return "First";
    }
}
