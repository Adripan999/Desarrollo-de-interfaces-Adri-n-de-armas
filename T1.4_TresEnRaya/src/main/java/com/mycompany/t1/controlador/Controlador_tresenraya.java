/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.t1.controlador;

import com.mycompany.t1.vsitas.Vista_Partida;
import com.mycompany.t1.vsitas.Vista_finalPartida;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JButton;

/**
 * Controlador del Tres en raya: contiene toda la lógica del juego.
 * La vista solo dibuja; aquí se decide qué pasa al pulsar cada botón.
 *
 * @author cheot
 */
public class Controlador_tresenraya {

    private static final int VACIA = 0;
    private static final int JUGADOR_1 = 1;
    private static final int JUGADOR_2 = 2;

    private static final int[][] LINEAS_GANADORAS = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8},   
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8},   
        {0, 4, 8}, {2, 4, 6}               
    };

    private final Vista_Partida vistaPartida;
    private final JButton[] botones;
    private final Color colorPorDefecto;
    private final int[] tablero = new int[9];

    private int turno = JUGADOR_1;
    private int jugadas = 0;

    public Controlador_tresenraya(Vista_Partida vistaPartida) {
        this.vistaPartida = vistaPartida;
        this.botones = vistaPartida.getBotones();
        this.colorPorDefecto = botones[0].getBackground();

        for (int i = 0; i < botones.length; i++) {
            final int posicion = i;
            botones[i].addActionListener(e -> jugar(posicion));
        }

        reiniciarPartida();
    }

    public void iniciar() {
        vistaPartida.setVisible(true);
    }

    private void jugar(int posicion) {
        JButton boton = botones[posicion];
        Color colorJugador = (turno == JUGADOR_1) ? Color.BLUE : Color.RED;

        boton.setBackground(colorJugador);
        boton.setEnabled(false);
        tablero[posicion] = turno;
        jugadas++;

        if (hayTresEnRaya()) {
            String nombre = (turno == JUGADOR_1) ? "azul" : "rojo";
            finalizarPartida("¡Gana el " + nombre + "!", colorJugador);
        } else if (jugadas == tablero.length) {
            finalizarPartida("¡Empate!", Color.BLACK);
        } else {
            turno = (turno == JUGADOR_1) ? JUGADOR_2 : JUGADOR_1;
        }
    }

    private boolean hayTresEnRaya() {
        for (int[] linea : LINEAS_GANADORAS) {
            int a = tablero[linea[0]];
            if (a != VACIA && a == tablero[linea[1]] && a == tablero[linea[2]]) {
                return true;
            }
        }
        return false;
    }

    private void finalizarPartida(String mensaje, Color colorMensaje) {
        for (JButton boton : botones) {
            boton.setEnabled(false);
        }

        Vista_finalPartida vistaFinal = new Vista_finalPartida();
        vistaFinal.getLabelMensaje().setText(mensaje);
        vistaFinal.getLabelMensaje().setForeground(colorMensaje);
        vistaFinal.getBotonJugarDeNuevo().addActionListener(e -> {
            vistaFinal.dispose();
            reiniciarPartida();
        });
        vistaFinal.setLocationRelativeTo(vistaPartida);
        vistaFinal.setVisible(true);
    }

    private void reiniciarPartida() {
        Arrays.fill(tablero, VACIA);
        turno = JUGADOR_1;
        jugadas = 0;
        for (JButton boton : botones) {
            boton.setText("");
            boton.setBackground(colorPorDefecto);
            boton.setEnabled(true);
        }
    }
}
