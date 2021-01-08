package com.exemple.andikwashuleni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class photoPrendre extends AppCompatActivity {

    Button btVibration;
    Vibrator vibrator;

    private static final int CAPTURE_IMAGE = 1;

    private ImageView imageView;
    private Button btnCamera;
    private String photoPath;
    Uri fichUri;
    private Button btEcrimain;
    private Button Notice;
    private Button dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_prendre);

        Notice = findViewById(R.id.Notice);
        Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String message = "Bonjour Professeur";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        photoPrendre.this
                )
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("Nouveau message")
                        .setContentText(message)
                        .setAutoCancel(true);

                Intent intent = new Intent(photoPrendre.this,
                        NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);

                PendingIntent pendingIntent = PendingIntent.getActivity(photoPrendre.this,
                        0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(
                        Context.NOTIFICATION_SERVICE
                );
                notificationManager.notify(0,builder.build());
            }
        });


        initActivity();

        btVibration = findViewById(R.id.bt_vibration);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        btVibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(1000);
            }
        });

        this.btEcrimain = (Button) findViewById(R.id.btEcrimain);
        btEcrimain.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Dessinermoi.class);
                startActivity(otherActivity);
                finish();
            }

        });

        this.dev = (Button) findViewById(R.id.dev);
        dev.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Developpeur.class);
                startActivity(otherActivity);
                finish();
            }

        });
    }

    private void initActivity(){
        this.btnCamera = (Button) findViewById(R.id.btnCamera);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        btnCamera.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                prendreUnePhoto();
            }
        });
    }

    private void prendreUnePhoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null){
            File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),getPackageName());
            File fich = new File(directory.getPath());
            photoPath = fich.getAbsolutePath();
            fichUri = Uri.fromFile(fich);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fichUri);
            startActivityForResult(intent, CAPTURE_IMAGE);
        }else {
            Toast.makeText(this, "ERREUR", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == CAPTURE_IMAGE && resultCode == RESULT_OK) {
            Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(photoPath));
            imageView.setImageBitmap(bitmap);
        }
    }

}