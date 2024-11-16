package ar.edu.unlp.info.oo1.ejercicio23;

import ar.edu.unlp.info.oo1.ejercicio21.BagImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cliente extends Persona
{
    private final List<Pedido> pedidos;

    public Cliente(String nombre, String direccion)
    {
        super(nombre, direccion);
        this.pedidos = new ArrayList<>();
    }

    public void addPedido(Pedido p)
    {
        this.pedidos.add(p);
    }

    public List<Pedido> getPedidos()
    {
        return new ArrayList<>(this.pedidos);
    }

    public HashMap<String, Integer> productosPorCategoria()
    {
        HashMap<String, Integer> productosPorCategoria = new HashMap<>();
        this.getPedidos().stream().forEach(p -> {
            if (productosPorCategoria.containsKey(p.getCategoria())) {
                productosPorCategoria.put(p.getCategoria(), productosPorCategoria.get(p.getCategoria()) + p.getCantidad());
            } else {
                productosPorCategoria.put(p.getCategoria(), p.getCantidad());
            }
        });

        return productosPorCategoria;
    }
}
