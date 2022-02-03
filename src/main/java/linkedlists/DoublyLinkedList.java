package linkedlists;

/**
 *
 * @author Andreson
 */
public class DoublyLinkedList<E> {
    private static class Node<E>{
        private E element; //referencia ao elemento
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement(){
            return element;
        }
        
        public Node<E> getPrev(){
            return prev;
        }
        
        public Node<E> getNext(){
            return next;
        }
        
        public void setPrev(Node<E> p){
            prev = p;
        }
        
        public void setNext(Node<E> n){
            next = n;
        }
    }
    
    private Node<E> header = null;
    private Node<E> tailer = null;
    private int size = 0;
    
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        tailer = new Node<>(null, header, null);
        header.setNext(tailer);
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public E first(){
        return tailer.getPrev().getElement();
    }
    
    public E last(){
        return tailer.getNext().getElement();
    }
    
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }
    
    public void addLast(E e){
        addBetween(e, tailer.getPrev(), tailer);
    }
    
    public E removeFirst(){
        if(isEmpty())
            return null;
        return remove(header.getNext());
    }
    
    public E removeLast(){
        if(isEmpty())
            return null;
        return remove(tailer.getPrev());
    }
    
    public void addBetween(E e, Node<E> prodecessor, Node<E> sucessor){
        Node<E> newest = new Node<>(e, prodecessor, sucessor);
        prodecessor.setNext(newest);
        sucessor.setPrev(newest);
        size++;
    }
    
    public E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> sucessor = node.getNext();
        predecessor.setNext(sucessor);
        sucessor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}
