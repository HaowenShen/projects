package target;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AePlayWave extends Thread {
	private String filename;
	public AePlayWave(String wavefile) {
		filename = wavefile;
	}
	public void run() {
		File soundFile = new File(filename);
		AudioInputStream audioInputStream = null;
		
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
			return;
		}
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine sdl = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try {
			sdl=(SourceDataLine)AudioSystem.getLine(info);
			sdl.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		}
		sdl.start();
		int nBytesRead = 0;
		//»º³å
		byte[] abData = new byte[1024];
		
		try {
			while(nBytesRead!=-1) {
				nBytesRead = audioInputStream.read(abData,0,abData.length);
				if(nBytesRead!=-1) {
					sdl.write(abData, 0, nBytesRead);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
			return;
		}finally {
			sdl.drain();
			sdl.close();
		}
	}
}
