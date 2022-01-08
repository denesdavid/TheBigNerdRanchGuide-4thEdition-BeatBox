package com.bignerdranch.android.beatbox;

import android.content.res.AssetManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BeatBox {

    private  final  String TAG = "BeatBox";
    private final String SOUNDS_FOLDER = "sample_sounds";
    private AssetManager currentAssetManager;
    ArrayList<Sound> sounds;

    public BeatBox (AssetManager assetManager) {
        currentAssetManager = assetManager;
        sounds = loadSounds();
    }

    private ArrayList<Sound> loadSounds() {
        ArrayList<Sound> sounds = new ArrayList<>();
        try {
            String[] soundNames = currentAssetManager.list(SOUNDS_FOLDER);
            for (String soundName : soundNames) {
                String assetPath = SOUNDS_FOLDER+"/"+soundName;
                Sound sound = new Sound(assetPath);
                sounds.add(sound);
            }
            return sounds;
        } catch (Exception ex) {
            Log.e(TAG, "Could not list assets", ex);
        }
        return sounds;
    }
}