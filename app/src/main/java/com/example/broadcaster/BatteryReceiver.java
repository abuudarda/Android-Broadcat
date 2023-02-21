package com.example.broadcaster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.TextView;
public class BatteryReceiver extends BroadcastReceiver {
    TextView asholTV, userTV;
    String BP;
    BatteryReceiver(TextView asholTV, String BP, TextView userTV){
        this.asholTV=asholTV;
        this.BP=BP;
        this.userTV=userTV;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryLevel = level / (float) scale;

        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

        // TODO: Implement your logic based on battery level and charging status
        String s;
        if(status==1)s="Unknown";
        else if(status==2)s="Charging";
        else if(status==3)s="Discharging";
        else if(status==4)s="Not Charging";
        else s= "FULL";
        asholTV.setText("Battery from system = "+level+", "+s);
        userTV.setText("Battery from user = "+BP);
    }
}
