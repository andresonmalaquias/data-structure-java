package interfaces;

/**
 *
 * @author Andreson
 */
public interface Stack<E> extends Iterable<E>{
    int size();
    boolean isEmpty();
    E top();
    void push(E element);
    E pop();
}
