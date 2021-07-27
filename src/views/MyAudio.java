package views;

import java.applet.AudioClip;
import java.net.URL;

public class MyAudio {
	
	private AudioClip sound;

	public MyAudio(URL direction) {
		this.sound = java.applet.Applet.newAudioClip(direction);
	}
	
	public AudioClip getAudio() {
		return this.sound;
	}
	
	
}
