package mst.collection;

import java.util.Iterator;

/**
 *
 * @author Mustafa SACLI
 * @param <T>
 */
public interface IJCollection<T> {
    
    boolean contains(T t);
    
    T get(int index);
    
    int indexOf(T t);
    
    boolean add(T t);
    
    boolean remove(T t);
    
    boolean removeAt(int index);
    
    int size();
    
    boolean isEmpty();
    
    void clear();
    
    Iterator<T> asIterator();
    
    Object[] toArray();
    
    <T> T[] toArray(T[] a);
    
    boolean isValidIndex(int index);
}
