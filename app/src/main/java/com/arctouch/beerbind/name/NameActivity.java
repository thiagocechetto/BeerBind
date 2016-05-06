package com.arctouch.beerbind.name;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arctouch.beerbind.R;
import com.arctouch.beerbind.databinding.ActivityNameBinding;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNameBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_name);
        NameViewModel nameViewModel = new NameViewModel();
        binding.setNameViewModel(nameViewModel);
    }
}
