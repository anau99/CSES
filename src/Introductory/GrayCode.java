package Introductory;

import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        generateGrayCode(n);
    }

    public static void generateGrayCode(int n) {
        if (n <= 0) {
            System.out.println("0");
            return;
        }

        List<String> grayCodes = new ArrayList<>();
        grayCodes.add("0");
        grayCodes.add("1");

        for (int i = 2; i < (1 << n); i = i << 1) {
            for (int j = i - 1; j >= 0; j--) {
                grayCodes.add(grayCodes.get(j));
            }

            for (int j = 0; j < i; j++) {
                grayCodes.set(j, "0" + grayCodes.get(j));
            }

            for (int j = i; j < 2 * i; j++) {
                grayCodes.set(j, "1" + grayCodes.get(j));
            }
        }

        for (String code : grayCodes) {
            System.out.println(code);
        }
    }
}
