package mike.customview.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import mike.customview.R;

/**
 * Created by mike on 10/13/15.
 */
public class Fragment1 extends Fragment {

    View view_;
    EditText editText_;
    Button button_;

    Callback callback;

    public interface Callback {
        public void sendText(String text);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            callback = (Callback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Callback");
        }
    }

    public void sendText() {
        callback.sendText(editText_.getText().toString());
    }

    //only callback necessary for a fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view_ = inflater.inflate(R.layout.fragment1, container, false);
        button_ = (Button) view_.findViewById(R.id.fragment1_button);
        button_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText();
            }
        });

        editText_ = (EditText) view_.findViewById(R.id.fragment1_edit_text);
        return view_;
    }
}
