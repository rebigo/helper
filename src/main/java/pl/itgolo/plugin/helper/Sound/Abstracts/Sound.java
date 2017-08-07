package pl.itgolo.plugin.helper.Sound.Abstracts;

import pl.itgolo.plugin.helper.Logger.Enums.Level;
import pl.itgolo.plugin.helper.Logger.LoggerHelper;
import pl.itgolo.plugin.helper.Sound.BeepHelper;
import pl.itgolo.plugin.helper.Sound.Exceptions.BeepHelperException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by ITGolo on 25.02.2017.
 */
public abstract class Sound {

    /* @var resource file WAV */
    private String resourceWav = null;

    /* @var sound bytes */
    private byte[] soundBytes = null;

    /* @var audio format */
    private AudioFormat audioFormat = null;

    /**
     * Constructor
     *
     * @param resourceWav resource file WAV
     * @throws BeepHelperException error load file WAV
     */
    public Sound(String resourceWav) throws BeepHelperException {
        synchronized (Sound.class) {
            this.resourceWav = resourceWav;
            soundToMemory();
        }
    }

    /**
     * Play sound
     *
     * @throws BeepHelperException error play clip with sound
     */
    public void play() throws BeepHelperException {
        synchronized (Sound.class) {
            try {
                Clip clip = AudioSystem.getClip();
                clip.open(this.audioFormat, this.soundBytes, 0, this.soundBytes.length);
                final long startLoopTime = System.currentTimeMillis();
                clip.start();
                while (clip.getMicrosecondLength() != clip.getMicrosecondPosition()) {
                }
                clip.setMicrosecondPosition(0);
                clip.setFramePosition(0);
                clip.flush();
                clip.stop();
                if (BeepHelper.getDebug())
                    LoggerHelper.setLog(Sound.class, Level.DEBUG, "Time of play sound: " + (System.currentTimeMillis() - startLoopTime));
            } catch (Exception e) {
                throw new BeepHelperException("Can not play clip with sound form WAV " + this.resourceWav);
            }
        }
    }

    /**
     * Play sound in loop
     *
     * @param quantity quantity play
     * @throws BeepHelperException error play clip with sound
     */
    public void playLoop(Integer quantity) throws BeepHelperException {
        for (Integer i = 0; i < quantity; i++) {
            play();
        }
    }

    /**
     * Sound from WAV to memory
     *
     * @throws BeepHelperException error load file WAV
     */
    private void soundToMemory() throws BeepHelperException {
        try {
            InputStream is = getClass().getResourceAsStream(this.resourceWav);
            InputStream bufferedIs = new BufferedInputStream(is);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIs);
            final ByteArrayOutputStream baout = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int c;
            while ((c = ais.read(buffer, 0, buffer.length)) != -1) {
                baout.write(buffer, 0, c);
            }
            baout.close();
            this.soundBytes = baout.toByteArray();
            this.audioFormat = ais.getFormat();
            ais.close();
            is.close();
        } catch (Exception e) {
            throw new BeepHelperException("Can not load WAV file " + this.resourceWav, e);
        }
    }
}