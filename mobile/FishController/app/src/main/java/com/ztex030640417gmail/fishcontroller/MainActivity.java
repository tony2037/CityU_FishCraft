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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate success");

        int data = 0;

        Button ForWard = (Button) findViewById(R.id.FORWARD); // Get the button object
        Button BackWard = (Button) findViewById(R.id.BACKWARD); // Get the button object
        Button LeftWard = (Button) findViewById(R.id.LEFTWARD); // Get the button object
        Button RightWard = (Button) findViewById(R.id.RIGHTWARD); // Get the button object

        // Build up the button listener
        ForWard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Forward");
            }
        });
        BackWard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Backward");
            }
        });
        LeftWard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Leftward");
            }
        });
        RightWard.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                System.out.println("Rightward");
            }
        });

    }

}