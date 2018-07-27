package com.ztex030640417gmail.fishcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.NumberFormat;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.widget.ArrayAdapter;
import java.util.Set;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private int data = 0b00000000;

    private BluetoothAdapter myBluetooth = null;
    private Set <BluetoothDevice> pairedDevices;

>>>>>>> 259aee63e57218049d5dd647c7a1430416a68f1c

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate success");

<<<<<<< HEAD
=======

        // BLE SUPPORTED checking
        IfSupport();
        // Set up BLE Adapter
        SetUpBLE();

        // Objects about BLE
        Button Scan = (Button) findViewById(R.id.Scan);
        Button Discon = (Button) findViewById(R.id.Disconnect);
        ListView devicelist = (ListView)findViewById(R.id.listView);

        // List View
        //devicelist = pairedDevicesList();

>>>>>>> 259aee63e57218049d5dd647c7a1430416a68f1c
        // Direction Buttons object
        Button ForWard = (Button) findViewById(R.id.FORWARD); // Get the button object
        Button BackWard = (Button) findViewById(R.id.BACKWARD); // Get the button object
        Button LeftWard = (Button) findViewById(R.id.LEFTWARD); // Get the button object
        Button RightWard = (Button) findViewById(R.id.RIGHTWARD); // Get the button object

        // Level Buttons object
        Button Level8 = (Button) findViewById(R.id.Level8);
        Button Level7 = (Button) findViewById(R.id.Level7);
        Button Level6 = (Button) findViewById(R.id.Level6);
        Button Level5 = (Button) findViewById(R.id.Level5);
        Button Level4 = (Button) findViewById(R.id.Level4);
        Button Level3 = (Button) findViewById(R.id.Level3);
        Button Level2 = (Button) findViewById(R.id.Level2);
        Button Level1 = (Button) findViewById(R.id.Level1);
        Button Level0 = (Button) findViewById(R.id.Level0);

        // Build up the button listener
        ForWard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    // Button pressed
                    System.out.println("Forward");
                    data = data | 0b00001000;
                    System.out.println("Status : " + Integer.toBinaryString(data));
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    // Button released
                    data = data & 0b11110111;
                    System.out.println("Status : " + Integer.toBinaryString(data));
                }
                return false;
            }
        });
        BackWard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    // Button pressed
                    System.out.println("Backward");
                    data = data | 0b00000100;
                    System.out.println("Status : " + Integer.toBinaryString(data));
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    // Button released
                    data = data & 0b11111011;
                    System.out.println("Status : " + Integer.toBinaryString(data));
                }
                return false;
            }
        });
        LeftWard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    // Button pressed
                    System.out.println("Leftward");
                    data = data | 0b00000010;
                    System.out.println("Status : " + Integer.toBinaryString(data));
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    // Button released
                    data = data & 0b11111101;
                    System.out.println("Status : " + Integer.toBinaryString(data));
                }
                return false;
            }
        });
        RightWard.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    // Button pressed
                    System.out.println("Rightward");
                    data = data | 0b00000001;
                    System.out.println("Status : " + Integer.toBinaryString(data));
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    // Button released
                    data = data & 0b11111110;
                    System.out.println("Status : " + Integer.toBinaryString(data));
                }
                return false;
            }
        });

        // Level button listener
        Level8.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 8 clicked");
                int direct_state = data & 0b1111;
                data = (0b1000 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

        Level7.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 7 clicked");
                int direct_state = data & 0b1111;
                data = (0b0111 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

        Level6.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 6 clicked");
                int direct_state = data & 0b1111;
                data = (0b0110 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

        Level5.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 5 clicked");
                int direct_state = data & 0b1111;
                data = (0b0101 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

        Level4.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 4 clicked");
                int direct_state = data & 0b1111;
                data = (0b0100 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

        Level3.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 3 clicked");
                int direct_state = data & 0b1111;
                data = (0b0011 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

        Level2.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 5 clicked");
                int direct_state = data & 0b1111;
                data = (0b0010 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

        Level1.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 5 clicked");
                int direct_state = data & 0b1111;
                data = (0b0001 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

        Level0.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 0 clicked");
                int direct_state = data & 0b1111;
                data = (0b0000 << 4) + direct_state;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

    }

    public void IfSupport(){
        Context context = this;
        PackageManager packageManager = context.getPackageManager();
        if(!context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)){
            Toast.makeText(this, "BLE NOT SUPPORTED", Toast.LENGTH_SHORT).show();
            System.out.println("BLE NOT SUPPORTED");
            finish();
        }
    }

    public void SetUpBLE(){
        final BluetoothManager BTManager = (BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter myBluetooth = BTManager.getAdapter();
        final int REQUEST_ENABLE_BT = 1;
        if(myBluetooth == null || !myBluetooth.isEnabled()){
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            System.out.println("Adapter is not enabled");
        }
    }

    private ListView pairedDevicesList()
    {
        pairedDevices = myBluetooth.getBondedDevices();
        ArrayList list = new ArrayList();

        if (pairedDevices.size()>0)
        {
            for(BluetoothDevice bt : pairedDevices)
            {
                list.add(bt.getName() + "\n" + bt.getAddress()); //Get the device's name and the address
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No Paired Bluetooth Devices Found.", Toast.LENGTH_LONG).show();
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        ListView device_list = null;
        device_list.setAdapter(adapter);
        return device_list;
        //devicelist.setOnItemClickListener(myListClickListener); //Method called when the device from the list is clicked

    }
}
