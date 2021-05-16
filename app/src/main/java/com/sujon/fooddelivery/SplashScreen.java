package com.sujon.fooddelivery;

import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (user != null) {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                }
                finish();
            }
        }, 3000);
        Toast.makeText(this, "Welcome to Pizza Hut", Toast.LENGTH_LONG).show();
    }
}