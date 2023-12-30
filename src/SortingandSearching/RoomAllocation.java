package SortingandSearching;

import java.util.*;

public class RoomAllocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int romID = 1;
        int[][]input = new int[n][3];
        PriorityQueue<Rom>priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a->a.end));
        int[]listRoms = new int[n];
        for(int i = 0; i < n; i++){
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
            input[i][2] = i;
        }
        Arrays.sort(input,(a,b)->a[0]-b[0]);
        priorityQueue.add(new Rom(input[0][1],romID));
        listRoms[input[0][2]] = romID;
        int ans = 0;
        for(int i = 1; i < n;i++){
            Rom peek = priorityQueue.peek();
            if(input[i][0]>peek.end){
                priorityQueue.poll();
                 var updateRom = new Rom(input[i][1],peek.id);
                priorityQueue.add(updateRom);
                listRoms[input[i][2]] = peek.id;

            }
            else {
                romID++;
                listRoms[input[i][2]] = romID;
                priorityQueue.add(new Rom(input[i][1],romID));

            }
            ans = Math.max(ans,priorityQueue.size());

        }
        System.out.println(ans);

        for(int i: listRoms){
           System.out.print(i+" ");

        }


    }
}
class Rom{
    int end;
    int id;
    public Rom(int end, int id){
        this.end = end;
        this.id = id;
    }
}


