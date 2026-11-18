import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class AppGraficos2D extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Activar antialiasing
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Rectángulo original
        g2d.setColor(Color.GRAY);
        g2d.fillRect(50, 50, 100, 50);

        // Guardar la transformación original
        AffineTransform originalTransform = g2d.getTransform();

        // Aplicar traslación
        g2d.translate(200, 0);

        // Dibujar rectángulo trasladado
        g2d.setColor(Color.BLUE);
        g2d.fillRect(50, 50, 100, 50);

        // Restaurar la transformación original
        g2d.setTransform(originalTransform);


        // Rotación
        g2d.translate(0, 150);

        g2d.rotate(
                Math.toRadians(45),
                100,
                75
        );

        g2d.setColor(Color.GREEN);
        g2d.fillRect(50, 50, 100, 50);

        // Restaurar transformación original
        g2d.setTransform(originalTransform);


        // Escalado
        g2d.translate(200, 150);

        g2d.scale(1.5, 0.5);

        g2d.setColor(Color.ORANGE);
        g2d.fillRect(50, 50, 100, 50);

        // Restaurar transformación original
        g2d.setTransform(originalTransform);



        // Sesgado horizontal
        g2d.translate(0, 300);

        g2d.shear(0.5, 0);

        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(50, 50, 100, 50);

        // Restaurar transformación original
        g2d.setTransform(originalTransform);

    }

}
