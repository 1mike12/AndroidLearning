package _copy_pasta;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import mike.customview.R;

/**
 * Created by mike on 3/4/16.
 */
public class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view_ = inflater.inflate(R.layout.fragment1, container, false);

        return view_;
    }
}
