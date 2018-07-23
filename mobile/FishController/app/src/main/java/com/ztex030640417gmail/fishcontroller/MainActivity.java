package com.ztex030640417gmail.fishcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.NumberFormat;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private int data = 0b0000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate success");

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
                data = data | 0b10000000;
            }
        });

        Level7.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 7 clicked");
                data = data | 0b01110000;
            }
        });

        Level6.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 6 clicked");
                data = data | 0b01100000;
            }
        });

        Level5.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 5 clicked");
                data = data | 0b01010000;
            }
        });

        Level4.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 4 clicked");
                data = data | 0b01000000;
            }
        });

        Level3.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 3 clicked");
                data = data | 0b00110000;
            }
        });

        Level2.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 5 clicked");
                data = data | 0b00100000;
            }
        });

        Level1.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 5 clicked");
                data = data | 0b00010000;
            }
        });

        Level0.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                System.out.println("Level 0 clicked");
                data = data | 0b00000000;
            }
        });

    }

}
