package STACK;
import java.util.Stack;
public class WorldStack{
    public static Stack<String> separarEnStack(String texto){
        Stack<String> stack = new Stack<>();
        String []palabras = texto.split("\\s+");
        for(int i=palabras.length-1; i>=0; i--){
            stack.push(palabras[i]);
        }
    }
}
