package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText jetloginemail, jetloginpassword;
    Button jbtnloginapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        jetloginemail = findViewById(R.id.etloginemail);
        jetloginpassword = findViewById(R.id.etloginpassword);
        jbtnloginapp = findViewById(R.id.btnloginapp);
    }

    public void loginFieldValidations (View view){
        String email, password;
        email = jetloginemail.getText().toString();
        password = jetloginpassword.getText().toString();
        if (email.isEmpty()){
            Toast.makeText(this, "Email es requerido", Toast.LENGTH_SHORT).show();
            jetloginemail.requestFocus();
        }
        else {
            if (password.isEmpty()){
                Toast.makeText(this, "Contraseña es requerida", Toast.LENGTH_SHORT).show();
                jetloginpassword.requestFocus();
            }
            else {
                Toast.makeText(this, "Bienvenido, estas logueado", Toast.LENGTH_SHORT).show();
                Intent intwelcome = new Intent(this, MainActivity.class);
                startActivity(intwelcome);
            }
        }
    }
}