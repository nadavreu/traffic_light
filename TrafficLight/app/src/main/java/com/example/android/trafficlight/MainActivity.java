package com.example.android.trafficlight;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView carRed;
    private TextView carYellow;
    private TextView carGreen;
    private TextView manRed;
    private TextView manGreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carRed = (TextView) findViewById(R.id.redLightIndicator);
        carYellow = (TextView) findViewById(R.id.yellowLightIndicator);
        carGreen = (TextView) findViewById(R.id.greenLightIndicator);
        manRed = (TextView) findViewById(R.id.manRedLightIndicator);
        manGreen = (TextView) findViewById(R.id.manGreenLightIndicator);

    }

    public void manPassing(View v) {
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                ;
                Resources res = getResources();
                carYellow.setBackground(res.getDrawable(R.drawable.yellow_light));
                carGreen.setBackground(res.getDrawable(R.drawable.green_light_off));
            }

            public void onFinish() {
                Resources res = getResources();
                carRed.setBackground(res.getDrawable(R.drawable.red_light));
                manGreen.setBackground(res.getDrawable(R.drawable.green_light));
                manRed.setBackground(res.getDrawable(R.drawable.red_light_off));
                carYellow.setBackground(res.getDrawable(R.drawable.yellow_light_off));

            }
        }.start();
    }
    public void carPassing(View v) {
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                ;
                Resources res = getResources();
                manRed.setBackground(res.getDrawable(R.drawable.red_light));
                new CountDownTimer(3000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        Resources res = getResources();
                        manGreen.setBackground(res.getDrawable(R.drawable.green_light_off));
                        manRed.setBackground(res.getDrawable(R.drawable.red_light));
                        carYellow.setBackground(res.getDrawable(R.drawable.yellow_light));
                        carRed.setBackground(res.getDrawable(R.drawable.red_light_off));
                    }

                    public void onFinish() {
                        Resources res = getResources();
                        carYellow.setBackground(res.getDrawable(R.drawable.yellow_light_off));
                    }
                }.start();
            }

            public void onFinish() {
                Resources res = getResources();

                carGreen.setBackground(res.getDrawable(R.drawable.green_light));
            }
        }.start();
    }
}
