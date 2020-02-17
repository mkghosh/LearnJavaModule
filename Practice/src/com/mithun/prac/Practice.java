package com.mithun.prac;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
        for(int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d", N, i, N*i);
            System.out.println();
        }*/


        // a + 2^i *b
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                int val = (int) (a + Math.pow(2,j) * b);
                System.out.print(val + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
