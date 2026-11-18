import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(
                    "Reproductor de efectos de sonido"
            );

            ReproductorSonidos reproductor = new ReproductorSonidos();

            frame.setContentPane(reproductor.getPanelPrincipal());

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 250);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
