package SortingandSearching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JosephusProblemI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer>a = new ArrayList<>();
        for(int i =0; i < n;i++){
            a.add(i+1);
        }
        while (a.size()>1){

            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < a.size();i++){
                if(i%2==1){
                    System.out.print(a.get(i)+" ");
                }
                else {
                    temp.add(a.get(i));
                }
            }
            if(a.size()%2==0)
                a = temp;
            else {
                int starter = temp.get(temp.size()-1);
                temp.remove(temp.size()-1);
                a.clear();
                a.add(starter);
                for(int i = 0; i<temp.size();i++){
                    a.add(temp.get(i));
                }

            }

        }
      //  if(a.size()==1) System.out.print(a.get(0)+" ");
        System.out.print(a.get(0)+" ");

    }
}
