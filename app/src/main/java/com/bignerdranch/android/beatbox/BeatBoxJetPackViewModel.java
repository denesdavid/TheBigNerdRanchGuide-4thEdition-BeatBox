package com.bignerdranch.android.beatbox;

import android.content.res.AssetManager;
import androidx.lifecycle.ViewModel;

public class BeatBoxJetPackViewModel extends ViewModel {
    public BeatBox beatBox;

    public BeatBoxJetPackViewModel (AssetManager assetManager) {
        beatBox = new BeatBox(assetManager);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        beatBox.release();
    }
}
