package SortingandSearching;

import java.util.*;

class NestedRangesCheck {
    static class Triple {
        int x, y, index;

        public Triple(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    static final int maxN = 2 * 100001; // Định nghĩa số lượng phần tử tối đa
    static final int SIZE = 2 * maxN; // Kích thước tối đa

    static int N;
    static int[][] ans = new int[2][maxN];
    static int[] ds = new int[SIZE];
    static Triple[] intervals = new Triple[maxN];
    static TreeSet<Integer> uniqueVals = new TreeSet<>();
    static Map<Integer, Integer> mp = new HashMap<>();

    static void update(int idx, int val) {
        for (int i = idx; i < SIZE; i += -i & i)
            ds[i] += val;
    }

    static int query(int idx) {
        int cnt = 0;
        for (int i = idx; i > 0; i -= -i & i)
            cnt += ds[i];
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            intervals[i] = new Triple(x, y, i);
            uniqueVals.add(x);
            uniqueVals.add(y);
        }

        Arrays.sort(intervals, 0, N, (A, B) -> {
            if (A.x == B.x) {
                return Integer.compare(B.y, A.y);
            } else {
                return Integer.compare(A.x, B.x);
            }
        });

        int valId = 1;
        for (int x : uniqueVals)
            mp.put(x, valId++);

        for (int i = N - 1; i >= 0; i--) {
            int y = mp.get(intervals[i].y);
            int id = intervals[i].index;

            ans[0][id] = query(y);
            update(y, 1);
        }

        Arrays.fill(ds, 0);

        for (int i = 0; i < N; i++) {
            int y = mp.get(intervals[i].y);
            int id = intervals[i].index;

            ans[1][id] = i - query(y - 1);
            update(y, 1);
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((ans[i][j] != 0 ? 1 : 0) + " ");
            }
            System.out.println();
        }

    }
}
