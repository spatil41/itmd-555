package com.example.suneh.lab5;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
{
    SeekBar seekBar1;
    TextView tv1;
    TextView tv2;
    public static int progress=0;
    Button button;
    private ViewFlipper myViewFlipper;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = (SeekBar) findViewById(R.id.sb);
        seekBar1.setProgress( progress);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv1.setText(""+progress );

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;
                tv1.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button = (Button) findViewById(R.id.button);

        // Capture button clicks
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MainActivity.this,
                        NewActivity.class);
                myIntent.putExtra("idfortime",progress);
                startActivity(myIntent);

            }
        });


       /* ListAdapter adapter=new ListAdapter(this, itemname, description, imgid);
        List=(ListView)findViewById(R.id.list);
        List.setAdapter(adapter);*/
        
        //NewActivity adapter=new NewActivity(this, itemname, description, imgid);

        //LayoutInflater inflater=context.getLayoutInflater();
        //View v= inflater.inflate(R.layout.new_activity, container, false);
        //myViewFlipper = (ViewFlipper) findViewById(R.id.myflipper);
        //myViewFlipper.setAutoStart(true);
        //myViewFlipper= v.findViewById(R.id.myflipper);
        //myViewFlipper.setAutoStart(true);
        //tv1= (TextView) findViewById(R.id.textView4);
        //tv2= (TextView) findViewById(R.id.textView5);
       //myViewFlipper.setAutoStart(true);
        /*for (int i = 0; i < imgid.length; i++) {

            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setImageResource(imgid[i]);
            myViewFlipper.addView(imageView);
            tv1.setText(itemname[i]);
            tv2.setText(description[i]);
        }*/
        //myViewFlipper.setFlipInterval(progress);
        //myViewFlipper.startFlipping();
}

    }



