package com.bignerdranch.android.beatbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bignerdranch.android.beatbox.databinding.ActivityMainBinding;
import com.bignerdranch.android.beatbox.databinding.ListItemSoundBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BeatBoxJetPackViewModel beatBoxJetPackViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beatBoxJetPackViewModel = new ViewModelProvider(this, new BeatBoxFactoryModel(getAssets())).get(BeatBoxJetPackViewModel.class);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new BeatBoxViewModel(beatBoxJetPackViewModel.beatBox));
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), 3));
        binding.recyclerView.setAdapter(new SoundAdapter(beatBoxJetPackViewModel.beatBox.sounds));
    }

    private class SoundHolder extends RecyclerView.ViewHolder{

        private ListItemSoundBinding currentBinding;

        public SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            binding.setViewModel(new SoundViewModel(beatBoxJetPackViewModel.beatBox));
            currentBinding = binding;
        }

        void bind(Sound sound){
            currentBinding.getViewModel().setSound(sound);
            currentBinding.executePendingBindings();
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
            Sound sound = sounds.get(position);
            holder.bind(sound);
        }

        @Override
        public int getItemCount() {
            return sounds.size();
        }
    }
}