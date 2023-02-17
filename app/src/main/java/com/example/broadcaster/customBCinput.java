package com.example.broadcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.broadcaster.databinding.ActivityCustomBcinputBinding;
import com.example.broadcaster.databinding.ActivityMainBinding;

public class customBCinput extends AppCompatActivity {
    ActivityCustomBcinputBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityCustomBcinputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Broadcast.setOnClickListener(view -> {
            Intent service = new Intent(customBCinput.this, )
        });
    }
}