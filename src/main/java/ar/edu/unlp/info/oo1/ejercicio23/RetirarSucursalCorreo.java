package ar.edu.unlp.info.oo1.ejercicio23;

public class RetirarSucursalCorreo implements IFormaDeEnvio
{
    private double getCargoFijo()
    {
        return 3000;
    }

    public double calcularCosto(String direccion1, String direccion2)
    {
        return this.getCargoFijo();
    }
}
