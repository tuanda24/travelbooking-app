package com.example.project136.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project136.Adapters.CategoryAdapter;
import com.example.project136.Adapters.PopularAdapter;
import com.example.project136.Domains.CategoryDomain;
import com.example.project136.Domains.PopularDomain;
import com.example.project136.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular, adapterCat;
    private RecyclerView recyclerViewPopular, recyclerViewCategory;
    private SearchView searchView;
    public ArrayList<PopularDomain> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

    }

    private void initRecyclerView() {
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
        recyclerViewPopular = findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //sao ko phải là thằng adapeter này
        //thử dùng thằng này xem
        adapterPopular = new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);

        ArrayList<CategoryDomain> catsList = new ArrayList<>();
        catsList.add(new CategoryDomain("Beaches", "cat1"));
        catsList.add(new CategoryDomain("Camps", "cat2"));
        catsList.add(new CategoryDomain("Forest", "cat3"));
        catsList.add(new CategoryDomain("Desert", "cat4"));
        catsList.add(new CategoryDomain("Mountain", "cat5"));


        recyclerViewCategory = findViewById(R.id.view_cat);
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterCat = new CategoryAdapter(catsList);
        recyclerViewCategory.setAdapter(adapterCat);


        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                String searchText = newText.trim().toLowerCase();
                List<PopularDomain> filteredList = new ArrayList<>();
                for (PopularDomain item : items) {
                    String location = item.getLocation().toLowerCase();
                    if (location.contains(searchText)) {
                        filteredList.add(item);
                    }
                }
                if (filteredList.isEmpty()) {
                    Toast.makeText(MainActivity.this, "No items found", Toast.LENGTH_SHORT).show();
                } else {
                    adapterPopular = new PopularAdapter(items);
                    recyclerViewPopular.setAdapter(adapterPopular);
                    //cái adapterPopular chú khai báo local có ý nghĩa gì ko, có chắc là viết như này có thể update ui ko
//                    PopularAdapter adapterPopular = new PopularAdapter(items);
//                    adapterPopular.updateData(filteredList);
//                    adapterPopular.notifyDataSetChanged();// nhảy đến đây rồi n
                }
                return true;
            }
        });
    }
}