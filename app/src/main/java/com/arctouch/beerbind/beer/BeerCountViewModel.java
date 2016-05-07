package com.arctouch.beerbind.beer;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.arctouch.beerbind.BR;
import com.bumptech.glide.Glide;

public class BeerCountViewModel extends BaseObservable {

    private String beerCountLabel = "Quantas cervejas você bebeu?"; //TODO get from resources
    private BeerCountModel beerCountModel;

    public BeerCountViewModel(BeerCountModel beerCountModel) {
        this.beerCountModel = beerCountModel;
    }

    @Bindable
    public int getBeerCount() {
        return beerCountModel.getBeerCount();
    }

    public void setBeerCount(int beerCount) {
        this.beerCountModel.setBeerCount(beerCount);
        notifyPropertyChanged(BR.beerCount);
        notifyPropertyChanged(BR.beerCountText);
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public String getBeerCountText() {
        return Integer.toString(beerCountModel.getBeerCount());
    }

    public String getBeerCountLabel() {
        return beerCountLabel;
    }

    public TextWatcher getBeerCountTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    setBeerCount(Integer.parseInt(s.toString()));
                } catch (RuntimeException e){
                    setBeerCount(0);
                }
            }
        };
    }

    public SeekBar.OnSeekBarChangeListener getBeerCountSeekListener() {
        return new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    setBeerCount(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };
    }

    @Bindable
    public String getImageUrl() {
        return beerCountModel.getBeerContImageUrl();
    }

    @BindingAdapter("bind:onSeekBarChangeListener")
    public static void setOnSeekBarChangeListener(SeekBar seekBar, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
