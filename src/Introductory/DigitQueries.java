package Introductory;

import java.util.Arrays;
import java.util.Scanner;

public class DigitQueries {
    public static void main(String[] args) {
        long[]poweroften = new long[19];
        Arrays.fill(poweroften,1);
        for(int i = 1; i<19;i++){
            poweroften[i] = poweroften[i-1]*10;
        }
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for(int i = 0; i < q;i++){
            long index = scanner.nextLong();
            long digitSofar = 0;
            long digitBeforeActualBlock = 0;
            int numberOfdigits=0;
            for(int j = 1; j<=18;j++){
                digitSofar+= (poweroften[j] - poweroften[j-1])*j;
                if(digitSofar>=index){
                    numberOfdigits = j;
                    break;
                }
                digitBeforeActualBlock += (poweroften[j] - poweroften[j-1])*j;
            }
            long smallestValue = poweroften[numberOfdigits-1];
            long largestValue = poweroften[numberOfdigits]-1;
            long besvalue = 0;
            long startingPositionBestValue = 0;
            while (smallestValue <= largestValue){
                long actualValue = (smallestValue+largestValue)/2;
                long startingPostionActualValue = digitBeforeActualBlock + 1+
                        (actualValue-poweroften[numberOfdigits-1])*numberOfdigits;
                if(startingPostionActualValue<=index){
                    if(actualValue>besvalue){
                        besvalue = actualValue;
                        startingPositionBestValue = startingPostionActualValue;
                    }
                    smallestValue = actualValue+1;
                }
                else largestValue = actualValue-1;
            }
            String number = Long.toString((long) besvalue);
            System.out.println(number.charAt((int) index - (int) startingPositionBestValue));
        }

    }
}
