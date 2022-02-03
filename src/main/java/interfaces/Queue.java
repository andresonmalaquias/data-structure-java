package interfaces;

/**
 *
 * @author Andreson
 */
public interface Queue<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    E first();
    void enqueue(E element);
    E dequeue();
}
