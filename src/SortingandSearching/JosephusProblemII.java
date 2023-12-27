package SortingandSearching;

import java.util.*;

public class JosephusProblemII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        TreeSet<Integer>a = new TreeSet<>();
        for(int i = 0; i <n;i++){
            a.add(i+1);
        }

        int start = k;

        while (a.size()!=0){
            start%=a.size();
          //  int remove = (start+k)%a.size();
            Integer temp = a.higher(start);
            System.out.print(temp+" ");
            a.remove(temp);
            start +=k;


        }



    }
}
