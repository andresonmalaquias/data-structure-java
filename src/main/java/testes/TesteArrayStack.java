package testes;

import interfaces.Stack;
import java.util.Arrays;
import mycollections.*;

/**
 *
 * @author Andreson
 */
public class TesteArrayStack {
    public static void main(String[] args) {
        Integer[] a = {4,8,15,16,23,42};
        System.out.println("a - " + Arrays.toString(a));
        
        //inverter
        System.out.println("Invertendo...");
        Stack<Integer> buffer = new ArrayStack<>(a.length);
        for (int i = 0; i < a.length; i++) {
            buffer.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = buffer.pop();
        }
        System.out.println("a - " + Arrays.toString(a));
        
    }
}
