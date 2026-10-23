package com.gestorFacturas.controlador;

import com.gestorFacturas.modelo.Factura;
import com.gestorFacturas.modelo.Gestor_Facturas;
import com.gestorFacturas.vista.Ventana_Facturas;

import javax.swing.SwingUtilities;

/**
 * Controlador: orquesta Vista y Modelo. No valida datos; las validaciones
 * están en Gestor_Facturas, que lanza IllegalArgumentException con el mensaje de error.
 */
public class Controlador_Facturas {
    private final Ventana_Facturas vista;
    private final Gestor_Facturas modelo;

    public Controlador_Facturas(Ventana_Facturas vista, Gestor_Facturas modelo) {
        this.vista = vista;
        this.modelo = modelo;
        modelo.addPropertyChangeListener(evt -> vista.refrescarLista(modelo.getFacturas()));
    }

    public void iniciar() {
        vista.setControlador(this);
        vista.setVisible(true);
    }

    public void anadirOActualizar() {
        try {
            Factura datos = modelo.crearFactura(
                    vista.getAsunto(), vista.getDia(), vista.getMes(), vista.getAnio(),
                    vista.getCantidad(), vista.getTipo());
            Factura seleccionada = vista.getFacturaSeleccionada();

            if (seleccionada == null) {
                modelo.agregar(datos);
                vista.mensaje("Factura añadida correctamente", false);
            } else {
                modelo.actualizar(seleccionada, datos);
                vista.mensaje("Factura actualizada correctamente", false);
            }
        } catch (IllegalArgumentException ex) {
            vista.mensaje(ex.getMessage(), true);
        }
    }

    public void editar() {
        Factura seleccionada = vista.getFacturaSeleccionada();
        if (seleccionada == null) {
            vista.mensaje("Debe seleccionar una factura para editar", true);
            return;
        }
        vista.cargarFactura(seleccionada);
        vista.mensaje("Factura cargada para editar", false);
    }

    public void eliminar() {
        Factura seleccionada = vista.getFacturaSeleccionada();
        if (seleccionada == null) {
            vista.mensaje("Debe seleccionar una factura para eliminar", true);
            return;
        }
        modelo.eliminar(seleccionada);
        vista.mensaje("Factura eliminada correctamente", false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana_Facturas vista = new Ventana_Facturas();
            Gestor_Facturas modelo = new Gestor_Facturas();
            new Controlador_Facturas(vista, modelo).iniciar();
        });
    }
}
