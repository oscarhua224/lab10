import javax.swing.*;
import java.awt.*;

public class FormularioTemperaturas {
    private JPanel panelPrincipal;
    private JPanel panelTemperaturas;
    private JTextField campoLunes;
    private JTextField campoMartes;
    private JTextField campoMiercoles;
    private JTextField campoJueves;
    private JTextField campoViernes;
    private JTextField campoSabado;
    private JTextField campoDomingo;
    private JButton mostrarGraficoBoton;
    private JPanel panelBoton;
    private JPanel panelContenedorGrafico;

    private final PanelGrafico grafico = new PanelGrafico();

    public FormularioTemperaturas() {
        panelContenedorGrafico.setLayout(new BorderLayout());
        panelContenedorGrafico.add(grafico, BorderLayout.CENTER);

        mostrarGraficoBoton.addActionListener(e -> mostrarGrafico());
    }

    private void mostrarGrafico() {
        JTextField[] campos = {
                campoLunes, campoMartes, campoMiercoles,
                campoJueves, campoViernes, campoSabado,
                campoDomingo
        };
        String[] dias = {
                "lunes", "martes", "miercoles", "jueves",
                "viernes", "sabado", "domingo"
        };
        double[] temperaturas = new double[7];

        for (int i = 0; i < campos.length; i++) {
            String texto = campos[i].getText().trim();

            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(
                        panelPrincipal, "Ingrese la temperatura del "+ dias[i],
                        "Campo vacio",
                        JOptionPane.WARNING_MESSAGE
                );
                campos[i].requestFocusInWindow();
                return;
            }
            try {
                temperaturas[i] = Double.parseDouble(texto);

                if (!Double.isFinite(temperaturas[i])) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        panelPrincipal,
                        "Temperatura invalida para "+ dias[i],
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                campos[i].requestFocusInWindow();
                return;
            }
        }
        grafico.setTemperaturas(temperaturas);
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
