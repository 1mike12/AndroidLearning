package mike.customview.asyncTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import mike.customview.main.BaseAppCompatActivity;
import mike.customview.R;

/**
 * Created by mike on 1/4/16.
 */
public class AsyncTaskActivity extends BaseAppCompatActivity {

    EditText editText_;
    Button button_;
    TextView result_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        editText_ = (EditText) findViewById(R.id.async_edit_text);
        button_ = (Button) findViewById(R.id.async_button);
        result_ = (TextView) findViewById(R.id.async_result);

        button_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTaskRunner runner = new MyAsyncTaskRunner();
                try {
                    int ms = Integer.valueOf(editText_.getText().toString());
                    runner.execute(ms);
                } catch (NumberFormatException e) {
                    CharSequence text = "Must enter number";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(AsyncTaskActivity.this, text, duration);
                    toast.show();
                }
            }
        });
    }

    //<Input type, Progress type, Result Type>
    //<# ms to sleep, progress is a string "sleeping...", result is "Slept for" + ms>
    private class MyAsyncTaskRunner extends AsyncTask<Integer, String, String> {

        String resp;

        @Override
        protected void onPreExecute() {
            // Things to be done before execution of long running operation. For
        }

        @Override
        protected String doInBackground(Integer... params) {
            // Calls onProgressUpdate()
            publishProgress("Sleeping...");

            try {
                // Do your long operations here and return the result
                int time = params[0];
                // Sleeping for given time period
                Thread.sleep(time);
                resp = "Slept for " + time + " milliseconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

        @Override
        protected void onProgressUpdate(String... text) {
            result_.setText(text[0]);
            // Things to be done while execution of long running operation is in
            // progress. For example updating ProgessDialog
        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            result_.setText(result);
        }
    }
}
