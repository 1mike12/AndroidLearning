package activityResult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import main.BaseAppCompatActivity;
import mike.customview.R;

/**
 * Created by mike on 1/22/16.
 */
public class SlaveSecond extends BaseAppCompatActivity {

    Button button_;
    EditText editText_;
    EditText editText2_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_second_activity);
        editText_ = (EditText) findViewById(R.id.result_second_editText);
        editText2_ = (EditText) findViewById(R.id.result_second_editText2);
        button_ = (Button) findViewById(R.id.result_second_button);

        button_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText_.getText().toString();
                String text2 = editText2_.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra(Master.key1, text);
                returnIntent.putExtra(Master.key2, text2);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
