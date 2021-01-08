 package com.exemple.andikwashuleni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;

    private ImageView play; //on fqit appel a notre image pour clicker qui se trouve dqns xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
//hooks
//        image = findViewById(R.id.imageview);
//        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView);



//        image.setAnimation(topAnim);
//        logo.setAnimation(bottomAnim);
       slogan.setAnimation(bottomAnim);


        this.play = (ImageView) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), FormulaireIndividuel.class);
                startActivity(otherActivity);
                finish();
            }

        });
    }
}