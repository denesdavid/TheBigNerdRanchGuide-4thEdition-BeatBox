package com.bignerdranch.android.beatbox;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class BeatBox {

    private  final  String TAG = "BeatBox";
    private final String SOUNDS_FOLDER = "sample_sounds";
    private AssetManager assets;
    private final int MAX_SOUNDS = 5;
    private SoundPool soundPool = new SoundPool.Builder().setMaxStreams(MAX_SOUNDS).build();
    ArrayList<Sound> sounds;


    public BeatBox (AssetManager assetManager) {
        assets = assetManager;
        sounds = loadSounds();
    }

    void play(Sound sound){
        if (sound.soundId != null){
            soundPool.play(sound.soundId, 1.0f,1.0f, 1, 0, 1.0f);
        }
    }

    void release(){
        soundPool.release();
    }

    private ArrayList<Sound> loadSounds() {
        ArrayList<Sound> sounds = new ArrayList<>();
        try {
            String[] soundNames = assets.list(SOUNDS_FOLDER);
            for (String soundName : soundNames) {
                String assetPath = SOUNDS_FOLDER+"/"+soundName;
                Sound sound = new Sound(assetPath);
                //sounds.add(sound);
                try {
                    load(sound);
                    sounds.add(sound);
                } catch (Exception ex) {
                    Log.e(TAG, "Cound not load sound $filename", ex);
                }
            }
            return sounds;
        } catch (Exception ex) {
            Log.e(TAG, "Could not list assets", ex);
        }
        return sounds;
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = assets.openFd(sound.assetPath);
        Integer soundId = soundPool.load(afd, 1);
        sound.soundId = soundId;
    }
}