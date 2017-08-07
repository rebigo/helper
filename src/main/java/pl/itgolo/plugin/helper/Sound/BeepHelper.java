package pl.itgolo.plugin.helper.Sound;

import pl.itgolo.plugin.helper.Sound.Classes.SoundBeep06;
import pl.itgolo.plugin.helper.Sound.Classes.SoundBeep07;
import pl.itgolo.plugin.helper.Sound.Classes.SoundCensorBeep01;
import pl.itgolo.plugin.helper.Sound.Exceptions.BeepHelperException;

import java.util.Objects;

/**
 * Created by ITGolo on 25.02.2017.
 */
public class BeepHelper {

    /* @var is debug */
    private static Boolean debug = false;

    /* @var sound censor-beep-01.wav */
    private static SoundCensorBeep01 soundCensorBeep01 = null;

    /* @var sound beep-07.wav */
    private static SoundBeep07 soundBeep07 = null;

    /* @var sound beep-06.wav */
    private static SoundBeep06 soundBeep06 = null;

    /**
     * Get sound censor-beep-01.wav
     * @return sound censor-beep-01.wav
     * @throws BeepHelperException error load file WAV
     */
    public static SoundCensorBeep01 getSoundCensorBeep01() throws BeepHelperException {
        if (Objects.isNull(soundCensorBeep01)){
            soundCensorBeep01 = new SoundCensorBeep01("/pl/itgolo/plugin/helper/Sound/Resources/Wav/censor-beep-01.wav");
        }
        return soundCensorBeep01;
    }

    /**
     * Get sound beep-07.wav
     * @return sound beep-07.wav
     * @throws BeepHelperException error load file WAV
     */
    public static SoundBeep07 getSoundBeep07() throws BeepHelperException {
        if (Objects.isNull(soundBeep07)){
            soundBeep07 = new SoundBeep07("/pl/itgolo/plugin/helper/Sound/Resources/Wav/beep-07.wav");
        }
        return soundBeep07;
    }

    /**
     * Get sound beep-06.wav
     * @return sound beep-06.wav
     * @throws BeepHelperException error load file WAV
     */
    public static SoundBeep06 getSoundBeep06() throws BeepHelperException {
        if (Objects.isNull(soundBeep06)){
            soundBeep06 = new SoundBeep06("/pl/itgolo/plugin/helper/Sound/Resources/Wav/beep-06.wav");
        }
        return soundBeep06;
    }

    /**
     * Get debug
     * @return is debug
     */
    public static Boolean getDebug() {
        return debug;
    }

    /**
     * Set debug
     * @param debug debug
     */
    public static void setDebug(Boolean debug) {
        BeepHelper.debug = debug;
    }
}
