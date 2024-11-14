package ar.edu.unlp.info.oo1.ejercicio16;

import java.util.HashSet;

public class EvenNumberSet extends HashSet<Integer>
{
    public boolean add(Integer e)
    {
        if (e % 2 == 0) {
            return super.add(e);
        }

        return false;
    }
}
