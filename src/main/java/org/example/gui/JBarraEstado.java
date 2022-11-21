package org.example.gui;

import javax.swing.*;

public class JBarraEstado {
    private JPanel panel1;
    private JLabel lbMensaje;
    private JLabel lbEstado;

    public JBarraEstado() {
        JFrame frame = new JFrame("JBarraEstado");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setMensaje(String mensaje) {
        lbMensaje.setText(mensaje);
    }
    public void setEstado(String mensaje) {
        lbEstado.setText(mensaje);
    }
}
