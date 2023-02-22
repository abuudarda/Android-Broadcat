package com.example.broadcaster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.TextView;

public class WifiStateReceiver extends BroadcastReceiver {
//    private wifiPage wp;
    TextView wifi;
    WifiStateReceiver(TextView wifi) {
        this.wifi = wifi;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
            NetworkInfo networkInfo = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
//            wifi.setText("WiFi Status: Connected");

            if (networkInfo != null) {
                if (networkInfo.isConnected()) {
                    // WiFi is connected

                    Log.d("WifiStateReceiver", "WiFi is connected");
                    // TODO: Update UI or perform some action
//                    wp.updateWifiStatus(true);
                    wifi.setText("WiFi Status: Connected");
                } else {

                    // WiFi is disconnected
                    Log.d("WifiStateReceiver", "WiFi is disconnected");
                    // TODO: Update UI or perform some action
                    wifi.setText("WiFi Status: DisConnected");
                }
            }
        }
    }



}