package ar.edu.unlp.info.oo1.ejercicio21;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BagImpl<T> extends AbstractCollection<T> implements Bag<T> {

    Map<T, Integer> elements;

    public BagImpl() {
        elements = new HashMap<>();
    }

    @Override
    public boolean add(T element) {
        elements.put(element, elements.getOrDefault(element, 0) + 1);
        return true;
    }

    @Override
    public int occurrencesOf(T element) {
        return elements.getOrDefault(element, 0);
    }

    @Override
    public void removeOccurrence(T element) {
        if (elements.containsKey(element)) {
            int count = elements.get(element);
            if (count == 1) {
                elements.remove(element);
            } else {
                elements.put(element, count - 1);
            }
        }
    }

    @Override
    public void removeAll(T element) {
        elements.remove(element);
    }

    @Override
    public int size() {
        return elements.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Iterator<Map.Entry<T, Integer>> entryIterator = elements.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry;
            private int remainingCount;

            @Override
            public boolean hasNext() {
                return remainingCount > 0 || entryIterator.hasNext();
            }

            @Override
            public T next() {
                if (remainingCount == 0) {
                    currentEntry = entryIterator.next();
                    remainingCount = currentEntry.getValue();
                }
                remainingCount--;
                return currentEntry.getKey();
            }

            @Override
            public void remove() {
                removeOccurrence(currentEntry.getKey());
            }
        };
    }
}
