package com.example.intent_timertask_pedro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ThirdActivity extends AppCompatActivity {

    public static Boolean Booleanpermisos = false;
    private TimerTask mTimerTask3 = null;
    public static int currentTime3;
    private Timer mTimer3;

    TextView msj3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        msj3 = (TextView) findViewById(R.id.timer3);

        Bundle miBundle1 = this.getIntent().getExtras();
        if (miBundle1 != null) {

            int permisos = miBundle1.getInt("tiempothird");

            msj3.setText(Integer.toString(MainActivity.currentTime));
        }

        chronometer3();
    }

    public void onClick(View view) {

        Intent miIntent = null;

        switch (view.getId()) {
            case R.id.buttonvolver2:
                finish();
                mTimer3.cancel();
                break;

            case R.id.buttonpermisos:
                miIntent = new Intent(getApplicationContext(), MainActivity.class);

                Bundle miBundle = new Bundle();
                miBundle.putBoolean("permisos", Booleanpermisos);

                miIntent.putExtras(miBundle);
                ThirdActivity.Booleanpermisos = true;

                mTimer3.cancel();

                Bundle miBundle2 = new Bundle();
                miBundle2.putInt("tiempoActivityThird", currentTime3);

                miIntent.putExtras(miBundle);

                startActivity(miIntent);
                break;
        }

    }

    public void chronometer3() {
        mTimerTask3 = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        currentTime3++;
                    }
                });
            }

            ;
        };
        mTimer3 = new Timer();
        mTimer3.schedule(mTimerTask3, 1, 1000);

    }
}