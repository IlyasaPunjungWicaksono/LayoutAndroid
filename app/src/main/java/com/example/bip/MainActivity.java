package com.example.bip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Thread threadSplah;
    TextView txtTitle;
    private long ms = 0;
    private long splashTime = 1500;
    private boolean splashActive = true;
    private boolean splashPause = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread th = new Thread() {
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {
                        if (!splashPause) {
                            ms = ms + 100;
                        }
                        sleep(100);
                    }
                } catch (Exception e) {
                    //TODO : handle excepetion
                }
                finally {
                    Intent i = new Intent(MainActivity.this, Login.class);
                    startActivity(i);
                }
            }
        };
        th.start();
    }
}