package com.example.placavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.placavi.Entities.Product;
import com.example.placavi.databinding.ActivityEditProductBinding;
import com.example.placavi.databinding.ActivityProductsBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditProductActivity extends AppCompatActivity {

    private ActivityEditProductBinding editProductBinding;
    private Product product;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editProductBinding = ActivityEditProductBinding.inflate(getLayoutInflater());
        View view = editProductBinding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        product = (Product) intent.getSerializableExtra("product");
        db = FirebaseFirestore.getInstance();
        editProductBinding.etName.setText(product.getName());
        editProductBinding.etDescription.setText(product.getDescription());
        editProductBinding.etStock.setText(String.valueOf(product.getStock()));
        editProductBinding.etPrice.setText(String.valueOf(product.getPrice()));
        editProductBinding.etCategory.setText(product.getCategory());
    }

    public void updateProduct(View view){
        Map<String, Object> dataProduct = new HashMap<>();
        dataProduct.put("name", editProductBinding.etName.getText().toString());
        dataProduct.put("description", editProductBinding.etDescription.getText().toString());
        dataProduct.put("stock", Integer.parseInt(editProductBinding.etStock.getText().toString()));
        dataProduct.put("price", Double.parseDouble(editProductBinding.etStock.getText().toString()));
        dataProduct.put("category", editProductBinding.etCategory.getText().toString());
        if (view.getId() == editProductBinding.btnUpdate.getId()){
            db.collection("products").document(product.getId())
                    .update(dataProduct).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(getApplicationContext(), "Producto actualizado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Products.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Error actualizando producto", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}