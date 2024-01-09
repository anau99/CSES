package SortingandSearching;

import java.util.*;

public class SlidingWindowMedian {
    static final int sz = 200005;
    static int[] fa = new int[sz];
    static int[] a = new int[sz];
    static int[] bit = new int[sz];
    static int n, k;
    static Map<Integer, Integer> compressed = new HashMap<>();
    static Map<Integer, Integer> decompress = new HashMap<>();

    static int psum(int x, int sum) {
        for (; x > 0; x -= x & -x) sum += bit[x];
        return sum;
    }

    static void add(int x, int val) {
        for (; x < sz; x += x & -x) bit[x] += val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            compressed.put(a[i], 0);
        }

        int index = 1;
        for (Map.Entry<Integer, Integer> entry : compressed.entrySet()) {
            entry.setValue(index++);
            decompress.put(entry.getValue(), entry.getKey());
        }

        for (int i = 1; i <= n; i++) {
            add(compressed.get(a[i]), 1);
            if (i >= k + 1) add(compressed.get(a[i - k]), -1);
            int d = k&1;
            int mid = (k / 2) + d;
            if (i >= k) {
                int lo = 1, hi = 200003, ans = -1;
                while (lo <= hi) {
                    int m = (lo + hi) / 2;
                    if (psum(m, 0) >= mid && psum(m - 1, 0) < mid) {
                        ans = m;
                        break;
                    } else if (psum(m, 0) < mid) lo = m + 1;
                    else hi = m - 1;
                }
                System.out.print(decompress.get(ans)+" ");
            }
        }
    }




}
