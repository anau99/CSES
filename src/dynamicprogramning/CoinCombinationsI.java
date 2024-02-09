package dynamicprogramning;

import java.util.Scanner;
import java.util.Vector;

public class CoinCombinationsI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int mod = (int) 1e9 + 7;

        Vector<Long> coins = new Vector<>();
        for (int i = 0; i < n; i++) {
            long c = scanner.nextLong();
            coins.add(c);
        }

        Vector<Long> dp = new Vector<>(x + 1);
        for (int i = 0; i <= x; i++) {
            dp.add(0L);
        }

        dp.set(0, 1L);

        for (long i = 1; i <= x; i++) {
            for (long j : coins) {
                if (i - j >= 0) {
                    dp.set((int) i, (dp.get((int) i) + dp.get((int) (i - j))) % mod);
                }
            }
        }

        System.out.println(dp.get(x));
    }
}
