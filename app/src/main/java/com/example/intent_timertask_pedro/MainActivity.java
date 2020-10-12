package com.example.intent_timertask_pedro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TimerTask mTimerTask = null;
    public static int currentTime;
    private TextView mTextView;
    private Timer mTimer;

    TextView msj1;
    TextView msj2;
    TextView msj3;
    TextView msj4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msj1 = (TextView) findViewById(R.id.textView7);

        Bundle miBundle1 = this.getIntent().getExtras();

        if (miBundle1 != null & SecondActivity.Booleanguardar == true) {
            Boolean guardar = miBundle1.getBoolean("guardar");

            msj1.setText("True");
        }

        msj2 = (TextView) findViewById(R.id.textView8);

        Bundle miBundle2 = this.getIntent().getExtras();

        if (miBundle2 != null & ThirdActivity.Booleanpermisos == true) {
            Boolean permisos = miBundle2.getBoolean("permisos");

            msj2.setText("True");
        }

        msj3 = (TextView) findViewById(R.id.timer4);

        Bundle miBundle3 = this.getIntent().getExtras();
        if (miBundle3 != null) {

            int tiempoActivitySecond = miBundle3.getInt("tiempoActivitySecond");

            msj3.setText(Integer.toString(SecondActivity.currentTime2));
        }

        msj4 = (TextView) findViewById(R.id.timer5);

        Bundle miBundle4 = this.getIntent().getExtras();
        if (miBundle4 != null) {

            int tiempoActivityThird = miBundle4.getInt("tiempoActivityThird");

            msj4.setText(Integer.toString(ThirdActivity.currentTime3));
        }

        mTextView = (TextView) findViewById(R.id.timer1);
        chronometer();

    }

    public void onClick(View view) {

        Intent miIntent = null;

        switch (view.getId()) {
            case R.id.button1:
                miIntent = new Intent(getApplicationContext(), SecondActivity.class);
                mTimer.cancel();

                Bundle miBundle = new Bundle();
                miBundle.putInt("tiemposecond", currentTime);

                miIntent.putExtras(miBundle);
                break;

            case R.id.button2:
                miIntent = new Intent(getApplicationContext(), ThirdActivity.class);
                mTimer.cancel();

                Bundle miBundle2 = new Bundle();
                miBundle2.putInt("tiemposecond", currentTime);

                miIntent.putExtras(miBundle2);
                break;
        }
        startActivity(miIntent);
    }

    public void chronometer() {
        mTimerTask = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        currentTime++;
                        mTextView.setText(String.valueOf(currentTime));
                    }
                });
            }

            ;
        };
        mTimer = new Timer();
        mTimer.schedule(mTimerTask, 1, 1000);

    }


}