package ar.edu.unlp.info.oo1.ejercicio19;

public class Individuo extends Cliente
{
    private final String dni;

    public Individuo(String nombre, String direccion, String dni)
    {
        super(nombre, direccion);
        this.dni = dni;
    }

    public String getDni()
    {
        return this.dni;
    }

    protected double aplicarDescuento(double monto)
    {
        return monto * 0.9;
    }
}
