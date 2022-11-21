package org.example.gui;

import org.example.base.Juego;
import org.example.util.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaController implements ActionListener, KeyListener {

    private VentanaModel model;
    private Ventana view;

    private int posicion;

    public VentanaController(VentanaModel model, Ventana view) {
        this.model = model;
        this.view = view;
        anadirActionListener(this);
        anadirKeyListener(this);

        posicion = 0;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String actionCommand = event.getActionCommand();
        Juego juego = null;

        switch (actionCommand) {
            case "Nuevo":
                view.tfNombre.setText("");
                view.tfNombre.setEditable(true);
                view.tfDescripcion.setText("");
                view.tfDescripcion.setEditable(true);
                view.tfPrecio.setText("");
                view.tfPrecio.setEditable(true);
                view.tfDesarroladora.setText("");
                view.tfDesarroladora.setEditable(true);

                view.btGuardar.setEnabled(true);
                break;
            case "Guardar":

                if (view.tfNombre.getText().equals("")) {
                    Util.mensajeError("El nombre es un campo obligatorio", "Nuevo Animal");
                    return;
                }

                juego = new Juego();
                juego.setNombre(view.tfNombre.getText());
                juego.setDesarrolladora(view.tfDesarroladora.getText());
                juego.setDescripcion(view.tfDescripcion.getText());
                juego.setPrecio(Float.parseFloat(view.tfPrecio.getText()));

                model.guardar(juego);

                view.btGuardar.setEnabled(false);
                break;
            case "Modificar":
                juego = new Juego();
                juego.setNombre(view.tfNombre.getText());
                juego.setDesarrolladora(view.tfDesarroladora.getText());
                juego.setDescripcion(view.tfDescripcion.getText());
                juego.setPrecio(Float.parseFloat(view.tfPrecio.getText()));

                model.modificar(juego);
                break;
            case "Cancelar":
                view.tfNombre.setEditable(false);
                view.tfDescripcion.setEditable(false);
                view.tfPrecio.setEditable(false);
                view.tfDesarroladora.setEditable(false);

                juego = model.getActual();
                cargar(juego);

                view.btGuardar.setEnabled(false);
                break;
            case "Eliminar":
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                    return;

                model.eliminar();
                juego = model.getActual();
                cargar(juego);
                break;
            case "Buscar":
                juego = model.buscar(view.tfBusqueda.getText());
                if (juego == null) {
                    Util.mensajeInformacion("No se ha encontrado ningún animal con ese nombre", "Buscar");
                    return;
                }
                cargar(juego);
                break;
            case "Primero":
                juego = model.getPrimero();
                cargar(juego);
                break;
            case "Anterior":
                juego = model.getAnterior();
                cargar(juego);
                break;
            case "Siguiente":
                juego = model.getSiguiente();
                cargar(juego);
                break;
            case "Ultimo":
                juego = model.getUltimo();
                cargar(juego);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == view.tfBusqueda) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                view.btBuscar.doClick();
            }
        }
    }

    /**
     * Carga los datos de un animal en la vista
     *
     * @param juego
     */
    private void cargar(Juego juego) {
        if (juego == null)
            return;

        view.tfNombre.setText(juego.getNombre());
        view.tfDescripcion.setText(juego.getDescripcion());
        view.tfDesarroladora.setText(juego.getDesarrolladora());
        view.tfPrecio.setText(String.valueOf(juego.getPrecio()));
    }

    private void anadirKeyListener(KeyListener listener) {
        view.tfBusqueda.addKeyListener(listener);
    }

    private void anadirActionListener(ActionListener listener) {

        view.btNuevo.addActionListener(listener);
        view.btGuardar.addActionListener(listener);
        view.btModificar.addActionListener(listener);
        view.btEliminar.addActionListener(listener);
        view.btPrimero.addActionListener(listener);
        view.btAnterior.addActionListener(listener);
        view.btSiguiente.addActionListener(listener);
        view.btUltimo.addActionListener(listener);
        view.btBuscar.addActionListener(listener);
    }
}
