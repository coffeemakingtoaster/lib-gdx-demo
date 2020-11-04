package com.mygdx.game.additional;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;




public class Settings{
    private static final String MUSIC_VOLUME = "volume";
	private static final String MUSIC_ENABLED = "music.enabled";
	private static final String SOUND_ENABLED = "sound.enabled";
	private static final String SOUND_VOL = "sound";
	private static final String NAME = "myGdxGame";
    
    protected Preferences getPrefs() {
		return Gdx.app.getPreferences(NAME);
	}
 
	public boolean isSoundEffectsEnabled() {
		return getPrefs().getBoolean(SOUND_ENABLED, true);
	}
 
	public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
		getPrefs().putBoolean(SOUND_ENABLED, soundEffectsEnabled);
		getPrefs().flush();
	}
 
	public boolean isMusicEnabled() {
		return getPrefs().getBoolean(MUSIC_ENABLED, true);
	}
 
	public void setMusicEnabled(boolean musicEnabled) {
		getPrefs().putBoolean(MUSIC_ENABLED, musicEnabled);
		getPrefs().flush();
	}
 
	public float getMusicVolume() {
		return getPrefs().getFloat(MUSIC_VOLUME, 0.5f);
	}
 
	public void setMusicVolume(float volume) {
        System.out.println(volume);
		getPrefs().putFloat(MUSIC_VOLUME, volume);
		getPrefs().flush();
	}
	
	public float getSoundVolume() {
		return getPrefs().getFloat(SOUND_VOL, 0.5f);
	}
 
	public void setSoundVolume(float volume) {
		getPrefs().putFloat(SOUND_VOL, volume);
		getPrefs().flush();
    }
    public void writeSettings(){
        System.out.println("writing Settings!");
        JSONObject settingToWrite = new JSONObject();
        settingToWrite.put("MUSIC_VOLUME",MUSIC_VOLUME);
        settingToWrite.put("MUSIC_ENABLED",MUSIC_ENABLED);
        settingToWrite.put("SOUND_ENABLED",SOUND_ENABLED);
        settingToWrite.put("SOUND_VOL",SOUND_VOL);
        File f = new File("core/data/settings.json");
        try {
            if(!f.exists()) { 
                f.createNewFile();
            }
            FileWriter fw = new FileWriter("core/data/settings.json");
            fw.write(settingToWrite.toJSONString());
            fw.flush();          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
