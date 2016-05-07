package com.arctouch.beerbind.name;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.arctouch.beerbind.BR;
import com.arctouch.beerbind.R;

public class NameViewModel extends BaseObservable {

    public final int nameHintText = R.string.name_hint_text;
    public final int enterButtonText = R.string.name_enter_button_text;

    private NameView nameView;
    private String name;

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
