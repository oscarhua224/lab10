import javax.swing.*;
import java.awt.*;

public class AppGraficos extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar una línea azul
        g.setColor(Color.BLUE);
        g.drawLine(10, 10, 100, 100);

        // Dibujar un rectángulo rojo
        g.setColor(Color.RED);
        g.drawRect(50, 50, 100, 50);

        // Dibujar un óvalo verde
        g.setColor(Color.GREEN);
        g.drawOval(150, 50, 100, 50);

        // Dibujar un círculo relleno naranja
        g.setColor(Color.ORANGE);
        g.fillOval(200, 150, 50, 50);

        // Dibujar un texto negro
        g.setColor(Color.BLACK);
        g.drawString("Ejemplo de Gráficos en Swing", 10, 200);
    }
}
