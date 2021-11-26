package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.PatternsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.placavi.databinding.ActivitySingupBinding;

import java.util.regex.Pattern;

public class SingUp extends AppCompatActivity {

    private ActivitySingupBinding activitySingupBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySingupBinding = ActivitySingupBinding.inflate(getLayoutInflater());
        View view = activitySingupBinding.getRoot();
        setContentView(view);
    }

    public void storeName(View view){
        String storename = activitySingupBinding.etstorename.getText().toString();
        if (activitySingupBinding.rbseller.isChecked()){
            activitySingupBinding.etstorename.setVisibility(View.VISIBLE);
            activitySingupBinding.etstorename.setText("");
        }
        else{
            activitySingupBinding.etstorename.setVisibility(View.GONE);
            activitySingupBinding.etstorename.setText("No es Negocio");
        }
    }

    public boolean singUpFieldValidations (){
        String storename = activitySingupBinding.etstorename.getText().toString();
        String registername = activitySingupBinding.etregistername.getText().toString();
        String registercountry = activitySingupBinding.etregistercountry.getText().toString();
        String registercity = activitySingupBinding.etregistercity.getText().toString();

        if (storename.isEmpty()||registername.isEmpty()||registercountry.isEmpty()||registercity.isEmpty()){
            Toast.makeText(this, "Todos los campos deben ser diligenciados", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    public boolean singupEmailFieldValidations (){
        String email = activitySingupBinding.etregisteremail.getText().toString();
        if (email.isEmpty()){
            Toast.makeText(this, "Email es requerido", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(this, "Inserte un formato de email válido", Toast.LENGTH_SHORT).show();
                return false;
            }
            else {
                return true;
            }
        }
    }

    public boolean singupPasswordFieldValidations (){
        String password = activitySingupBinding.etregisterpassword.getText().toString();
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
            return false;
        }
        else {
            if (!passwordpattern.matcher(password).matches())
            {
                Toast.makeText(this, "Inserte un formato de contraseña válido", Toast.LENGTH_SHORT).show();
                return false;
            }
            else {
                return true;
            }
        }
    }

    public void singupValidations(View view){
        if( singUpFieldValidations()&&singupEmailFieldValidations()&&singupPasswordFieldValidations()){
            Toast.makeText(this, "Su cuenta ha sido creada", Toast.LENGTH_SHORT).show();
            Intent intwelcome = new Intent(this, MainActivity.class);
            startActivity(intwelcome);
        }
    }
}