package com.ztex030640417gmail.fishcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.NumberFormat;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private int data = 0b0000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate success");

        Button ForWard = (Button) findViewById(R.id.FORWARD); // Get the button object
        Button BackWard = (Button) findViewById(R.id.BACKWARD); // Get the button object
        Button LeftWard = (Button) findViewById(R.id.LEFTWARD); // Get the button object
        Button RightWard = (Button) findViewById(R.id.RIGHTWARD); // Get the button object

        // Build up the button listener
        ForWard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Forward");
                data = data | 0b0001000;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });
        BackWard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Backward");
                data = data | 0b0000100;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });
        LeftWard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Leftward");
                data = data | 0b0000010;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });
        RightWard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Rightward");
                data = data | 0b0000001;
                System.out.println("Status : " + Integer.toBinaryString(data));
            }
        });

    }

}
