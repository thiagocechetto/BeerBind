package com.arctouch.beerbind.beer;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.arctouch.beerbind.BR;
import com.bumptech.glide.Glide;

public class BeerViewModel extends BaseObservable {

    private String beerCountLabel = "Quantas cervejas você bebeu?"; //TODO get from resources

    private int beerCount = 7;

    public String image1 = "http://cdn.coresites.factorymedia.com/cooler_new/wp-content/uploads/2015/10/drunk_homer.jpg";
    public String image2 = "https://pbs.twimg.com/profile_images/378800000372208922/89f4942fb278ba0c5316f6828d59c313_400x400.jpeg";

    @Bindable
    public int getBeerCount() {
        return beerCount;
    }

    public void setBeerCount(int beerCount) {
        this.beerCount = beerCount;
        notifyPropertyChanged(BR.beerCount);
        notifyPropertyChanged(BR.beerCountText);
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public String getBeerCountText() {
        return Integer.toString(beerCount);
    }

    public String getBeerCountLabel() {
        return beerCountLabel;
    }


    public String getDrunkImageUrl() {
        return null;
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
        return beerCount % 2 == 0 ? image1 : image2;
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
