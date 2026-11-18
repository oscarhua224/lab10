package ejercicio3;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class ReproductorSonidos {
    private JPanel panelPrincipal;
    private JButton aplausosBoton;
    private JButton campanaBoton;
    private JButton explosionBoton;

    public ReproductorSonidos() {
        aplausosBoton.addActionListener(e -> {
            reproducirSonido("aplausos.wav");
        });

        campanaBoton.addActionListener(e -> {
            reproducirSonido("campana.wav");
        });

        explosionBoton.addActionListener(e -> {
            reproducirSonido("explosion.wav");
        });
    }

    private void reproducirSonido(String nombreArchivo) {
        try {
            InputStream archivo = getClass().getResourceAsStream(
                    "/" + nombreArchivo
            );
            if (archivo == null) {
                JOptionPane.showMessageDialog(
                        panelPrincipal,
                        "No se encontro el archivo: "+ nombreArchivo
                );
                return;
            }
            try (InputStream entrada = archivo;
                 AudioInputStream audio =
                         AudioSystem.getAudioInputStream(
                                 new java.io.BufferedInputStream(entrada))) {

                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();

                clip.addLineListener(evento -> {
                    if (evento.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });
            }
        } catch (UnsupportedAudioFileException |
                 IOException |
                 LineUnavailableException ex) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Error al reproducir: "+ ex.getMessage(),
                    "Error de audio",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
