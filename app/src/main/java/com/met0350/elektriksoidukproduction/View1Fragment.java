package com.met0350.elektriksoidukproduction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class View1Fragment extends Fragment {

    private ImageView handBrake;
    private ImageView doorOpen;
    private ImageView gabariitTuli;
    private ImageView lahiTuli;
    private ImageView paevaTuli;
    private ImageView pesuVedelik;
    private ImageView turnLeft;
    private ImageView turnRight;
    private ImageView turvaVoo;
    private TextView speed;
    private TextView p;
    private TextView n;
    private TextView r;
    private TextView d;
    private Handler handler;
    private boolean shouldRun = true;
    private Integer mockSpeed = 50;
    boolean lahebUles = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view1, container, false);

        handBrake = view.findViewById(R.id.handBrake);
        doorOpen = view.findViewById(R.id.dooropen);
        gabariitTuli = view.findViewById(R.id.gabariitTuli);
        lahiTuli = view.findViewById(R.id.lahiTuli);
        paevaTuli = view.findViewById(R.id.paevaTuli);
        pesuVedelik = view.findViewById(R.id.pesuVedelik);
        turnLeft = view.findViewById(R.id.turnLeft);
        turnRight = view.findViewById(R.id.turnRight);
        turvaVoo = view.findViewById(R.id.turvavoo);
        speed = view.findViewById(R.id.speedValue);
        p = view.findViewById(R.id.p);
        n = view.findViewById(R.id.n);
        r = view.findViewById(R.id.r);
        d = view.findViewById(R.id.d);

        handler = new Handler();
        startUpdateLoop();

        return view;
    }

    private void startUpdateLoop() {
        new Thread(() -> {
            Looper.prepare();
            while (shouldRun) {
                updateUI();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Looper.loop();
        }).start();
    }

    private void updateUI() {
        getActivity().runOnUiThread(() -> {
            handBrake.setVisibility(updateHandBrake() ? View.VISIBLE : View.GONE);
            doorOpen.setVisibility(updateDoorOpen() ? View.VISIBLE : View.GONE);
            gabariitTuli.setVisibility(updateGabariitTuli() ? View.VISIBLE : View.GONE);
            lahiTuli.setVisibility(updateLahiTuli() ? View.VISIBLE : View.GONE);
            paevaTuli.setVisibility(updatePaevaTuli() ? View.VISIBLE : View.GONE);
            pesuVedelik.setVisibility(updatePesuVedelik() ? View.VISIBLE : View.GONE);
            turnLeft.setVisibility(updateTurnLeft() ? View.VISIBLE : View.GONE);
            turnRight.setVisibility(updateTurnRight() ? View.VISIBLE : View.GONE);
            turvaVoo.setVisibility(updateTurvaVoo() ? View.VISIBLE : View.GONE);
            p.setVisibility(updateP() ? View.VISIBLE : View.GONE);
            n.setVisibility(updateN() ? View.VISIBLE : View.GONE);
            r.setVisibility(updateR() ? View.VISIBLE : View.GONE);
            d.setVisibility(updateD() ? View.VISIBLE : View.GONE);
            speed.setText(String.valueOf(getSpeed()));
        });
    }

    private boolean updateHandBrake() {
        return Math.random() < 0.5;
    }

    private boolean updateDoorOpen() {
        return Math.random() < 0.5;
    }

    private boolean updateGabariitTuli() {
        return Math.random() < 0.5;
    }

    private boolean updateLahiTuli() {
        return Math.random() < 0.5;
    }

    private boolean updatePaevaTuli() {
        return Math.random() < 0.5;
    }

    private boolean updatePesuVedelik() {
        return Math.random() < 0.5;
    }

    private boolean updateTurnLeft() {
        return Math.random() < 0.5;
    }

    private boolean updateTurnRight() {
        return Math.random() < 0.5;
    }

    private boolean updateTurvaVoo() {
        return Math.random() < 0.5;
    }

    private boolean updateP() {
        return Math.random() < 0.5;
    }

    private boolean updateN() {
        return Math.random() < 0.5;
    }

    private boolean updateR() {
        return Math.random() < 0.5;
    }

    private boolean updateD() {
        return Math.random() < 0.5;
    }

    private int getSpeed() {
        if (mockSpeed < 100 && lahebUles) {
            return mockSpeed++;
        }
        if (mockSpeed == 100) {
            lahebUles = false;
        }
        mockSpeed--;
        if (mockSpeed < 50) {
            lahebUles = true;
        }
        return mockSpeed;

    }

    //@Override
    //public void onDestroyView() {
        //super.onDestroyView();
        //shouldRun = false;
    //}
}


