package com.example.project136;

import android.os.AsyncTask;

import com.example.project136.base.BaseActivity;
import com.example.project136.data.model.CategoryDomain;
import com.example.project136.data.model.PopularDomain;
import com.example.project136.data.repository.TravelBookingRepository;
import com.example.project136.databinding.ActivityMainBinding;
import com.example.project136.ui.home.CategoryAdapter;
import com.example.project136.ui.home.PopularAdapter;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private final PopularAdapter popularAdapter = new PopularAdapter();
    private final CategoryAdapter categoryAdapter = new CategoryAdapter();

    public MainActivity() {
        super(ActivityMainBinding::inflate);
    }

    @Override
    protected void initView() {
        super.initView();
        binding.rcPopular.setAdapter(popularAdapter);
        binding.rcCategory.setAdapter(categoryAdapter);
        popularAdapter.setItemList(getPopular());
        categoryAdapter.setItemList(getCategory());
    }

    private ArrayList<PopularDomain> getPopular() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Mar caible, avendia lago", "Miami Beach", "This 2 bed /1 bath home boasts an enormous," +
                " open-living plan, accented by striking " +
                "architectural features and high-end finishes." +
                " Feel inspired by open sight lines that" +
                " embrace the outdoors, crowned by stunning" +
                " coffered ceilings. ", 2, true, 4.8, "pic1", true, 1000));
        items.add(new PopularDomain("Passo Rolle, TN", "Hawaii Beach", "This 2 bed /1 bath home boasts an enormous," +
                " open-living plan, accented by striking " +
                "architectural features and high-end finishes." +
                " Feel inspired by open sight lines that" +
                " embrace the outdoors, crowned by stunning" +
                " coffered ceilings. ", 1, false, 5, "pic2", false, 2500));
        items.add(new PopularDomain("Mar caible, avendia lago", "Miami Beach", "This 2 bed /1 bath home boasts an enormous," +
                " open-living plan, accented by striking " +
                "architectural features and high-end finishes." +
                " Feel inspired by open sight lines that" +
                " embrace the outdoors, crowned by stunning" +
                " coffered ceilings. ", 3, true, 4.3, "pic3", true, 30000));

        return items;
    }

    private List<CategoryDomain> getCategory() {
        try {
            return CompletableFuture.supplyAsync(TravelBookingRepository::getCategory).join();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}