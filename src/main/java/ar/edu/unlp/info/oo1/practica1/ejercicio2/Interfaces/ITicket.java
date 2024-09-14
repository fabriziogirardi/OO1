package ar.edu.unlp.info.oo1.practica1.ejercicio2.Interfaces;

import java.time.LocalDate;

public interface ITicket
{
    double impuesto();

    double getPrecioTotal();

    double getPesoTotal();

    int getCantidadDeProductos();

    LocalDate getFecha();
}