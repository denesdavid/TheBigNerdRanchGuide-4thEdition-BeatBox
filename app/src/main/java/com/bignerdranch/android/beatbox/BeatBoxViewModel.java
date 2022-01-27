package com.bignerdranch.android.beatbox;

import android.widget.SeekBar;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class BeatBoxViewModel extends BaseObservable {
    private BeatBox beatBox;
    private float playBackSpeed;

    public BeatBoxViewModel (BeatBox beatBox) {
        this.beatBox = beatBox;
    }

    public void setBeatBox(BeatBox beatBox) {
        this.beatBox = beatBox;
    }

    public BeatBox getBeatBox() {
        return this.beatBox;
    }

    public void setPlayBackSpeed(float playBackSpeed) {
        this.playBackSpeed = playBackSpeed;
        notifyChange();
    }

    @Bindable
    public String getPlayBackSpeed(){
        return Integer.toString((int) (playBackSpeed*10));
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        setPlayBackSpeed((float)progress/10);
        beatBox.playBackSpeed = playBackSpeed;
    }
}
