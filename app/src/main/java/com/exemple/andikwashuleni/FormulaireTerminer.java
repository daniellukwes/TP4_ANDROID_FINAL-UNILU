package com.exemple.andikwashuleni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FormulaireTerminer extends AppCompatActivity {
    private Button buttonImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_terminer);

     this.buttonImage = (Button) findViewById(R.id.buttonImage);
        buttonImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), photoPrendre.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}

