package testes;

import java.util.Arrays;
import mycollections.ArrayQueue;
import interfaces.Queue;

/**
 *
 * @author Andreson
 */
public class TesteArrayQueue {
    public static void main(String[] args) {
        Integer[] a = {4,8,15,16,23,42};
        System.out.println("a - " + Arrays.toString(a));
        
        //inverter
        System.out.println("Invertendo...");
        Queue<Integer> buffer = new ArrayQueue<>(a.length);
        for (int i = 0; i < a.length; i++) {
            buffer.enqueue(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = buffer.dequeue();
        }
        System.out.println("a - " + Arrays.toString(a));
        
    }    
}
