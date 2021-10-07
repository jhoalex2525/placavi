package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class singup extends AppCompatActivity {

    RadioButton jrbseller, jrbuser, jrbadmin;
    EditText jetstorename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        jrbseller = findViewById(R.id.rbseller);
        jrbuser = findViewById(R.id.rbuser);
        jrbadmin = findViewById(R.id.rbadmin);
        jetstorename = findViewById(R.id.etstorename);

    }

    public void storeName(View view){
        if (jrbseller.isChecked()){
            jetstorename.setVisibility(View.VISIBLE);
        }
        else{
            jetstorename.setVisibility(View.GONE);
        }
    }

    public void home (View view){
        Intent inthome = new Intent(this, MainActivity.class);
        startActivity(inthome);
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