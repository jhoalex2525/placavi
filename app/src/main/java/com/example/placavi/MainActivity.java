package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.placavi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

    }

    public void singUp (View view){
        Intent intsingup = new Intent(this, AddProductActivity.class);
        startActivity(intsingup);
    }

    public void logIn(View view){
        Intent intlogin = new Intent(this, Products.class);
        startActivity(intlogin);
    }
}