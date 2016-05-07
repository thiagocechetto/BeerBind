package com.arctouch.beerbind.beer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.arctouch.beerbind.R;
import com.arctouch.beerbind.databinding.ActivityBeerBinding;

public class BeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBeerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_beer);
        BeerViewModel beerViewModel = new BeerViewModel();
        binding.setBeerViewModel(beerViewModel);
    }
}
