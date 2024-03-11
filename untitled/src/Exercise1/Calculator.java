package Exercise1;

import java.util.Scanner;

public class Calculator {
    private char operation;
    public Calculator(){
        System.out.println("Welcome to calculator!");
        System.out.println("Enter an operation: +, -, * !");
        Scanner s = new Scanner(System.in);
        operation = s.nextLine().toCharArray()[0];
        System.out.println("Enter a complex number: ");
        Complex a = new Complex(s.nextInt(),s.nextInt());
        System.out.println("Enter the second one:");
        Complex b = new Complex(s.nextInt(),s.nextInt());
        switch (operation){
            case '+':
                printResult(a,b,a.add(b));
                break;
            case '-':
                printResult(a,b,a.sub(b));
                break;
            case '*':
                printResult(a,b,a.mul(b));
                break;
            default:
                System.out.println("Wrong type of input!");
        }
    }

    public void printResult(Complex a, Complex b, Complex result){
        System.out.println(a.toString()+operation+b.toString()+"="+result.toString());
    }


}
