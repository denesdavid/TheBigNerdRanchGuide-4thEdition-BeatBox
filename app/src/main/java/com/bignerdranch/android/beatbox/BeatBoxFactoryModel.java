package com.bignerdranch.android.beatbox;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.lang.reflect.InvocationTargetException;

public class BeatBoxFactoryModel implements ViewModelProvider.Factory {

    private AssetManager _assetManager;

    public BeatBoxFactoryModel(AssetManager assetManager) {
        _assetManager = assetManager;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        T model = null;
        try {
            model = modelClass.getConstructor(AssetManager.class).newInstance(_assetManager);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return model;
    }
}
