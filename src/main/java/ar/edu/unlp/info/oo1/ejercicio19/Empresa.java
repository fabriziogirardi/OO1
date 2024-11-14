package ar.edu.unlp.info.oo1.ejercicio19;

public class Empresa extends Cliente
{
    private final String cuit;

    public Empresa(String nombre, String direccion, String cuit)
    {
        super(nombre, direccion);
        this.cuit = cuit;
    }

    public String getCuit()
    {
        return this.cuit;
    }

    protected double aplicarDescuento(double monto)
    {
        return monto;
    }
}
