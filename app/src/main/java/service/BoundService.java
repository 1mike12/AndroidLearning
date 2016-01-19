package service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by mike on 12/14/15.
 */
public class BoundService extends Service {

    private final IBinder binder_ = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder_;
    }

    public class MyBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }

    public String getHello() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss EE MMMM", Locale.ENGLISH);
        return dateFormat.format(new Date());
    }
}
