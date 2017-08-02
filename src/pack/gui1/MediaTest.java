package pack.gui1;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class MediaTest {
	public void aa(){
		File f = new File("c:/work/sori/gun.wav");
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		Clip clip;
		
		try {
			stream = AudioSystem.getAudioInputStream(f);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			System.out.println("err : " + e);
		}	
	}
	
	public static void main(String[] args) {
		MediaTest test = new MediaTest();
		while(true){
			try {
				test.aa();
				Thread.sleep(3000);
			} catch (Exception e) {
				
			}
	
		}

	}

}
