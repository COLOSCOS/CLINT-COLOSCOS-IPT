package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Get the user's name from intent extras if passed
        String userName = getIntent().getStringExtra("USER_NAME");

        TextView welcomeText = findViewById(R.id.welcomeText);

        if (userName != null && !userName.isEmpty()) {
            welcomeText.setText("Welcome, " + userName + "!");
        } else {
            welcomeText.setText("Welcome!");
        }

        // Set up logout button
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to LoginActivity
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish WelcomeActivity
            }
        });
    }
}