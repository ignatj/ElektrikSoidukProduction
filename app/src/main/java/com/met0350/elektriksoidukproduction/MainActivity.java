package com.met0350.elektriksoidukproduction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private View1Fragment view1Fragment;
    private View2Fragment view2Fragment;
    private View3Fragment view3Fragment;
    private View4Fragment view4Fragment;
    private View5Fragment view5Fragment;
    private View6Fragment view6Fragment;
    private View7Fragment view7Fragment;
    private View8Fragment view8Fragment;
    private View9Fragment view9Fragment;
    private TextView clockTextView;
    private boolean shouldRun = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn1 = findViewById(R.id.vehiclePictureButton);
        ImageButton btn2 = findViewById(R.id.volumePictureButton);
        ImageButton btn3 = findViewById(R.id.cameraPictureButton);
        ImageButton btn4 = findViewById(R.id.coolingPictureButton);
        ImageButton btn5 = findViewById(R.id.phonePictureButton);
        ImageButton btn6 = findViewById(R.id.naviPictureButton);
        ImageButton btn7 = findViewById(R.id.appsPictureButton);
        ImageButton btn8 = findViewById(R.id.musicPictureButton);
        ImageButton btn9 = findViewById(R.id.comfortPictureButton);

        clockTextView = findViewById(R.id.clockTextView);
        startClockUpdate();


        view1Fragment = new View1Fragment();
        setNewFragmentLeft(view1Fragment);

        view5Fragment = new View5Fragment();
        setNewFragmentRight(view5Fragment);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //view1Fragment is vehicle dashboard panel
                if (view1Fragment == null) {
                    view1Fragment = new View1Fragment();
                }
                setNewFragmentLeft(view1Fragment);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view2Fragment == null) {
                    view2Fragment = new View2Fragment();
                }
                setNewFragmentLeft(view2Fragment);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view3Fragment == null) {
                    view3Fragment = new View3Fragment();
                }
                setNewFragmentLeft(view3Fragment);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view4Fragment == null) {
                    view4Fragment = new View4Fragment();
                }
                setNewFragmentLeft(view4Fragment);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view5Fragment == null) {
                    view5Fragment = new View5Fragment();
                }
                setNewFragmentRight(view5Fragment);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view6Fragment == null) {
                    view6Fragment = new View6Fragment();
                }
                setNewFragmentRight(view6Fragment);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view7Fragment == null) {
                    view7Fragment = new View7Fragment();
                }
                setNewFragmentRight(view7Fragment);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view8Fragment == null) {
                    view8Fragment = new View8Fragment();
                }
                setNewFragmentRight(view8Fragment);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view9Fragment == null) {
                    view9Fragment = new View9Fragment();
                }
                setNewFragmentRight(view9Fragment);
            }
        });
    }

    private void setNewFragmentLeft(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.CurrFragmentLeft, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void setNewFragmentRight(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.currFragmentRight, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void startClockUpdate() {
        new Thread(() -> {
            while (shouldRun) {
                updateTime();
                try {
                    Thread.sleep(1000); // Update every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void updateTime() {
        runOnUiThread(() -> {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
            String currentTime = dateFormat.format(calendar.getTime());
            clockTextView.setText(currentTime);
        });
    }
}