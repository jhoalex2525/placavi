package com.example.placavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.placavi.databinding.ActivityAddProductBinding;
import com.example.placavi.databinding.ActivityEditProductBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddProductActivity extends AppCompatActivity {

    private ActivityAddProductBinding addProductBinding;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addProductBinding = ActivityAddProductBinding.inflate(getLayoutInflater());
        View view = addProductBinding.getRoot();
        setContentView(view);
        db = FirebaseFirestore.getInstance();
    }

    public void addProduct(View view){
        Map<String, Object> dataProduct = new HashMap<>();
        dataProduct.put("name", addProductBinding.etNewName.getText().toString());
        dataProduct.put("description", addProductBinding.etNewDescription.getText().toString());
        dataProduct.put("stock", Integer.parseInt(addProductBinding.etNewStock.getText().toString()));
        dataProduct.put("price", Double.parseDouble(addProductBinding.etNewStock.getText().toString()));
        dataProduct.put("category", addProductBinding.etNewCategory.getText().toString());
        db.collection("products").add(dataProduct).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Se creó el producto", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Products.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error creando el producto", Toast.LENGTH_SHORT).show();
            }
        });
    }
}