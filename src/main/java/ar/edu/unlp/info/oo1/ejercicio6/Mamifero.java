package ar.edu.unlp.info.oo1.ejercicio6;

import java.time.LocalDate;

public class Mamifero
{
    private String    identificador;
    private String    especie;
    private LocalDate fechaNacimiento;
    private Mamifero  padre;
    private Mamifero  madre;

    public Mamifero()
    {
    }

    public Mamifero(String nombre)
    {
        identificador = nombre;
    }

    public String getIdentificador()
    {
        return identificador;
    }

    public void setIdentificador(String identificador)
    {
        this.identificador = identificador;
    }

    public String getEspecie()
    {
        return especie;
    }

    public void setEspecie(String especie)
    {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getPadre()
    {
        return padre;
    }

    public void setPadre(Mamifero padre)
    {
        this.padre = padre;
    }

    public Mamifero getMadre()
    {
        return madre;
    }

    public void setMadre(Mamifero madre)
    {
        this.madre = madre;
    }

    public Mamifero getAbueloPaterno()
    {
        return this.padre != null ? this.padre.getPadre() : null;
    }

    public Mamifero getAbuelaPaterna()
    {
        return this.padre != null ? this.padre.getMadre() : null;
    }

    public Mamifero getAbueloMaterno()
    {
        return this.madre != null ? this.madre.getPadre() : null;
    }

    public Mamifero getAbuelaMaterna()
    {
        return this.madre != null ? this.madre.getMadre() : null;
    }

    public boolean tieneComoAncestroA(Mamifero mamifero)
    {
        return this.padre == mamifero
               || this.madre == mamifero
               || (this.padre != null && this.padre.tieneComoAncestroA(mamifero))
               || (this.madre != null && this.madre.tieneComoAncestroA(mamifero));
    }
}
