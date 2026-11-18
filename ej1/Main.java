import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gestion de Productos");

            FormularioProducto formulario = new FormularioProducto();

            frame.setContentPane(formulario.getPanelPrincipal());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450,400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
