package com.example.broadcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.broadcaster.databinding.ActivityWifiPageBinding;

public class wifiPage extends AppCompatActivity {
    ActivityWifiPageBinding binding;
    WifiStateReceiver wf;
    private TextView ws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_wifi_page);
//
//        ws=findViewById(R.id.wifiText);
        super.onCreate(savedInstanceState);
        binding=ActivityWifiPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        wf = new WifiStateReceiver(binding.wifiText);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(wf, intentFilter);
    }
    public void updateWifiStatus(boolean isConnected) {
        if (isConnected) {
            ws.setText("WiFi Status: Connected");
        } else {
            ws.setText("WiFi Status: Disconnected");
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wf);
    }
}