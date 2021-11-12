package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class singup extends AppCompatActivity {

    RadioButton jrbseller, jrbuser, jrbadmin;
    EditText jetstorename, jetregistername, jetregisteremail, jetregistercountry, jetregistercity, jetregisterpassword;
    Button jbtnnewregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        jrbseller = findViewById(R.id.rbseller);
        jrbuser = findViewById(R.id.rbuser);
        jrbadmin = findViewById(R.id.rbadmin);
        jetstorename = findViewById(R.id.etstorename);
        jetregistername = findViewById(R.id.etregistername);
        jetregisteremail = findViewById(R.id.etregisteremail);
        jetregistercountry = findViewById(R.id.etregistercountry);
        jetregistercity = findViewById(R.id.etregistercity);
        jetregisterpassword = findViewById(R.id.etregisterpassword);
        jbtnnewregister = findViewById(R.id.btnnewregister);

    }

    public void storeName(View view){
        if (jrbseller.isChecked()){
            jetstorename.setVisibility(View.VISIBLE);
            jetstorename.setText("");
        }
        else{
            jetstorename.setVisibility(View.GONE);
            jetstorename.setText("No es Negocio");
        }
    }

    public void singUpFieldValidations (View view){
        String storename, registername, registeremail, registercountry, registercity, registerpassword;
        storename = jetstorename.getText().toString();
        registername = jetregistername.getText().toString();
        registeremail = jetregisteremail.getText().toString();
        registercountry = jetregistercountry.getText().toString();
        registercity = jetregistercity.getText().toString();
        registerpassword = jetregisterpassword.getText().toString();
        if (storename.isEmpty()||registername.isEmpty()||registeremail.isEmpty()||registercountry.isEmpty()||registercity.isEmpty()||registerpassword.isEmpty()){
            Toast.makeText(this, "Todos los campos deben ser diligenciados", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Su cuenta ha sido creada", Toast.LENGTH_SHORT).show();
            Intent intwelcome = new Intent(this, MainActivity.class);
            startActivity(intwelcome);
        }
    }




}