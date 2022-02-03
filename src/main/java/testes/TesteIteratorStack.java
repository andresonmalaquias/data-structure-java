package testes;

import java.util.Iterator;
import mycollections.ArrayStack;
import interfaces.Stack;
import mycollections.LinkedStack;

/**
 *
 * @author Andreson
 */
public class TesteIteratorStack {
    public static void main(String[] args) {
        Stack<String> col1 = new ArrayStack<>();
        Stack<String> col2 = new LinkedStack<>();
        col1.push("banana");
        col1.push("abacaxi");
        col1.push("goiaba");
        col1.push("acerola");
        
        Iterator<String> it = col1.iterator();
        while(it.hasNext())
            col2.push(it.next());
        
        for (String val : col2) {
            System.out.println(val);
        }
    }
}
