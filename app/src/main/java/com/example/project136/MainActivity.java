package com.example.project136;

import com.example.project136.base.BaseActivity;
import com.example.project136.data.model.CategoryDomain;
import com.example.project136.data.model.PopularDomain;
import com.example.project136.data.repository.TravelBookingRepository;
import com.example.project136.databinding.ActivityMainBinding;
import com.example.project136.ui.home.CategoryAdapter;
import com.example.project136.ui.home.PopularAdapter;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<CategoryDomain> catsList = new ArrayList<>();
        catsList.add(new CategoryDomain("Beaches", "cat1"));
        catsList.add(new CategoryDomain("Camps", "cat2"));
        catsList.add(new CategoryDomain("Forest", "cat3"));
        catsList.add(new CategoryDomain("Desert", "cat4"));
        catsList.add(new CategoryDomain("Mountain", "cat5"));
        return catsList;
    }

}