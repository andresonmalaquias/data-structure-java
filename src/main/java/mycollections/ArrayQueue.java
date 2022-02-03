package mycollections;

import interfaces.Queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Andreson
 */
public class ArrayQueue<E> implements Queue<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int sz = 0;
    
    public ArrayQueue(){
        this(CAPACITY);
    }
    
    public ArrayQueue(int capacity){
        data = (E []) new Object[capacity];
    }
    
    @Override
    public int size(){
        return sz;
    }
    
    @Override
    public boolean isEmpty(){
        return sz == 0;
    }
    
    @Override
    public void enqueue(E e) throws IllegalStateException{
        if (sz == data.length)
            throw  new IllegalStateException("Queue está cheia");
        
        int avail = (f + sz) %data.length;
        data[avail] = e;
        sz++;
    }
    
    @Override
    public E dequeue(){
        if (isEmpty())
            return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
    
    @Override
    public E first(){
        if(isEmpty())
            return null;
        return data[f];
    }
    
    //iterator para os elementos
    
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<E>{
        private int j;
        
        public ArrayIterator(){
            if(sz==0)
                j = data.length;
            else
                j=f;
        }
        
        public boolean hasNext(){
            return j != data.length;
        }
        
        public E next(){
            if(j == data.length)
                throw new NoSuchElementException("Sem ");
            int j_atual = j;
            j = (j + 1) % data.length;
            if(j==(f+sz)%data.length)
                j=data.length;
            return data[j_atual];
            
        }
        
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
