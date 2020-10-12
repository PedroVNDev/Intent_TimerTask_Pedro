package com.example.intent_timertask_pedro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends AppCompatActivity {

    public static Boolean Booleanguardar = false;
    private TimerTask mTimerTask2 = null;
    public static int currentTime2;
    private Timer mTimer2;

    TextView msj3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        msj3 = (TextView) findViewById(R.id.timer2);

        Bundle miBundle1 = this.getIntent().getExtras();
        if (miBundle1 != null) {

            int guardar = miBundle1.getInt("tiemposecond");

            msj3.setText(Integer.toString(MainActivity.currentTime));
        }

        chronometer2();
    }

    public void onClick(View view) {

        Intent miIntent = null;

        switch (view.getId()) {
            case R.id.buttonvolver1:
                mTimer2.cancel();
                finish();
                break;

            case R.id.buttonguardar:
                miIntent = new Intent(getApplicationContext(), MainActivity.class);

                Bundle miBundle = new Bundle();
                miBundle.putBoolean("guardar", Booleanguardar);

                miIntent.putExtras(miBundle);
                SecondActivity.Booleanguardar = true;

                mTimer2.cancel();

                Bundle miBundle2 = new Bundle();
                miBundle2.putInt("tiempoActivitySecond", currentTime2);

                miIntent.putExtras(miBundle);

                startActivity(miIntent);
                break;
        }

    }

    public void chronometer2() {
        mTimerTask2 = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        currentTime2++;
                    }
                });
            }

            ;
        };
        mTimer2 = new Timer();
        mTimer2.schedule(mTimerTask2, 1, 1000);

    }

}