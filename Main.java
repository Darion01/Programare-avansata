
package com.company;

public class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.run();
    }

    private void run() {
        int s;
        System.out.println("Hello World");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);
        n = (n + 3 + 0b10101 + 0xFF)*6;
        while(n>9)
        {
            s = 0;
            while(n != 0)
            {
                s = s + n % 10;
                n = n / 10;
            }
            n = s;
        }
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}
