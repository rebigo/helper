package pl.itgolo.plugin.helper.Sound.Classes;

import pl.itgolo.plugin.helper.Sound.Abstracts.Sound;
import pl.itgolo.plugin.helper.Sound.Exceptions.BeepHelperException;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class SoundBeep06 extends Sound {

    /**
     * Constructor
     *
     * @param resourceWav resource file WAV
     * @throws BeepHelperException                   error load file WAV
     */
    public SoundBeep06(String resourceWav) throws BeepHelperException {
        super(resourceWav);
    }
}
