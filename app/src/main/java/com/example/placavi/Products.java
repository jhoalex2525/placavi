package com.example.placavi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.placavi.Adapters.ProductAdapter;
import com.example.placavi.Entities.Product;
import com.example.placavi.databinding.ActivityProductsBinding;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Products extends AppCompatActivity {

    private ActivityProductsBinding activityProductsBinding;
    private FirebaseFirestore db;
    ArrayList<Product> productArrayList;
    ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProductsBinding = ActivityProductsBinding.inflate(getLayoutInflater());
        View view = activityProductsBinding.getRoot();
        setContentView(view);
        db = FirebaseFirestore.getInstance();
        productArrayList = new ArrayList<>();
        productAdapter = new ProductAdapter(this, productArrayList, db);
        activityProductsBinding.rvProducts.setHasFixedSize(true);
        activityProductsBinding.rvProducts.setLayoutManager(new LinearLayoutManager(this));
        activityProductsBinding.rvProducts.setAdapter(productAdapter);
        getProducts();
    }

    public void getProducts(){
        db.collection("products")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Toast.makeText(getApplicationContext(), "Fall?? la recolecci??n de informaci??n",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                        for (DocumentChange dc: value.getDocumentChanges()){
                            if (dc.getType() == DocumentChange.Type.ADDED){
                                productArrayList.add(dc.getDocument().toObject(Product.class));
                            }
                        }
                        productAdapter.notifyDataSetChanged();
                    }
                });
    }
}