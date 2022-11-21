package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class Ventana {
    public Label tfBusqueda;
    private JPanel panel1;
    private JLabel Nombre;
    JTextField tfNombre;
    private JLabel Desarrolladora;
    JTextField tfDesarroladora;
    JTextField tfDescripcion;
    JTextField tfPrecio;
    JButton btNuevo;
    JButton btGuardar;
    JButton btModificar;
    JButton btEliminar;
    JButton btBuscar;
    JButton btPrimero;
    JButton btAnterior;
    JButton btSiguiente;
    JButton btUltimo;
    private JLabel Descripción;
    private JLabel Precio;

    public Ventana() {

        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
