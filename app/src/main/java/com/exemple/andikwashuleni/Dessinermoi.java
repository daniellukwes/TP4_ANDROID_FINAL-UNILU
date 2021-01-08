package com.exemple.andikwashuleni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dessinermoi extends AppCompatActivity {
    canevas  canevas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessinermoi);

        canevas = new canevas(this,null);
        setContentView(canevas);



    }
}