package com.example.project136.data.repository;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import com.example.project136.data.model.CategoryDomain;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

public class TravelBookingRepository {

    private static FirebaseFirestore fb = FirebaseFirestore.getInstance();

    @NonNull
    public static List<CategoryDomain> getCategory() {
        List<CategoryDomain> categoryList = new ArrayList<>();
        try {
            Task<QuerySnapshot> getCategoryTask = fb.collection("categories").get();
            Tasks.await(getCategoryTask);
            if (getCategoryTask.isSuccessful()) {
                for (DocumentSnapshot document : getCategoryTask.getResult()) {
                    CategoryDomain category = document.toObject(CategoryDomain.class);
                    categoryList.add(category);
                }
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        return categoryList;
    }
}
