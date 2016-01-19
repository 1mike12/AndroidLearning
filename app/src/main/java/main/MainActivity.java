package main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import asyncTask.AsyncTaskActivity;
import database.DatabaseActivity;
import fragment.DynamicFragmentActivity;
import fragment.StaticFragmentActivity;
import fragmentList.MyListFragmentActivity;
import mike.customview.LovelyActivity;
import mike.customview.LovelyView;
import mike.customview.R;
import service.ServiceActivity;

public class MainActivity extends AppCompatActivity {

    LovelyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void customViewFunction(View v) {
        launchIntent(LovelyActivity.class);
    }

    public void fragmentFunction(View v) {
        launchIntent(StaticFragmentActivity.class);
    }

    public void dynamicFragment(View v) {
        launchIntent(DynamicFragmentActivity.class);
    }

    public void fragmentList(View view) {
        launchIntent(MyListFragmentActivity.class);
    }

    public void service (View v){
        launchIntent(ServiceActivity.class);
    }

    public void database (View v){
        launchIntent(DatabaseActivity.class);
    }

    public void async (View v){
        launchIntent(AsyncTaskActivity.class);
    }
    public void launchIntent(Class<?> someClass) {
        Intent intent = new Intent(this, someClass);
        startActivity(intent);
    }

}
