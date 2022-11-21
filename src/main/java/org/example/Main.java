package org.example;

import org.example.gui.Ventana;
import org.example.gui.VentanaController;
import org.example.gui.VentanaModel;

public class Main {
    public static void main(String[] args) {
        Ventana view = new Ventana();
        VentanaModel model = new VentanaModel();
        VentanaController controller = new VentanaController(model, view);
    }
}

