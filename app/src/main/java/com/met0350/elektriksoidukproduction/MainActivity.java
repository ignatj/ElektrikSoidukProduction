package com.met0350.elektriksoidukproduction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private View1Fragment view1Fragment;
    private View2Fragment view2Fragment;
    private View3Fragment view3Fragment;
    private View4Fragment view4Fragment;
    private View5Fragment view5Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);

        setNewFragment(view1Fragment);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view1Fragment == null) {
                    view1Fragment = new View1Fragment();
                }
                setNewFragment(view1Fragment);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view2Fragment == null) {
                    view2Fragment = new View2Fragment();
                }
                setNewFragment(view2Fragment);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view3Fragment == null) {
                    view3Fragment = new View3Fragment();
                }
                setNewFragment(view3Fragment);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view4Fragment == null) {
                    view4Fragment = new View4Fragment();
                }
                setNewFragment(view4Fragment);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view5Fragment == null) {
                    view5Fragment = new View5Fragment();
                }
                setNewFragment(view5Fragment);
            }
        });
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.currentViewLayout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}