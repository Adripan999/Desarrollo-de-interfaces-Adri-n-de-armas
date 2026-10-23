package com.mycompany.t1.controlador;

import com.mycompany.t1.vista.Vista_Calculadora;
import java.awt.Button;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Controlador de la calculadora (patrón MVC).
 *
 * La vista (Vista_Calculadora) solo dibuja la ventana. Este controlador se
 * encarga de:
 *   1. Registrar los listeners de los botones (ratón) y del teclado.
 *   2. Guardar el estado de la calculadora (primer operando, operación pendiente...).
 *   3. Actualizar el display.
 *
 * @author cheot
 */
public class Controlador_Calculadora {

    private final Vista_Calculadora vista;

    private BigDecimal acumulado = BigDecimal.ZERO;
    private String operador = null;
    private boolean nuevoNumero = true;

    public Controlador_Calculadora(Vista_Calculadora vista) {
        this.vista = vista;
        asignarEventosBotones();
        asignarEventosTeclado();
    }

    private void asignarEventosBotones() {
        for (Component c : vista.getPanelBotones().getComponents()) {
            if (!(c instanceof Button)) {
                continue;
            }
            Button boton = (Button) c;
            String texto = boton.getLabel();

            switch (texto) {
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ->
                        boton.addActionListener(e -> eventosNumeros(texto));
                case "." ->
                        boton.addActionListener(e -> eventoDecimal());
                case "+", "-", "*", "/" ->
                        boton.addActionListener(e -> eventosOperaciones(texto));
                case "C" ->
                        boton.addActionListener(e -> limpiar());
                default -> {}
            }
        }

        vista.getBotonResultado().addActionListener(e -> resultado());
    }

    private void asignarEventosTeclado() {
        vista.getDisplay().setEditable(false);

        KeyListener listenerTeclado = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                eventoTeclado(e.getKeyChar());
            }
        };

        vista.addKeyListener(listenerTeclado);
        vista.getDisplay().addKeyListener(listenerTeclado);
        vista.getBotonResultado().addKeyListener(listenerTeclado);
        for (Component c : vista.getPanelBotones().getComponents()) {
            c.addKeyListener(listenerTeclado);
        }

        vista.getBotonResultado().setFocusable(false);
        for (Component c : vista.getPanelBotones().getComponents()) {
            c.setFocusable(false);
        }
    }

    private void eventoTeclado(char tecla) {
        if (tecla >= '0' && tecla <= '9') {
            eventosNumeros(String.valueOf(tecla));
        } else if (tecla == '.' || tecla == ',') {
            eventoDecimal();
        } else if (tecla == '+' || tecla == '-' || tecla == '*' || tecla == '/') {
            eventosOperaciones(String.valueOf(tecla));
        } else if (tecla == '=' || tecla == '\n') {
            resultado();
        } else if (tecla == 'c' || tecla == 'C' || tecla == KeyEvent.VK_ESCAPE) {
            limpiar();
        }
    }

    private void eventosNumeros(String numero) {
        String actual = vista.getDisplay().getText();

        if (nuevoNumero || actual.equals("0")) {
            vista.getDisplay().setText(numero); 
        } else {
            vista.getDisplay().setText(actual + numero);
        }
        nuevoNumero = false;
    }

    private void eventoDecimal() {
        String actual = vista.getDisplay().getText();

        if (nuevoNumero) {
            vista.getDisplay().setText("0.");  // ".534" -> "0.534"
            nuevoNumero = false;
        } else if (!actual.contains(".")) {
            vista.getDisplay().setText(actual + ".");
        }
    }

    
    private void eventosOperaciones(String nuevaOperacion) {
        if (operador != null && !nuevoNumero) {
            BigDecimal res = calcular(acumulado, operador, valorDisplay());
            if (res == null) {
                mostrarError();
                return;
            }
            acumulado = res;
            mostrar(res);
        } else if (operador == null) {
            acumulado = valorDisplay();
        }
        operador = nuevaOperacion;
        nuevoNumero = true;
    }

    private void resultado() {
        if (operador == null) {
            return;
        }
        BigDecimal res = calcular(acumulado, operador, valorDisplay());
        if (res == null) {
            mostrarError();
            return;
        }
        mostrar(res);
        acumulado = res;
        operador = null;
        nuevoNumero = true;
    }

    private void limpiar() {
        acumulado = BigDecimal.ZERO;
        operador = null;
        nuevoNumero = true;
        vista.getDisplay().setText("0");
    }

    private BigDecimal calcular(BigDecimal a, String op, BigDecimal b) {
        switch (op) {
            case "+":
                return a.add(b);
            case "-":
                return a.subtract(b);
            case "*":
                return a.multiply(b);
            case "/":
                if (b.signum() == 0) {
                    return null;
                }
                return a.divide(b, MathContext.DECIMAL64);
            default:
                return b;
        }
    }

    private BigDecimal valorDisplay() {
        try {
            return new BigDecimal(vista.getDisplay().getText());
        } catch (NumberFormatException ex) {
            return BigDecimal.ZERO;
        }
    }

    private void mostrar(BigDecimal numero) {
        vista.getDisplay().setText(numero.stripTrailingZeros().toPlainString());
    }

    private void mostrarError() {
        limpiar();
        vista.getDisplay().setText("Error");
    }
}
