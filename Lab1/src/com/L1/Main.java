
package com.L1;

public class Main
{
    public static void main(String[] args)
    {

        System.out.println("Hello World!");


        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};


        int n = (int) (Math.random() * 1000000);


        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        System.out.printf("%d\n", n);


        int result = 0;
        do
        {
            while (n != 0)
            {
                result = result + n % 10;
                n = n / 10;
            }
            System.out.printf("result = %d\n", result);
            n = result;
            result = 0;
        }while(n >= 10);
        result = n;

        System.out.printf("Willy-nilly, this semester I will learn " + languages[result] + ".\n");
    }
}
