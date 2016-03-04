package main;

import activityResult.Master;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import asyncTask.AsyncTaskActivity;
import data_binding.DataBindingActivity;
import database.DatabaseActivity;
import database.LoaderActivity;
import fragment.DynamicFragmentActivity;
import fragment.StaticFragmentActivity;
import fragmentList.MyListFragmentActivity;
import mike.customview.LovelyActivity;
import mike.customview.LovelyView;
import mike.customview.R;
import pager.PagerActivity;
import service.ServiceActivity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static LinkedHashMap<String, Class> name_activity = new LinkedHashMap<>();

    static {
        name_activity.put("Lovely", LovelyActivity.class);
        name_activity.put("fragment", StaticFragmentActivity.class);
        name_activity.put("dynamic fragment", DynamicFragmentActivity.class);
        name_activity.put("fragment list", MyListFragmentActivity.class);
        name_activity.put("service", ServiceActivity.class);
        name_activity.put("database", DatabaseActivity.class);
        name_activity.put("loader", LoaderActivity.class);
        name_activity.put("async", AsyncTaskActivity.class);
        name_activity.put("Activity Result", Master.class);
        name_activity.put("pager", PagerActivity.class);
        name_activity.put("data binding", DataBindingActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout buttonWrapper = (LinearLayout) findViewById(R.id.main_button_wrapper);

        for (final Map.Entry<String, Class> entry : name_activity.entrySet()) {
            Button button = new Button(this);
            button.setText(entry.getKey());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchIntent(entry.getValue());
                }
            });
            buttonWrapper.addView(button);
        }
    }


    void launchIntent(Class<?> someClass) {
        Intent intent = new Intent(this, someClass);
        startActivity(intent);
    }

}
