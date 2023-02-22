package com.example.broadcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.broadcaster.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String droptext[];

    {
        droptext = new String[]{"Custom broadcast receiver", "Wifi RTT state change receiver", "System battery notification receiver"};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> adapter= new ArrayAdapter<>(
                MainActivity.this,
                R.layout.drop_text,
                droptext
        );

        binding.drop.setAdapter(adapter);

        binding.go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inp = binding.drop.getText().toString();
                if(inp.equals("Custom broadcast receiver") ) startActivity(new Intent(MainActivity.this, customBCinput.class));
                if(inp.equals("System battery notification receiver") ) startActivity(new Intent(MainActivity.this, batteryInput.class));
                if(inp.equals("Wifi RTT state change receiver") ) startActivity(new Intent(MainActivity.this, wifiPage.class));
            }
        });

    }
}