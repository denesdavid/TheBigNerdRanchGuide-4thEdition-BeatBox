package com.bignerdranch.android.beatbox;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SoundViewModel extends BaseObservable {

    private Sound sound;

    public void setSound(Sound sound) {
        this.sound = sound;
        notifyChange();
    }

    @Bindable
    public String getTitle(){
        return sound.name;
    }
}