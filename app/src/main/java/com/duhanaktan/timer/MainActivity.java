package com.duhanaktan.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView enterNum;
    int numInt;
    Button startBut;
    Button contd;
    Button stop;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        enterNum=findViewById(R.id.enterNum);
        startBut=findViewById(R.id.startBut);
        contd=findViewById(R.id.continueBut);
        stop=findViewById(R.id.stopBut);
        stop.setEnabled(false);
        contd.setEnabled(false);


    }
    public void start(View view){
        stop.setEnabled(true);
        contd.setEnabled(false);
        if (countDownTimer != null) {
            countDownTimer.cancel();

        }
        String numText=enterNum.getText().toString();
        if(numText.matches("")){
            stop.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Enter Number!",Toast.LENGTH_LONG).show();
        }else{
            startBut.setEnabled(false);
            numInt=Integer.parseInt(numText);
            startCountDown(numInt);
        }
    }
    public void stop(View view){
        startBut.setEnabled(true);
        contd.setEnabled(true);
        stop.setEnabled(false);
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

    }
    public void contd(View view){
        startBut.setEnabled(false);
        contd.setEnabled(false);
        stop.setEnabled(true);
        startCountDown(numInt);
    }

    public void startCountDown(int seconds){
        countDownTimer = new CountDownTimer(seconds*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Left: "+millisUntilFinished/1000);
                numInt--;
            }

            @Override
            public void onFinish() {
                startBut.setEnabled(true);
                stop.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
            }
        }.start();
    }
}


