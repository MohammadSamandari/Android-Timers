package com.mohammadsamandari.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HANDELERS:

//        Start by creating a Handler
//        Make sure to use android.os Handler for right frameworks.
        final Handler handler = new Handler();
//        it allows a chunk of code to run in a delayed way. for example every 1 miniute.
//        this chunk of code or events have name themselves and they are called Runnable.
        Runnable run = new Runnable() {
            @Override
            public void run() {
//                Insert code to be run every time.

                Log.i("info", "run: a second has passed");

//                once we write code to be run every second, we should give it instruction to be run every second.
//                and it's the Handler that takes care of that.
                handler.postDelayed(this, 1000);
            }
        };

//        So we created a Handler that controlls the timing of a certain method. and then we created the method whitch is called the Runnable
//        then we added the code to be run every second nad we use the handler to run this again in 1 second.

//        then we have to actually initialize the runnable in the first place.
        handler.post(run);

//        -----------------------------------------------------------------

//        Another way of Using Timers:
//        COUNTDOWN TIMER

//        This will countdown for 10 seconds, every second.
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                This Code Runns Every Second for 10 Seconds.;
                Log.i("Info", String.valueOf(millisUntilFinished));

            }

            @Override
            public void onFinish() {
//                This Code Runns after 10 seconds;
                Log.i("Info","Finished");
            }
        }.start();
    }
}
