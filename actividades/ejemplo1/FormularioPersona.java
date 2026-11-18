package ejemplo1;

import javax.swing.*;

public class FormularioPersona {
    private JPanel panelPrincipal;
    private JTextField campoNombre;
    private JTextField campoEdad;
    private JTextField campoSexo;
    private JButton actualizarBoton;

    private Persona persona = new Persona("Jhon Doe",21,"Masculino");

    public FormularioPersona() {
        campoNombre.setText(persona.getNombre());

        campoEdad.setText(String.valueOf(persona.getEdad()));

        campoSexo.setText(persona.getSexo());

        actualizarBoton.addActionListener(e -> {
            actualizarModelo();
        });
    }

    private void actualizarModelo() {
        try {
            String nombre = campoNombre.getText().trim();
            int edad = Integer.parseInt(campoEdad.getText().trim());
            String sexo = campoSexo.getText().trim();

            persona.setNombre(nombre);
            persona.setEdad(edad);
            persona.setSexo(sexo);

            System.out.println("Modelo actualizado:");
            System.out.println("Nombre: "+ persona.getNombre());
            System.out.println("Edad: "+ persona.getEdad());
            System.out.println("Sexo: "+ persona.getSexo());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Ingrese una edad numerica valida",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
