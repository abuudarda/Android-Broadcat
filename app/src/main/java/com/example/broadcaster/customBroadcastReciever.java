package com.example.broadcaster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class customBroadcastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.example.EXAMPLE_ACTION".equals(intent.getAction())){
            String rtext=intent.getStringExtra("com.example.EXTRA_TEXT");
            Toast.makeText(context, rtext, Toast.LENGTH_SHORT).show();
        }
    }
}
