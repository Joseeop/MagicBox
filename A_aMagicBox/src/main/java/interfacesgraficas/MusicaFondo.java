package interfacesgraficas;

	// Cargar un clip de audio y reproducirlo.
	
	
	
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
	
	public class MusicaFondo extends Thread{
		
		private File musica;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			try {
				Clip reproductor = AudioSystem.getClip();
				AudioInputStream archivo = AudioSystem.getAudioInputStream(musica);
				reproductor.open(archivo);
				reproductor.start();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		/** 
		 * @param musica
		 */
		public MusicaFondo(File musica) {
			super();
			this.musica = musica;
		}
		
		
	}
