package STACK;
import java.util.*;
public class main {
    public static void main(String[]args){
        Scanner keyb=new Scanner(System.in);
        System.out.print("Insert a string like an operation: ");
        String texto = keyb.nextLine();
        Stack<String> pilaOperar = WorldStack.separarEnStack(texto);
        System.out.print("The result of the operation is: "+calculadora(pilaOperar));
    }
    public static String calculadora(Stack<String>pilaOperar){
        String resultado;
        String[]var = new String[3];
        while(!pilaOperar.isEmpty()){
            var[0]=var[1];
            var[1]=var[2];
            var[2] = pilaOperar.pop();
            switch (var[2]){
                case "+":
                    pilaOperar.push(var[0]+var[1]);
                    break;
                case"-":
                    pilaOperar.push(restarString(var[0], var[1]));
                    break;
                case"@":
                    pilaOperar.push(reverse(var[1]));
                    break;
                case "*":
                    pilaOperar.push(intersectString(var[0], var[1]));
                    break;
            }
        }
        return var[2];
    }
    public static String restarString(String a, String b){
        String resultado="";
        char c;
        for(int i=0; i<a.length(); i++){
            c = a.charAt(i);
            if(b.indexOf(c)==-1){
                resultado = resultado + c;
            }
        }
        return resultado;
    }
    public static String reverse(String a){
        Stack<Character> extraStack = new Stack<>();
        String result = "";
        for(int i=0; i<a.length(); i++){
            extraStack.push(a.charAt(i));
        }
        while(!extraStack.isEmpty()){
            result += extraStack.pop();
        }
        return result;
    }
    public static String intersectString(String a, String b){
        String resultado="";
        char c;
        for(int i=0; i<a.length(); i++){
            c = a.charAt(i);
            if(b.indexOf(c)!=-1 && resultado.indexOf(c)!= -1){
                resultado = resultado + c;
            }
        }
        return resultado;
    }
}
