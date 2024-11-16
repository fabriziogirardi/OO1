package ar.edu.unlp.info.oo1.ejercicio23;

public class Pedido
{
    private final IFormaDePago  formaDePago;
    private final IFormaDeEnvio formaDeEnvio;
    private final Producto      producto;
    private final Vendedor      vendedor;
    private final Cliente       cliente;
    private       int           cantidad;

    public Pedido(Vendedor v, Cliente c, IFormaDePago fdp, IFormaDeEnvio fde, Producto p, int n)
    {
        p.restarStock(n);

        this.vendedor     = v;
        this.cliente      = c;
        this.formaDePago  = fdp;
        this.formaDeEnvio = fde;
        this.producto     = p;
        this.cantidad     = n;
    }

    public Producto getProducto()
    {
        return this.producto;
    }

    public int getCantidad()
    {
        return this.cantidad;
    }

    public Cliente getCliente()
    {
        return this.cliente;
    }

    public Vendedor getVendedor()
    {
        return this.vendedor;
    }

    public IFormaDePago getFormaDePago()
    {
        return this.formaDePago;
    }

    public IFormaDeEnvio getFormaDeEnvio()
    {
        return this.formaDeEnvio;
    }

    public double calcularCosto()
    {
        return this.getFormaDePago().calcularCosto(this.getProducto().calcularCosto(this.getCantidad()))
               + this.getFormaDeEnvio().calcularCosto(getVendedor().getDireccion(), getCliente().getDireccion());
    }

    public String getCategoria()
    {
        return this.producto.getCategoria();
    }
}
