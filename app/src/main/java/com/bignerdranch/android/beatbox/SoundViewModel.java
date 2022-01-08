package com.bignerdranch.android.beatbox;

public class SoundViewModel {

    Sound sound;

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public String getTitle(){
        return sound.name;
    }
}