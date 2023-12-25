package com.example.project136.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.example.project136.base.BaseAdapter;
import com.example.project136.data.model.CategoryDomain;
import com.example.project136.databinding.ItemCategoryBinding;

public class CategoryAdapter extends BaseAdapter<CategoryDomain, ItemCategoryBinding> {

    public class CategoryViewHolder extends BaseViewHolder {
        public CategoryViewHolder(ItemCategoryBinding binding) {
            super(binding);
        }

        @Override
        public void setData(CategoryDomain item) {
            binding.titleTxt.setText(item.getTitle());
            int drawableResourceId = binding.getRoot().getResources().getIdentifier(item.getPicPath(), "drawable", binding.getRoot().getContext().getPackageName());
            Glide.with(binding.getRoot())
                    .load(drawableResourceId)
                    .into(binding.catImg);
        }
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(inflater, parent, false);
        return new CategoryViewHolder(binding);
    }

}