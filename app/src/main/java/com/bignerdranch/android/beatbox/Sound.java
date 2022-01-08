package com.bignerdranch.android.beatbox;

import java.lang.reflect.Array;

public class Sound {

    private final String WAV = ".wav";
    public String name;

    public Sound (String assetPath) {
        String[] splittedPath = assetPath.split("/");
        String nameWithExtension = splittedPath[splittedPath.length-1];
        String nameWithoutExtension = nameWithExtension.
                substring(0, nameWithExtension.length() - WAV.length());
        name = nameWithExtension;
    }
}
