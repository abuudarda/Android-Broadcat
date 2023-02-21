package com.example.broadcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.broadcaster.databinding.ActivityBatteryInputBinding;

public class batteryInput extends AppCompatActivity {
ActivityBatteryInputBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBatteryInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.batGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(batteryInput.this,batteryShower.class);
                intent.putExtra("percentage",binding.batInp.getText().toString());
                startActivity(intent);
            }
        });
    }
}