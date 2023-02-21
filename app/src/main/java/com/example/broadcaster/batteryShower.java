package com.example.broadcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.broadcaster.databinding.ActivityBatteryShowerBinding;

public class batteryShower extends AppCompatActivity {
    ActivityBatteryShowerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_shower);
    }
}