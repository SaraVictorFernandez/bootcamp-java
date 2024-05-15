package katas.java.basicas;
import java.util.Scanner;

class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean hasDivider = false;
        int i = 2;
        while(i < n && !hasDivider) {
            if(n % i == 0){
                hasDivider = true;
            }
            i++;
        }


        if(hasDivider){
            System.out.println("No es primo");
        }
        else {
            System.out.println("Es primo");
        }
        
    }
}
