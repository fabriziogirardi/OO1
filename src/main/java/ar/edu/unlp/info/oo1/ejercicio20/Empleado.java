package ar.edu.unlp.info.oo1.ejercicio20;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado
{
    private final String         nombre;
    private final String         apellido;
    private final String         cuil;
    private final LocalDate      fechaNacimiento;
    private final boolean        hijos;
    private final boolean        conyuge;
    private final List<Contrato> contratos;

    public Empleado(String nombre, String apellido, String cuil, LocalDate fechaNacimiento, boolean hijos,
                    boolean conyuge)
    {
        this.nombre          = nombre;
        this.apellido        = apellido;
        this.cuil            = cuil;
        this.fechaNacimiento = fechaNacimiento;
        this.hijos           = hijos;
        this.conyuge         = conyuge;
        this.contratos       = new ArrayList<>();
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getApellido()
    {
        return this.apellido;
    }

    public String getCuil()
    {
        return this.cuil;
    }

    public LocalDate getFechaNacimiento()
    {
        return this.fechaNacimiento;
    }

    public boolean hasHijo()
    {
        return this.hijos;
    }

    public boolean hasConyuge()
    {
        return this.conyuge;
    }

    public List<Contrato> getContratos()
    {
        return new ArrayList<>(this.contratos);
    }

    public void addContrato(Contrato contrato)
    {
        if (this.contratos.stream().noneMatch(Contrato::isActivo)) {
            this.contratos.add(contrato);
        }
    }

    public int calcularAntiguedad()
    {
        return (int) (this.contratos.stream()
                                            .mapToLong(Contrato::calcularAntiguedad)
                                            .sum() / 365);
    }

    private double calcularBonusAntiguedad()
    {
        long antiguedad = this.calcularAntiguedad();

        return antiguedad > 20
               ? 2
               : antiguedad > 15
                 ? 1.7
                 : antiguedad > 10
                   ? 1.5
                   : antiguedad > 5
                     ? 1.3
                     : 1;
    }

    public double calcularSueldo()
    {
        return this.contratos.reversed().stream()
                             .filter(Contrato::isActivo)
                             .findFirst()
                             .map(Contrato::calcularSueldoBasico)
                             .orElse(0.0)
               * this.calcularBonusAntiguedad();
    }

    public ReciboDeSueldo generarReciboDeSueldo()
    {
        return new ReciboDeSueldo(this.getNombre(), this.getApellido(), this.getCuil(), this.calcularAntiguedad(),
                                  this.calcularSueldo());
    }
}
