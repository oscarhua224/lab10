import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class ReproductorMusica {
    private JPanel panelPrincipal;
    private JButton reproducirBoton;
    private JButton pausarBoton;
    private JButton reanudarBoton;
    private JLabel estadoLabel;

    private Clip clip;
    private long posicionPausa = 0;

    public ReproductorMusica() {
        reproducirBoton.addActionListener(e -> {
            reproducir();
        });

        pausarBoton.addActionListener(e -> {
            pausar();
        });

        reanudarBoton.addActionListener(e -> {
            reanudar();
        });
    }

    private void reproducir() {
        try {
            //cerrar si audio anterior existe
            if(clip != null) {
                clip.stop();
                clip.close();
            }
            //buscar el archivo
            InputStream archivo = getClass().getResourceAsStream("/musica.wav");

            if (archivo == null) {
                JOptionPane.showMessageDialog(
                        panelPrincipal,
                        "No se encontro el archivo"
                );
                return;
            }
            //cargar el archivo
            try (InputStream entrada = archivo;
                 AudioInputStream audio =
                         AudioSystem.getAudioInputStream(
                                 new BufferedInputStream(entrada))) {
                clip = AudioSystem.getClip();
                clip.open(audio);
            }
            //iniciar desde el principio
            posicionPausa = 0;
            clip.setMicrosecondPosition(0);
            clip.start();

            estadoLabel.setText("Estado: reproduciendo");
        } catch (UnsupportedAudioFileException |
                 IOException |
                 LineUnavailableException ex) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Error al reproducir: "+ ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }
    private void pausar() {
        if (clip != null && clip.isRunning()) {
            posicionPausa = clip.getMicrosecondPosition();

            clip.stop();

            estadoLabel.setText("Estado: pausado");
        }
    }
    private void reanudar() {
        if (clip != null && !clip.isRunning()
                && posicionPausa < clip.getMicrosecondLength()) {

            clip.setMicrosecondPosition(posicionPausa);
            clip.start();

            estadoLabel.setText("Estado: reproduciendo");
        }
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
