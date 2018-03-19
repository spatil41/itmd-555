package com.example.suneh.lab6;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.util.Log;
import android.content.Intent;
import com.example.suneh.lab6.service.MyBinder;

public class MainActivity extends AppCompatActivity {
    TextView textView ;

    Button start, pause, reset;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;

    Handler handler;

    int Seconds, Minutes, MilliSeconds ;

    ArrayAdapter<String> adapter ;

    String msg = "Android : ";
    private static final String TAG = MainActivity.class.getSimpleName();

    service mBoundService;
    boolean mServiceBound = false;
    //private ServiceConnection mServiceConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");

        textView = (TextView) findViewById(R.id.textView1);
        start = (Button) findViewById(R.id.button3);
        pause = (Button) findViewById(R.id.button4);
        reset = (Button) findViewById(R.id.button5);
        handler = new Handler();

        start.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);

                reset.setEnabled(false);
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                reset.setEnabled(true);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L;
                StartTime = 0L;
                TimeBuff = 0L;
                UpdateTime = 0L;
                Seconds = 0;
                Minutes = 0;
                MilliSeconds = 0;

                textView.setText("00:00:00");
                //adapter.notifyDataSetChanged();
            }
        });

    }
            public Runnable runnable = new Runnable() {

            public void run() {

                MillisecondTime = SystemClock.uptimeMillis() - StartTime;

                UpdateTime = TimeBuff + MillisecondTime;

                Seconds = (int) (UpdateTime / 1000);

                Minutes = Seconds / 60;

                Seconds = Seconds % 60;

                MilliSeconds = (int) (UpdateTime % 1000);

                textView.setText("" + Minutes + ":"
                        + String.format("%02d", Seconds) + ":"
                        + String.format("%03d", MilliSeconds));

                handler.postDelayed(this, 0);
            }

        };

    public void startService(View view)
    {
        startService(new Intent(getBaseContext(), service.class));
    }
    // Method to stop the service
    public boolean stopService(Intent view)
    {
        //stopService(new Intent(getBaseContext(), service.class));
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
        Intent intent = new Intent(MainActivity.this,service.class);
        stopService(intent);

        return false;
    }
   private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBinder myBinder = (MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };
}

