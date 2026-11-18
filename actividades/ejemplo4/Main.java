import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(
                    "Visualización de Datos - Gráfico de Barras"
            );

            frame.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            frame.setSize(450, 400);
            AppGraficoBarras grafico = new AppGraficoBarras();
            frame.add(grafico);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
