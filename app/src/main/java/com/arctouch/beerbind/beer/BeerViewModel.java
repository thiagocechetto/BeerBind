package com.arctouch.beerbind.beer;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.SeekBar;

import com.arctouch.beerbind.BR;

public class BeerViewModel extends BaseObservable {

    private String beerCountLabel = "Quantas cervejas você bebeu?";

    private int beerCount = 7;

    @Bindable
    public int getBeerCount() {
        return beerCount;
    }

    public void setBeerCount(int beerCount) {
        this.beerCount = beerCount;
        notifyPropertyChanged(BR.beerCount);
        notifyPropertyChanged(BR.beerCountText);
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

    @BindingAdapter("bind:onSeekBarChangeListener")
    public static void setOnSeekBarChangeListener(SeekBar seekBar, SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
}
