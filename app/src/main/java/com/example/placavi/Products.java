package com.example.placavi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.placavi.Entities.Product;
import com.example.placavi.databinding.ActivityProductsBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    private ActivityProductsBinding activityProductsBinding;
    private FirebaseFirestore db;
    ArrayList<Product> productArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProductsBinding = ActivityProductsBinding.inflate(getLayoutInflater());
        View view = activityProductsBinding.getRoot();
        setContentView(view);
        db = FirebaseFirestore.getInstance();
        productArrayList = new ArrayList<>();
    }
}