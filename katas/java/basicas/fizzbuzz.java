package katas.java.basicas;
import java.util.Scanner;

class FizzBuzz {
    // numeros del 1 a n
    // si es divisible entre 3 Fizz
    // si es divisible entre 5 Buzz
    // si es divisible entre 7 Bazz
    // si es divisible entre 15 FizzBuzz
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int newNum = scanner.nextInt();
        if(newNum < 1) return;

        for(int i = 1; i <= newNum; i++) {
            if(i % 15 == 0){
                System.out.print("FizzBuzz");
            }
            else if(i % 3 == 0){
                System.out.print("Fizz");
            }
            else if(i % 5 == 0){
                System.out.print("Buzz");
            }
            else {
                System.out.print(i);
            }
            if(i != newNum) System.out.print(" ");
        }

        scanner.close();
    }
}
