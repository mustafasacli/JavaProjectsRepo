package mst.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Mustafa SACLI
 * @param <T>
 *
 * @since 1.7
 */
public class JCollection<T> implements IJCollection<T> {

    protected List<T> t_Array = null;//new ArrayList<T>();
    private int count;

    public JCollection() {
        count = 0;
        t_Array = new ArrayList<>();
    }

    public JCollection(int capacity) {
        t_Array = new ArrayList<>(capacity);
        count = 0;
    }

    public JCollection(T... paramsT) {
        count = 0;
        t_Array = new ArrayList<>();
        if (paramsT != null) {
            for (T t : paramsT) {
                if (!this.contains(t)) {
                    t_Array.add(t);
                    count += 1;
                }
            }
        }
    }

    @Override
    public boolean add(T t) {
        boolean result = t_Array.add(t);
        count += 1;
        return result;
    }

    @Override
    public boolean remove(T t) {
        try {
            boolean result = t_Array.remove(t);
            count -= 1;
            return result;

        } catch (Exception exc) {
            throw exc;
        }
    }

    @Override
    public boolean removeAt(int index) {
        try {
            t_Array.remove(index);
            count -= 1;
            return true;

        } catch (Exception exc) {
            throw exc;
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator asIterator() {
        return t_Array.iterator();
    }

    @Override
    public T get(int index) {
        if (isValidIndex(index)) {
            T t = null;
            for (int i = 0; i < count; i++) {

                if (index == i) {
                    t = t_Array.get(i);
                    break;
                }
            }
            return t;
        } else {
            throw new IndexOutOfBoundsException(String.format("Invalid Index : %s", index));
        }
    }

    @Override
    public int indexOf(T t) {
        int index = -1;
        for (int i = 0; i < count; i++) {

            if (t.equals(t_Array.get(i))) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public boolean contains(T t) {
        return indexOf(t) != -1;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        //return null;
        return t_Array.toArray(a);
    }

    @Override
    public Object[] toArray() {
        try {
            return t_Array.toArray();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean isEmpty() {
        return count == 0;//t_Array.isEmpty();
    }

    @Override
    public void clear() {
        t_Array.clear();
        count = 0;
    }

    @Override
    public boolean isValidIndex(int index) {
        return (index > -1 && index < count);
    }
}
