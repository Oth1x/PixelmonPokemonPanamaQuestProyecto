package Pixelmon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private JPanel panelMenuPrincipal;
    private JButton IniciarButton;
    private JButton SalirButton;
    private JLabel lbTitulo;

    public MenuPrincipal() {
        setTitle("Pokemon Panameño");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(panelMenuPrincipal);


        cargarTitulo();


        IniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PokemonSeleccion seleccion = new PokemonSeleccion();
                seleccion.setVisible(true);
                dispose();
            }
        });


        SalirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void cargarTitulo() {

        cargarImagen(lbTitulo, "imagen/titulo.png", 500, 250);
    }


    private void cargarImagen(JLabel label, String path, int ancho, int alto) {
        if (label == null) {
            System.err.println("El JLabel para la ruta " + path + " es nulo. Revisa el 'field name' en el UI Designer.");
            return;
        }

        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image originalImage = originalIcon.getImage();


            Image imagenRedimensionada = originalImage.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);


            label.setIcon(new ImageIcon(imagenRedimensionada));
            label.setText("");
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: " + path);
            label.setText("No img");
        }
    }
}
