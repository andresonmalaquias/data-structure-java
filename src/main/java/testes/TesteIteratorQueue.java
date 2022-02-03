package testes;

import interfaces.Queue;
import java.util.Iterator;
import mycollections.ArrayQueue;
import mycollections.LinkedQueue;

/**
 *
 * @author Andreson
 */
public class TesteIteratorQueue {
    public static void main(String[] args) {
        Queue<String> col1 = new ArrayQueue<>();
        Queue<String> col2 = new LinkedQueue<>();
        col1.enqueue("banana");
        col1.enqueue("abacaxi");
        col1.enqueue("goiaba");
        col1.enqueue("acerola");
        
        Iterator<String> it = col1.iterator();
        System.out.println("------------Array-----------");
        while(it.hasNext()){
            String aux = it.next();
            col2.enqueue(aux);
            System.out.println(aux);
        }
            
        System.out.println("------------List------------");
        for (String val : col1) {
            System.out.println(val);
        }
    }
}
