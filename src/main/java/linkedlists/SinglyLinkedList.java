package linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Andreson
 */
public class SinglyLinkedList<E> {
    /**
     * Esta class é responsável por conter os dados de cada nodo
     * @param <E> 
     */
    public class Node<E>{
        public E element;
        public Node<E> next;
        
        public Node(E e, Node<E> n){
            this.element = e;
            this.next = n;
        }
        /**
         * Método responsável por retornar o elemento do nodo
         * @return 
         */
        public E getElement(){
            return this.element;
        }
        
        /**
         * método responsável por retornar o próximo nodo
         * @return 
         */
        public Node<E> getNext(){
            return this.next;
        }
        
        public void setNext(Node<E> n){
            next = n;
        }
    }
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    public SinglyLinkedList(){}
    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    public E first(){
        if(isEmpty())
            return null;
        return head.getElement();
    }
    
    public E last(){
        if(isEmpty())
            return null;
        return tail.getElement();
    }
    
    public void addFirst(E e){
        head = new  Node<>(e, head);
        if(size == 0)
            tail = head;
        size++;
    }
    
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    
    public E removeFirst(){
        if(isEmpty())
            return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0)
            tail = null;
        return answer;
    }
    
    public Iterator<E> iterator(){
        return new SLLIterator();
    }
    
    private class SLLIterator implements Iterator<E> {
        private Node<E> cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public E next() {
            if(cursor == null)
                throw new NoSuchElementException("Sem próximo elemento");
            Node<E> current = cursor;
            cursor = cursor.getNext();
            return current.getElement();
        }
        
    }
}
