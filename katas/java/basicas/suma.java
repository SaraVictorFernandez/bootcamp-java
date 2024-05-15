package katas.java.basicas;
import java.util.Scanner;

class Suma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(a);
        int b = scanner.nextInt();
        int total = a + b;
        System.out.println(total);
        scanner.close();
    }
    
}
