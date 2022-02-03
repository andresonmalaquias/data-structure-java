package mycollections;

import interfaces.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Andreson
 */
public class ArrayStack<E> implements Stack<E>{
    private static final int CAPACIDATY = 1000;
    private E[] data; // array generico para a informação
    private int t = -1; // indice do elemetno do topo da stack
    
    public ArrayStack(){
        this(CAPACIDATY);
    }
    
    public ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (t + 1);
    }

    @Override
    public boolean isEmpty() {
        return(t == -1);
    }

    @Override
    public void push(E e) throws IllegalStateException{
        if(size() == data.length)
            throw new IllegalStateException("A stack está cheia");
        data[++t] = e;
    }

    @Override
    public E top() {
        if(isEmpty())
            return null;
        return data[t];
    }
    
    @Override
    public E pop() {
        if(isEmpty())
            return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
    
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
    
    public void teste(){
        
    }
    
    private class ArrayIterator implements Iterator<E>{
        private int j = 0;

        @Override
        public boolean hasNext() {
            return j < size();
        }

        @Override
        public E next() {
            if(j == size())
                throw new NoSuchElementException("Sem próximo elemento");
            return data[j++];
        }
        
    }
    
}
