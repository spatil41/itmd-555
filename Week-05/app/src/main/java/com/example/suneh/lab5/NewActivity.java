package com.example.suneh.lab5;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import static com.example.suneh.lab5.R.layout.new_activity;

/**
 * Created by suneh on 2/25/2018.
 */

public class NewActivity extends AppCompatActivity
{
    public TextView tv1;
    private  TextView tv2;
    private ImageView iv;
    public int i;
    String[] itemname ={
            "India",
            "London",
            "NewYork",
            "SanFransisco",
            "Australia",
            "Mexico",
            "Miami",
            "Maldives",
            "Spain",
            "Chicago",
    };

    String[] description={
            "Incredible India",
            "London is always a good idea",
            "The city that never sleeps",
            "The golden city",
            "There is nothing like Australia",
            "Mexico is the world of its own",
            "It's so Miami",
            "Sunny side of life",
            "Inspiring new ways",
            "This pizza is epic, bro",


    };

    Integer[] imgid={

            R.drawable.india,
            R.drawable.london,
            R.drawable.newyork,
            R.drawable.sanfran,
            R.drawable.australia,
            R.drawable.mexico,
            R.drawable.miami,
            R.drawable.maldives,
            R.drawable.spain,
            R.drawable.chicago,

    };
    private int time;
    private Bundle extras;
    private Handler customHandler= new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        try {
            extras = getIntent().getExtras();
            time = extras.getInt("idfortime");
            Log.d("myTag", "--------"+time);
            iv = (ImageView) findViewById(R.id.imageView2);
            tv1 = (TextView) findViewById(R.id.textView4);
            tv2 = (TextView) findViewById(R.id.textView5);
            customHandler.postDelayed(runnable, 0);
        } catch (Exception ex) {
            Log.d("EX0001", ex.getMessage());
        }
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (i < imgid.length) {
                iv.setImageResource(imgid[i]);
                tv1.setText(itemname[i]);
                tv2.setText(description[i]);
                i++;

                if (i == imgid.length) {
                    i = 0;
                }
            }

            customHandler.postDelayed(this, time*1000);
        }
    };
}


