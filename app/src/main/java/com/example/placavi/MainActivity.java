package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button jbtingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jbtingresar =findViewById(R.id.button);
    }

    public void Ingresar(View view){
        Intent intmostrar = new Intent(this, singup.class);
        startActivity(intmostrar);
    }
}