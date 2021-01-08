package com.exemple.andikwashuleni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification2);

        TextView textView = findViewById(R.id.text_view);
        String message = getIntent().getStringExtra("message");
        textView.setText(message);
    }
}