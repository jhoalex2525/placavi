package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.placavi.databinding.ActivityLoginBinding;

import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    private ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = activityLoginBinding.getRoot();
        setContentView(view);
    }

    public void loginEmailFieldValidations (){
        String email = activityLoginBinding.etloginemail.getText().toString();
        if (email.isEmpty()){
            Toast.makeText(this, "Email es requerido", Toast.LENGTH_SHORT).show();
        }
        else {
            if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(this, "Inserte un formato de email válido", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void loginPasswordFieldValidations (){
        String password = activityLoginBinding.etloginpassword.getText().toString();
        Pattern passwordpattern = Pattern.compile(
                "^"+
                        "(?=.*[A-Z])"+      //1 upper letter
                        "(?=.*[@#$%&^+=])"+ //1 especial character
                        "(?=\\S+$)"+        //No white spaces
                        ".{8,}"+            //At lets 8 characters
                "$"
        );
        if (password.isEmpty()){
                Toast.makeText(this, "Contraseña es requerida", Toast.LENGTH_SHORT).show();
        }
        else {
            if (!passwordpattern.matcher(password).matches())
            {
                Toast.makeText(this, "Inserte un formato de contraseña válido", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Bienvenido, estas logueado", Toast.LENGTH_SHORT).show();
                Intent intwelcome = new Intent(this, MainActivity.class);
                startActivity(intwelcome);
            }
        }
    }

    public void loginFieldValidations(View view){
        loginEmailFieldValidations();
        loginPasswordFieldValidations();
    }
}