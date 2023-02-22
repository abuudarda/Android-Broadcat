package com.example.broadcaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.broadcaster.databinding.ActivityCustomBcinputBinding;
import com.example.broadcaster.databinding.ActivityMainBinding;

public class customBCinput extends AppCompatActivity {
    private TextView mTextView;
    public static final String CUSTOM_ACTION = "com.example.broadcaster.CUSTOM_ACTION";

    ActivityCustomBcinputBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding= ActivityCustomBcinputBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_custom_bcinput);

//        binding.Broadcast.setOnClickListener(view -> {
//            Intent service = new Intent(customBCinput.this, )
//        });
        mTextView=findViewById(R.id.customReceive);

        Intent intent = new Intent(CUSTOM_ACTION);
        String def=findViewById(R.id.bcinput).toString();
        intent.putExtra("message", "def");
        sendBroadcast(intent);
        CustomBroadcastReceiver receiver = new CustomBroadcastReceiver();
        IntentFilter filter = new IntentFilter(CustomBroadcastReceiver.CUSTOM_ACTION);
        registerReceiver(receiver, filter);


    }
    private void updateUI(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(message);
            }
        });
    }
    public class CustomBroadcastReceiver extends BroadcastReceiver {
        public static final String CUSTOM_ACTION = "com.example.broadcaster.CUSTOM_ACTION";
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(CUSTOM_ACTION)) {
                String message = intent.getStringExtra("message");
                Log.d("CustomBroadcastReceiver", message);

                // Update UI here
                updateUI(message);
            }
        }
    }
}