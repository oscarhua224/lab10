package ejercicio1;

import javax.swing.*;

public class FormularioProducto {
    private JTextField campoNombre;
    private JTextField campoPrecio;
    private JPanel panelPrincipal;
    private JTextField campoStock;
    private JTextField campoCategoria;
    private JButton actualizarProducto;
    private JLabel resultadoLabel;

    private final Producto producto =
            new Producto("",0,0,"");
    public FormularioProducto() {
        actualizarProducto.addActionListener(e -> actualizarProducto());
    }

    private void actualizarProducto() {
        try {
            String nombre = campoNombre.getText().trim();
            String categoria = campoCategoria.getText().trim();
            if (nombre.isEmpty() || categoria.isEmpty() ||
                    campoPrecio.getText().trim().isEmpty() ||
                    campoStock.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(panelPrincipal,
                        "Complete todos los campos");
                return;
            }
            double precio = Double.parseDouble(
                    campoPrecio.getText().trim());

            int stock = Integer.parseInt(
                    campoStock.getText().trim());

            if (!Double.isFinite(precio) || precio < 0 || stock < 0) {
                JOptionPane.showMessageDialog(panelPrincipal,
                        "El precio y el stock deben ser valores validos");
                return;
            }
            //actualizar el modelo
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCantidadStock(stock);
            producto.setCategoria(categoria);
            //actualizar interfaz
            resultadoLabel.setText(
                    "<html><b>Producto actualizado</b>" +
                            "<br>Nombre: " + escaparHTML(producto.getNombre()) +
                            "<br>Precio: S/ " + producto.getPrecio() +
                            "<br>Stock: " + producto.getCantidadStock() +
                            "<br>Categoria: " + escaparHTML(producto.getCategoria()) +
                            "</html>"
            );
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(panelPrincipal,
                    "Ingrese un precio y stock numericos validos",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private String escaparHTML(String texto) {
        return texto.replace("&", "&amp;")
                .replace("<","&lt;")
                .replace(">", "&gt;");
    }
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
