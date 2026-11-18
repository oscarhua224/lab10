import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(
                    "Registro Semanal de Temperaturas"
            );
            FormularioTemperaturas formulario = new FormularioTemperaturas();

            frame.setContentPane(formulario.getPanelPrincipal());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(850,600);
            frame.setMaximumSize(new java.awt.Dimension(700, 500));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
