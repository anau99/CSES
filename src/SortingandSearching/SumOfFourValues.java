package SortingandSearching;

import java.util.*;

class TwoNumbers{

    //int sum;
    int index1;
    int index2;
    //int sumtwoIndex;
    TwoNumbers(int index1, int index2){
        //this.sum = sum;
        this.index1 = index1;
        this.index2 = index2;
     //   this.sumtwoIndex = index1+index2;
    }
}
public class SumOfFourValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //  long ans = n;
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[]a = new int[n+1];

        for(int i = 1; i<=n;i++){
            a[i] = scanner.nextInt();
           // a[i][1] = i;
        }
        HashMap<Integer,List<TwoNumbers>> listHashMap = new HashMap<>();
        for(int i = 1; i <=n;i++){
            for(int j = i+1;j<=n;j++){
                int sum = a[i]+a[j];
                if(listHashMap.containsKey(sum)){
                    listHashMap.get(sum).add(new TwoNumbers(i,j));
                }
                else {
                    List<TwoNumbers> twoNumbersList = new ArrayList<>();
                    twoNumbersList.add(new TwoNumbers(i,j));
                    listHashMap.put(sum,twoNumbersList);
                }
            }
        }
        List<Integer>ans = new ArrayList<>();
        for(int i = 1; i <=n;i++){
            boolean isOK = false;
            for(int j = i+1;j<=n;j++){
                int sum = a[i]+a[j];
                if(listHashMap.containsKey(x-sum)){
                    for(TwoNumbers twoNumbers : listHashMap.get(x-sum)){
                        //check index distinct
                        Set<Integer>set = new HashSet<>();
                        set.add(i);set.add(j);set.add(twoNumbers.index1);
                        set.add(twoNumbers.index2);
                        if(set.size()==4){
                            ans.add(i);
                            ans.add(j);
                            ans.add(twoNumbers.index1);
                            ans.add(twoNumbers.index2);
                            isOK = true;
                            break;
                        }
                    }
                }
                if(isOK)
                    break;
            }
            if(isOK)
                break;
        }

        if(ans.size()==0 || ans.isEmpty())
            System.out.println("IMPOSSIBLE");
        else {
            for(int i:ans){
                System.out.print(i+" ");
            }
        }

    }
}
