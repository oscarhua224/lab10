package ejercicio2;

import javax.swing.*;
import java.awt.*;

public class PanelGrafico extends JPanel {
    private double[] temperaturas = null;

    private final String[] dias = {
            "Lun", "Mar", "Mie", "Jue",
            "Vie", "Sab", "Dom"
    };

    public PanelGrafico() {
        setBackground(Color.WHITE);
    }

    public void setTemperaturas(double[] temperaturas) {
        this.temperaturas = temperaturas.clone();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        if (temperaturas == null) {
            g2d.setColor(Color.GRAY);
            g2d.drawString(
                    "Ingrese las temperaturas para mostrar el grafico",
                    30,30
            );
            g2d.dispose();
            return;
        }
        int izquierda = 65;
        int derecha = getWidth() - 35;
        int arriba = 45;
        int abajo = getHeight() - 55;

        int ancho = derecha - izquierda;
        int alto = abajo - arriba;

        if (ancho <= 0 || alto <= 0) {
            g2d.dispose();
            return;
        }
        //tempeartura maxima y minima

        double min = temperaturas[0];
        double max = temperaturas[0];

        for (double temp : temperaturas) {
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        //margen vertical

        if (max == min) {
            min -= 5;
            max += 5;
        } else {
            double margen = (max - min)* 0.15;
            min -= margen;
            max += margen;
        }
        //dibujar ejees

        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(2));

        g2d.drawLine(izquierda, arriba, izquierda, abajo);
        g2d.drawLine(izquierda, abajo, derecha, abajo);
        //dibujar lineas horizontales

        g2d.setStroke(new BasicStroke(1));

        for (int i = 0; i <= 5; i++) {
            int y = abajo - i * alto/5;
            double valor = min + i * (max - min) /5;

            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine(izquierda, y, derecha, y);

            g2d.setColor(Color.BLACK);
            g2d.drawString(
                    String.format("%.1f", valor),
                    10, y+5
            );
        }
        int[] puntosX = new int[7];
        int[] puntosY = new int[7];

        //calcular coordenadas
        for (int i = 0; i < 7; i++) {
            puntosX[i] = izquierda + i * ancho / 6;

            puntosY[i] = abajo - (int) (
                    (temperaturas[i]-min) /
                            (max - min) * alto
                    );
        }
        //conectar los puntos
        // Conectar los puntos con líneas
        g2d.setColor(new Color(40, 110, 210));
        g2d.setStroke(new BasicStroke(3));

        for (int i = 0; i < 6; i++) {
            g2d.drawLine(
                    puntosX[i], puntosY[i],
                    puntosX[i + 1], puntosY[i + 1]
            );
        }


        g2d.setColor(new Color(40, 110, 210));
        g2d.setStroke(new BasicStroke(3));

        for (int i = 0; i < 7; i++) {
            g2d.setColor(Color.RED);

            g2d.fillOval(
                    puntosX[i] - 5,
                    puntosY[i] - 5,
                    10, 10
            );
            g2d.setColor(Color.BLACK);

            g2d.drawString(
                    dias[i],
                    puntosX[i] - 12,
                    abajo + 20
            );

            g2d.drawString(
                    String.format("%.1f", temperaturas[i]),
                    puntosX[i] - 13,
                    puntosY[i] - 12
            );
        }
        g2d.dispose();
    }
}
