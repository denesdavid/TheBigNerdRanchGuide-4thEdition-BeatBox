package com.bignerdranch.android.beatbox;

import static org.junit.Assert.*;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class SoundViewModelTest {

    private BeatBox beatBox;
    private Sound sound;
    private SoundViewModel subject;

    @Before
    public void setUp() throws Exception {
        beatBox = Mockito.mock(BeatBox.class);
        sound = new Sound("assetPath");
        subject = new SoundViewModel(beatBox);
        subject.setSound(sound);
    }

    @Test
    public void exposesSoundNamesAsTitle(){
        MatcherAssert.assertThat(subject.getTitle(), CoreMatchers.is(sound.name));
    }

    public void callsBeatBoxPlayOnButtonClicked(){
        subject.onButtonClicked();
        //verifying that BeatBox.play(Sound) is called
        Mockito.verify(beatBox).play(sound);
    }
}