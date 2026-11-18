import javax.swing.*;
import java.awt.*;

public class AppGraficoBarras extends JPanel {

    // Datos de los productos
    private String[] productos = {
            "Producto A",
            "Producto B",
            "Producto C",
            "Producto D"
    };

    // Ventas de cada producto
    private int[] ventas = {50, 120, 80, 150};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Activar antialiasing
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Dimensiones del gráfico
        int anchoBarra = 50;
        int espacioBarra = 20;
        int margenIzquierdo = 50;
        int margenInferior = 50;
        int alturaMaxima = 200;

        // Encontrar la venta máxima
        int maxVenta = 0;

        for (int venta : ventas) {
            if (venta > maxVenta) {
                maxVenta = venta;
            }
        }


        // Dibujar las barras
        for (int i = 0; i < productos.length; i++) {

            int alturaBarra = (int) (
                    (double) ventas[i] / maxVenta * alturaMaxima
            );

            int x = margenIzquierdo
                    + i * (anchoBarra + espacioBarra);

            int y = getHeight()
                    - margenInferior - alturaBarra;

            // Dibujar barra
            g2d.setColor(new Color(100, 150, 200));
            g2d.fillRect(x, y, anchoBarra, alturaBarra);


            // Mostrar el valor encima de la barra
            g2d.setColor(Color.BLACK);

            g2d.drawString(
                    String.valueOf(ventas[i]),
                    x + (anchoBarra / 4),
                    y - 5
            );

            // Mostrar el nombre debajo de la barra
            g2d.drawString(
                    productos[i],
                    x,
                    getHeight() - margenInferior + 20
            );

        }

        // Dibujar el eje Y
        g2d.setColor(Color.BLACK);

        g2d.drawLine(
                margenIzquierdo,
                getHeight() - margenInferior,
                margenIzquierdo,
                getHeight() - margenInferior - alturaMaxima
        );

        // Mostrar el título del eje Y
        g2d.drawString(
                "Ventas",
                margenIzquierdo - 40,
                getHeight() - margenInferior - alturaMaxima
        );


    }

}
