package com.example.suneh.lab6;

/**
 * Created by suneh on 3/18/2018.
 */
import android.app.Service;
import android.os.Binder;
import android.os.IBinder;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.support.annotation.Nullable;
import android.widget.Toast;

public class service extends Service
{

    private static final String TAG = service.class.getSimpleName();

    // Start and end times in milliseconds
    private long startTime, endTime;

    // Is the service tracking time?
    private boolean isTimerRunning;

    // Foreground notification id
    private static final int NOTIFICATION_ID = 1;

    // Service binder
    private final IBinder serviceBinder = new RunServiceBinder();

   

    public class RunServiceBinder extends Binder {
        service getService() {
            return service.this;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "Binding service");
        }
        return serviceBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(TAG, "in onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(TAG, "in onUnbind");
        return true;
    }
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    public class MyBinder extends Binder {
        service getService() {
            return service.this;
        }
    }
}


