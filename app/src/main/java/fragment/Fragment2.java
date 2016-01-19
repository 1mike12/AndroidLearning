package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import mike.customview.R;

/**
 * Created by mike on 10/13/15.
 */
public class Fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    public void setString(String string) {
        TextView t = (TextView) getActivity().findViewById(R.id.fragment2_text);
        t.setText(string);
    }
}
