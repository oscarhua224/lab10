import javafx.embed.swing.JFXPanel;
import javax.swing.*;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoExample {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Crear ventana Swing
            JFrame frame = new JFrame("Reproducción de Video");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Crear el contenedor JavaFX
            JFXPanel jfxPanel = new JFXPanel();

            // Agregarlo a la ventana Swing
            frame.add(jfxPanel);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);



            Platform.runLater(() -> {
                try {
                    // Localizar el video en resources
                    var recurso = VideoExample.class
                            .getResource("/video.mp4");

                    if (recurso == null) {
                        System.err.println("No se encontró video.mp4");
                        return;
                    }

                    // Crear el recurso multimedia
                    Media media = new Media(
                            recurso.toExternalForm()
                    );

                    // Crear el reproductor
                    MediaPlayer mediaPlayer = new MediaPlayer(media);

                    mediaPlayer.setOnError(() -> {
                        System.err.println(
                                "Error de MediaPlayer: " + mediaPlayer.getError()
                        );
                    });
                    // Crear el componente visual
                    MediaView mediaView = new MediaView(mediaPlayer);

                    // Ajustar las dimensiones del video
                    mediaView.setFitWidth(780);
                    mediaView.setFitHeight(550);
                    mediaView.setPreserveRatio(true);

                    // Incorporar el video a la escena
                    Group root = new Group(mediaView);
                    Scene scene = new Scene(root, 800, 600);

                    jfxPanel.setScene(scene);

                    // Iniciar la reproducción
                    mediaPlayer.play();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });


        });
    }
}
