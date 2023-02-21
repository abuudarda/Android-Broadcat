package com.example.broadcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.broadcaster.databinding.ActivityBatteryShowerBinding;

public class batteryShower extends AppCompatActivity {
    ActivityBatteryShowerBinding binding;
    BatteryReceiver br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBatteryShowerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String batUser=getIntent().getStringExtra("percentage");
        br= new BatteryReceiver(binding.asholBat,batUser,binding.userBat);
        registerReceiver(br, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}