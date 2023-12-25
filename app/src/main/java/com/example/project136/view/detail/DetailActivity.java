package com.example.project136.view.detail;

import com.bumptech.glide.Glide;
import com.example.project136.base.BaseActivity;
import com.example.project136.data.model.PopularDomain;
import com.example.project136.databinding.ActivityDetailBinding;
import com.example.project136.utils.ConfirmDialog;

public class DetailActivity extends BaseActivity<ActivityDetailBinding> {

    public DetailActivity() {
        super(ActivityDetailBinding::inflate);
    }

    @Override
    protected void initView() {
        super.initView();
        setData();
        binding.btnBook.setOnClickListener(v -> {
            ConfirmDialog.showConfirmDialog(
                    this,
                    "Thông báo!",
                    "Bạn có muốn lựa chọn địa đểm này bây giờ?",
                    "Có",
                    "Không",
                    new ConfirmDialog.ConfirmationDialogListener() {
                        @Override
                        public void onPositiveButtonClicked() {

                        }

                        @Override
                        public void onNegativeButtonClicked() {

                        }
                    }
            );
        });
    }

    private void setData() {
        PopularDomain item = (PopularDomain) getIntent().getSerializableExtra("object");
        binding.titleTxt.setText(item.getTitle());
        binding.scoreTxt.setText(String.valueOf(item.getScore()));
        binding.locationTxt.setText(item.getLocation());
        binding.bedTxt.setText(String.format("%s Bed", item.getBed()));
        binding.descriptionTxt.setText(item.getDescription());
        binding.guideTxt.setText(item.isGuide() ? "Guide" : "No-Guide");
        binding.wifiTxt.setText(item.isWifi() ? "Wifi" : "No-Wifi");
        int drawableResId = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());
        Glide.with(this)
                .load(drawableResId)
                .into(binding.picImg);
        binding.backBtn.setOnClickListener(v -> finishAndRemoveTask());
    }

}