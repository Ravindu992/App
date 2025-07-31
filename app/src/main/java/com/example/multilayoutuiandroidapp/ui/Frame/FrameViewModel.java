package com.example.multilayoutuiandroidapp.ui.Frame;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FrameViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FrameViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Your Profile");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
