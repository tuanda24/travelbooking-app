package com.example.project136.view.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.project136.base.BaseAdapter;
import com.example.project136.data.model.PopularDomain;
import com.example.project136.databinding.ItemPopularBinding;
import com.example.project136.view.detail.DetailActivity;

public class PopularAdapter extends BaseAdapter<PopularDomain, ItemPopularBinding> {

    public class PopularViewHolder extends BaseViewHolder {
        public PopularViewHolder(ItemPopularBinding binding) {
            super(binding);
        }

        @Override
        public void setData(PopularDomain item) {
            binding.titleTxt.setText(item.getTitle());
            binding.locationTxt.setText(item.getLocation());
            binding.scoreTxt.setText("" + item.getScore());

            int drawableResId = binding.getRoot().getResources().getIdentifier(item.getPic(),
                    "drawable", binding.getRoot().getContext().getPackageName());

            Glide.with(binding.getRoot().getContext())
                    .load(drawableResId)
                    .transform(new CenterCrop(), new GranularRoundedCorners(40, 40, 40, 40))
                    .into(binding.picImg);

            binding.getRoot().setOnClickListener(v -> {
                Intent intent = new Intent(binding.getRoot().getContext(), DetailActivity.class);
                intent.putExtra("object", item);
                binding.getRoot().getContext().startActivity(intent);
            });
        }
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPopularBinding binding = ItemPopularBinding.inflate(inflater, parent, false);
        return new PopularViewHolder(binding);
    }

}