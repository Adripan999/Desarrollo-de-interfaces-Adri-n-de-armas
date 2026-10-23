package com.gestorFacturas.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gestor_Facturas {

    public static final int ASUNTO_MIN = 1;
    public static final int ASUNTO_MAX = 10;
    public static final LocalDate FECHA_MINIMA = LocalDate.of(2000, 1, 1);
    public static final String TIPO_EMPRESAS = "Empresas";
    public static final String TIPO_PARTICULARES = "Particulares";

    private final List<Factura> facturas = new ArrayList<>();
    private final PropertyChangeSupport cambios = new PropertyChangeSupport(this);

    public List<Factura> getFacturas() {
        return Collections.unmodifiableList(facturas);
    }

    /** El asunto debe tener entre 1 y 10 caracteres. Devuelve el asunto sin espacios sobrantes. */
    public String validarAsunto(String asunto) {
        String limpio = (asunto == null) ? "" : asunto.trim();
        if (limpio.length() < ASUNTO_MIN || limpio.length() > ASUNTO_MAX) {
            throw new IllegalArgumentException(
                    "El asunto debe tener entre " + ASUNTO_MIN + " y " + ASUNTO_MAX + " caracteres");
        }
        return limpio;
    }

    public LocalDate validarFecha(int dia, int mes, int anio) {
        LocalDate fecha;
        try {
            fecha = LocalDate.of(anio, mes, dia);
        } catch (DateTimeException ex) {
            throw new IllegalArgumentException("La fecha no es válida");
        }
        if (fecha.isBefore(FECHA_MINIMA)) {
            throw new IllegalArgumentException("La fecha no puede ser anterior al 1 de enero de 2000");
        }
        return fecha;
    }

    public double validarCantidad(String texto) {
        String limpio = (texto == null) ? "" : texto.trim().replace(',', '.');
        if (!limpio.matches("[+-]?(\\d+(\\.\\d*)?|\\.\\d+)")) {
            throw new IllegalArgumentException("La cantidad debe ser un número decimal");
        }
        double cantidad = Double.parseDouble(limpio);
        if (!Double.isFinite(cantidad) || cantidad < 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor o igual que 0");
        }
        return cantidad;
    }

    public String validarTipo(String tipo) {
        if (!TIPO_EMPRESAS.equals(tipo) && !TIPO_PARTICULARES.equals(tipo)) {
            throw new IllegalArgumentException("El tipo debe ser Empresas o Particulares");
        }
        return tipo;
    }

    public Factura crearFactura(String asunto, int dia, int mes, int anio, String cantidad, String tipo) {
        String asuntoValido = validarAsunto(asunto);
        LocalDate fecha = validarFecha(dia, mes, anio);
        double cantidadValida = validarCantidad(cantidad);
        String tipoValido = validarTipo(tipo);
        return new Factura(asuntoValido, fecha, cantidadValida, tipoValido);
    }

    public boolean existeAsunto(String asunto, Factura ignorar) {
        for (Factura f : facturas) {
            if (f != ignorar && f.getAsunto().equalsIgnoreCase(asunto)) return true;
        }
        return false;
    }

    public void agregar(Factura factura) {
        if (existeAsunto(factura.getAsunto(), null)) {
            throw new IllegalArgumentException("Ya existe una factura con ese asunto");
        }
        facturas.add(factura);
        cambios.firePropertyChange("facturas", null, null);
    }

    public void actualizar(Factura original, Factura nuevosDatos) {
        if (existeAsunto(nuevosDatos.getAsunto(), original)) {
            throw new IllegalArgumentException("Ya existe una factura con ese asunto");
        }
        original.setAsunto(nuevosDatos.getAsunto());
        original.setFecha(nuevosDatos.getFecha());
        original.setCantidad(nuevosDatos.getCantidad());
        original.setTipo(nuevosDatos.getTipo());
        cambios.firePropertyChange("facturas", null, null);
    }

    public void eliminar(Factura factura) {
        facturas.remove(factura);
        cambios.firePropertyChange("facturas", null, null);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        cambios.addPropertyChangeListener(listener);
    }
}
