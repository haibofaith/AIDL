package com.simple.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent3;//LastService
    private IMyAidlInterface myAidlInterface;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            try {
                int result = myAidlInterface.plus(3,5);
                Log.d("LastServiceResult",result+"");
                String upper = myAidlInterface.toUpperCase("data");
                Log.d("LastServiceResult",upper);
                myAidlInterface.setData("这是修改后的信息");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent3 = new Intent(this,LastService.class);
    }

    public void start(View view){
        startService(intent3);
    }



    public void stop(View view){
        stopService(intent3);
    }

    public void bind(View view){
        bindService(intent3,serviceConnection,BIND_AUTO_CREATE);
    }



    public void unbind(View view){
        unbindService(serviceConnection);
    }
}
