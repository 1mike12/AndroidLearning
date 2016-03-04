package mike.customview.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import mike.customview.main.BaseAppCompatActivity;
import mike.customview.R;

/**
 * Created by mike on 12/14/15.
 */
public class ServiceActivity extends BaseAppCompatActivity {

    public static final String TAG = "mike/customview/service";
    BoundService boundService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activity);

        Intent intent = new Intent(this, BoundService.class);
        boolean test = bindService(intent, serviceConnection_, Context.BIND_AUTO_CREATE);
        Log.d("TEST" , String.valueOf(test));
    }

    public void showStuff(View view) {
        if (isBound) {
            String hello = boundService.getHello();
            EditText t = (EditText) findViewById(R.id.service_edit_text);
            t.setText(hello);
        }
    }

    private ServiceConnection serviceConnection_ = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder binder = (BoundService.MyBinder) service;
            boundService = binder.getService();
            isBound = true;
            Log.d(TAG, "Service Connected!");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
            Log.d(TAG, "Service DCd!");
        }
    };
}
