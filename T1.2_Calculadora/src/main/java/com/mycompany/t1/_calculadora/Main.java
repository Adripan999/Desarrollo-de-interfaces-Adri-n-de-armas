package com.mycompany.t1._calculadora;

import com.mycompany.t1.controlador.Controlador_Calculadora;
import com.mycompany.t1.vista.Vista_Calculadora;

/**
 * Punto de entrada: crea la vista, le conecta el controlador y muestra la ventana.
 *
 * @author cheot
 */
public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Vista_Calculadora vista = new Vista_Calculadora();
            new Controlador_Calculadora(vista);
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
        });
    }
}
