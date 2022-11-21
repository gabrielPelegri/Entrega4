package org.example.gui;

;
import org.example.base.Juego;


import java.util.ArrayList;

/**
 * Modelo para la ventana
 *
 * @author Santiago Faci
 * @curso 2015-2016
 */
public class VentanaModel {

    private ArrayList<Juego> listaJuegos;
    private int posicion;

    public VentanaModel() {
        listaJuegos = new ArrayList<>();
        posicion = 0;
    }

    public void guardar(Juego juego) {

        listaJuegos.add(juego);
        posicion++;
    }


    public void modificar(Juego juegoModificado) {

        Juego animal = listaJuegos.get(posicion);
        animal.setNombre(juegoModificado.getNombre());
        animal.setDescripcion(juegoModificado.getDescripcion());
        animal.setDesarrolladora(juegoModificado.getDesarrolladora());
        animal.setPrecio(juegoModificado.getPrecio());
    }

    /**
     * Elimina el animal actual
     */
    public void eliminar() {
        listaJuegos.remove(posicion);
    }

    public Juego getActual() {

        return listaJuegos.get(posicion);
    }

    /**
     * Busca un animal en la lista
     *
     * @param nombre El nombre del animal
     * @return El animal o null si no se ha encontrado nada
     */
    public Juego buscar(String nombre) {
        for (Juego juego : listaJuegos) {
            if (juego.getNombre().equals(nombre)) {
                return juego;
            }
        }

        return null;
    }

    /**
     * Obtiene el animal que está en primera posición en la lista
     *
     * @return
     */
    public Juego getPrimero() {

        posicion = 0;
        return listaJuegos.get(posicion);
    }

    /**
     * Obtiene el animal que está en la posición anterior a la actual
     *
     * @return
     */
    public Juego getAnterior() {

        if (posicion == 0)
            return null;

        posicion--;
        return listaJuegos.get(posicion);
    }

    /**
     * Obtiene el animal que está en la posición siguiente a la actual
     *
     * @return
     */
    public Juego getSiguiente() {

        if (posicion == listaJuegos.size() - 1)
            return null;

        posicion++;
        return listaJuegos.get(posicion);
    }

    /**
     * Obtiene el animal que está en la última posición de la lista
     *
     * @return
     */
    public Juego getUltimo() {

        posicion = listaJuegos.size() - 1;
        return listaJuegos.get(posicion);
    }
}
