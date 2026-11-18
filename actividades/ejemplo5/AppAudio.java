import javax.swing.*;
import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;

public class AppAudio {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Reproducción de Audio");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton playButton = new JButton("Reproducir Audio");

        playButton.addActionListener(
                e -> playAudio("explosion.wav")
        );

        frame.add(playButton);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void playAudio(String filePath) {
        try {
            InputStream archivo = AppAudio.class
                    .getResourceAsStream("/" + filePath);

            if (archivo == null) {
                System.out.println("Archivo no encontrado: " + filePath);
                return;
            }

            try (InputStream entrada = archivo;
                 AudioInputStream audioStream =
                         AudioSystem.getAudioInputStream(
                                 new BufferedInputStream(entrada))) {

                Clip clip = AudioSystem.getClip();

                clip.open(audioStream);
                clip.start();

                clip.addLineListener(evento -> {
                    if (evento.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });
            }

        } catch (UnsupportedAudioFileException |
                 IOException |
                 LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
