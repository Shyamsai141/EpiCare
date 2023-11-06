package com.example.epicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Success extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Button backl = (Button) findViewById(R.id.backl);
        backl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backlogging();
                finish();
            }
        });
    }
    public void backlogging() {
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
}