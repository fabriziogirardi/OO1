package ar.edu.unlp.info.oo1.ejercicio9;

public abstract class Cuenta
{
    private double saldo;

    public Cuenta()
    {
        this.saldo = 0;
    }

    public double getSaldo()
    {
        return this.saldo;
    }

    public void depositar(double monto)
    {
        this.saldo += monto;
    }

    public boolean extraer(double monto)
    {
        if (this.puedeExtraer(monto))
        {
            this.extraserSinControlar(monto);
            return true;
        }

        return false;
    }

    public boolean transferirACuenta(double monto, Cuenta cuentaDestino)
    {
        if (this.puedeExtraer(monto))
        {
            this.extraserSinControlar(monto);
            cuentaDestino.depositar(monto);
            return true;
        }

        return false;
    }

    protected void extraserSinControlar(double monto)
    {
        this.saldo -= monto;
    }

    protected abstract boolean puedeExtraer(double monto);
}
