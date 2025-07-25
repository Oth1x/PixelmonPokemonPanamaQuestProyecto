package Pixelmon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presentacion extends JFrame {
    private JPanel panelPresentacion;
    private JLabel lbLogoUTP;
    private JLabel lbLogoFacultad;
    private JButton continuarButton;
    private JTextArea infoTextArea;

    public Presentacion() {
        setTitle("Presentación del Proyecto");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(panelPresentacion);

        cargarLogos();


        if (infoTextArea != null) {
            infoTextArea.setEditable(false);
            infoTextArea.setLineWrap(true);
            infoTextArea.setWrapStyleWord(true);
            infoTextArea.setOpaque(false);

            String textoPresentacion = "Universidad Tecnológica de Panamá\n" +
                    "Facultad de Ingeniería de Sistemas Computacionales\n\n" +
                    "Licenciatura en Desarrollo de Software\n\n" +
                    "Materia: Programación de Software\n\n" +
                    "Proyecto Semestral:\n" +
                    "PixelMon: PanamaQuest\n\n" +
                    "Estudiante:\n" +
                    "Astrid Madrid 8-992-1420\n" +
                    "Ryan Velásquez 8-1022-291\n" +
                    "Jonathan Velásquez 8-1022-292\n" +
                    "Alex Wu 3-757-290\n" +
                    "Profesor:\n" +
                    "Yángüez, Rodrigo\n\n" +
                    "Fecha: 25/07/2025";

            infoTextArea.setText(textoPresentacion);
        }


        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);

                dispose();
            }
        });
    }

    private void cargarLogos() {
        cargarImagen(lbLogoUTP, "LogoUTP/UTP.png", 200, 200);
        cargarImagen(lbLogoFacultad, "LogoUTP/Facultad.png", 200, 200);
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