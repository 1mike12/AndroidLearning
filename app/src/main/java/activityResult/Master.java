package activityResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import main.BaseAppCompatActivity;
import mike.customview.R;

/**
 * Created by mike on 1/22/16.
 */
public class Master extends BaseAppCompatActivity {

    static String key1 = "key1";
    static String key2 = "key2";

    static int slave1_requestCode = 1;
    static int slave2_requestCode = 2;

    TextView textView_;
    Button slave1_;
    Button slave2_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_first_activity);

        textView_ = (TextView) findViewById(R.id.master_textView);
        slave1_ = (Button) findViewById(R.id.master_button_1);
        slave1_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Master.this, SlaveFirst.class);
                startActivityForResult(intent, slave1_requestCode);
            }
        });

        slave2_ = (Button) findViewById(R.id.master_button_2);
        slave2_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Master.this, SlaveSecond.class);
                startActivityForResult(intent, slave2_requestCode);
            }
        });
    }

    @Override
    //request code is to differentiate which second activity you're coming back from
    //request codes need only be unique in this activity. A totally different Activity A and SlaveActivity set {B} can re-use request Codes

    //resultCode. like HTTP codes. ie RESULT_OK
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //ok return code
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == slave1_requestCode && data != null) {
                String result = data.getStringExtra(key1) + " " + data.getStringExtra(key2);
                textView_.setText(result);
            } else if (requestCode == slave2_requestCode && data != null){
                String result = data.getStringExtra(key1) + " " + data.getStringExtra(key2);
                textView_.setText(result);
            }
            // some error code
        } else if (resultCode == Activity.RESULT_CANCELED) {
            //Write your code if there's no result
        }
    }
}
