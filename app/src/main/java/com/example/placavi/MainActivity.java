package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button jbtsingup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbtsingup =findViewById(R.id.btnsingup);
    }

    public void singUp (View view){
        Intent intsingup = new Intent(this, singup.class);
        startActivity(intsingup);
    }

    public void Ingresar(View view){
        Intent intmostrar = new Intent(this, singup.class);
        startActivity(intmostrar);
    }
}