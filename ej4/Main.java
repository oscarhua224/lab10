import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Reproductor de Musica");

            ReproductorMusica reproductor = new ReproductorMusica();

            frame.setContentPane(reproductor.getPanelPrincipal());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setSize(450, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
