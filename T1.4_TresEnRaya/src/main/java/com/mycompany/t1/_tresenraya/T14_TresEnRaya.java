/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.t1._tresenraya;

import com.mycompany.t1.controlador.Controlador_tresenraya;
import com.mycompany.t1.vsitas.Vista_Partida;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author cheot
 */
public class T14_TresEnRaya {

    public static void main(String[] args) {
        // Look and feel por defecto de Swing (Metal). Nimbus (el que generaba
        // el diseñador) ignora setBackground() en los botones y no se verían
        // los colores azul/rojo.
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            System.err.println("No se pudo cambiar el look and feel: " + ex.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> {
            Vista_Partida vista = new Vista_Partida();
            Controlador_tresenraya controlador = new Controlador_tresenraya(vista);
            controlador.iniciar();
        });
    }
}
