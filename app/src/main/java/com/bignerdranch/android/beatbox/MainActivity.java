package com.bignerdranch.android.beatbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.android.beatbox.databinding.ActivityMainBinding;
import com.bignerdranch.android.beatbox.databinding.ListItemSoundBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BeatBox beatBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beatBox = new BeatBox(getAssets());

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), 3));
        binding.recyclerView.setAdapter(new SoundAdapter(beatBox.sounds));
    }

    private class SoundHolder extends RecyclerView.ViewHolder{
        public SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
        }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{

        private ArrayList<Sound> sounds;

        public SoundAdapter (ArrayList<Sound> currentSounds) {
            sounds = currentSounds;
        }

        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            ListItemSoundBinding binding =
                    DataBindingUtil.inflate(getLayoutInflater(), R.layout.list_item_sound,
                            parent, false);
            return new SoundHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return sounds.size();
        }
    }
}