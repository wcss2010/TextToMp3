/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttomp3;

import java.io.File;

/**
 *
 * @author wcss
 */
public class SpeakConfig {
    private TextSpeaker speaker;
    private  int speed;
    private int volume;
    private int pitch;
    private String text;
    private File textFile;

    /**
     * @return the speaker
     */
    public TextSpeaker getSpeaker() {
        return speaker;
    }

    /**
     * @param speaker the speaker to set
     */
    public void setSpeaker(TextSpeaker speaker) {
        this.speaker = speaker;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * @return the pitch
     */
    public int getPitch() {
        return pitch;
    }

    /**
     * @param pitch the pitch to set
     */
    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the textFile
     */
    public File getTextFile() {
        return textFile;
    }

    /**
     * @param textFile the textFile to set
     */
    public void setTextFile(File textFile) {
        this.textFile = textFile;
    }
}