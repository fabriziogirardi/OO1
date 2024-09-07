package ar.edu.unlp.info.oo1.practica1.ejercicio2.Interfaces;

import java.time.LocalDate;

public interface ITicket
{
    float impuesto();

    float getPrecioTotal();

    float getPesoTotal();

    int getCantidadDeProductos();

    LocalDate getFecha();
}