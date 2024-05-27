package Service;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class SoundFileService {

    private Clip clip;

    public SoundFileService() {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void loadSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
            clip.open(audioInput);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void playSound() {
        if (clip != null && !clip.isRunning()) {
            clip.setFramePosition(120);
            clip.start();
        }
    }


}
