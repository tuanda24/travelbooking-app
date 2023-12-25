package com.example.project136.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, VB extends ViewBinding> extends RecyclerView.Adapter<BaseAdapter<T, VB>.BaseViewHolder> {

    private List<T> itemList;

    public BaseAdapter() {
        this.itemList = new ArrayList<>();
    }

    public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        protected VB binding;

        public BaseViewHolder(VB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public abstract void setData(T item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        T data = itemList.get(position);
        holder.setData(data);
    }

    public void setItemList(List<T> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyItemRangeInserted(0, itemList.size());
    }
}