package com.xuhuawei.testservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onBindingDied(ComponentName name) {

        }

        @Override
        public void onNullBinding(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View bindService = findViewById(R.id.bindService);
        View startService = findViewById(R.id.start_service);

        View unbind_service = findViewById(R.id.unbind_service);
        View stop_service = findViewById(R.id.stop_service);

        unbind_service.setOnClickListener(onClickListener);
        stop_service.setOnClickListener(onClickListener);
        startService.setOnClickListener(onClickListener);
        bindService.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.bindService) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
            } else if (v.getId() == R.id.start_service) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            } else if (v.getId() == R.id.stop_service) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            } else if (v.getId() == R.id.unbind_service) {
                unbindService(connection);
            }
        }
    };
}
