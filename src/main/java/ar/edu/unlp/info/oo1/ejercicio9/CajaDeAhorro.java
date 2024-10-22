package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta
{
    @Override
    protected boolean puedeExtraer(double monto)
    {
        return this.getSaldo() >= (monto * 1.02);
    }

    @Override
    protected void extraserSinControlar(double monto)
    {
        super.extraserSinControlar(monto * 1.02);
    }

    @Override
    public void depositar(double monto)
    {
        super.depositar(monto * 0.98);
    }
}
