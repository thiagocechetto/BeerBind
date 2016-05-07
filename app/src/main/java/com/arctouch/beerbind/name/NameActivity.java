package com.arctouch.beerbind.name;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.arctouch.beerbind.R;
import com.arctouch.beerbind.beer.BeerCountActivity;
import com.arctouch.beerbind.databinding.ActivityNameBinding;

public class NameActivity extends AppCompatActivity implements NameView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNameBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_name);
        NameViewModel nameViewModel = new NameViewModel(this);
        binding.setNameViewModel(nameViewModel);
    }

    @Override
    public void showNameError() {
        Toast.makeText(this, "Nome inválido", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void gotoBeerView() {
        Intent intent = new Intent(this, BeerCountActivity.class);
        startActivity(intent);
    }
}
