package Introductory;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeReorder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'A']++;
        }

        int check = 0;
        for (int i = 0; i < 26; i++) {
            check += (a[i] % 2);
        }

        if (check > 1) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if ((a[i] % 2==0)) {
                for (int j = 0; j < a[i] / 2; j++) {
                    result.append((char) (i + 'A'));
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] % 2 == 1) {
                for (int j = 0; j < a[i]; j++) {
                    result.append((char) (i + 'A'));
                }
            }
        }
        for (int i = 25; i >= 0; i--) {
            if ((a[i] % 2)==0) {
                for (int j = 0; j < a[i] / 2; j++) {
                    result.append((char) (i + 'A'));
                }
            }
        }

        System.out.println(result.toString());
    }


}
