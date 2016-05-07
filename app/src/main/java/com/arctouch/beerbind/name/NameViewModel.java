package com.arctouch.beerbind.name;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.arctouch.beerbind.BR;

public class NameViewModel extends BaseObservable {

    private NameView nameView;

    private String name;
    private String nameHintText = "Digite seu nome aqui"; //TODO get from resources

    public NameViewModel(NameView view) {
        this.nameView = view;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
        Log.i("hi", "property name changed to " + this.name);
    }

    public String getNameHintText() {
        return nameHintText;
    }

    public void onClickEnter(View view) {
        if (name == null || name.isEmpty()) {
            nameView.showNameError();
        } else {
            nameView.gotoBeerView();
        }
    }

    public TextWatcher getNameTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setName(s.toString());
            }
        };
    }
}
