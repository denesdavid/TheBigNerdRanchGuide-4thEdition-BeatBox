package com.bignerdranch.android.beatbox;

import java.lang.reflect.Array;

public class Sound {

    private final String WAV = ".wav";
    public String assetPath;
    public String name;
    public Integer soundId = null;

    public Sound (String assetPath) {
        this.assetPath = assetPath;
        String[] splittedPath = assetPath.split("/");
        String nameWithExtension = splittedPath[splittedPath.length-1];
        String nameWithoutExtension = nameWithExtension.
                substring(0, nameWithExtension.length() - WAV.length());
        name = nameWithoutExtension;
    }
}
